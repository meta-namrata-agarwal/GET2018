package com.meta.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import org.springframework.transaction.annotation.Transactional;

import com.meta.training.model.Project;
import com.meta.training.model.Skills;

@Repository
@Transactional
public class SkillsQuery implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Skills getSkillsById(int id) {
		Criteria cd=sessionFactory.getCurrentSession().createCriteria(Skills.class);
		cd.add(Restrictions.eq("skillId",id));
		return (Skills) cd.uniqueResult();
		
	}

	@Override
	public List<Skills> getAllSkillss() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Skills.class);
		return (List<Skills>) cr.list();
	}

	@Override
	public boolean deleteSkills(int id) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Skills> delete = cb.createCriteriaUpdate(Skills.class);
		Root e = delete.from(Skills.class);
		delete.set("isActive", 0);
		delete.where(cb.equal(e.get("skillId"),id));
		return sessionFactory.getCurrentSession().createQuery(delete)
				.executeUpdate() > 0;
	}

	@Override
	public boolean updateSkills(Skills Skills) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Skills> update = cb.createCriteriaUpdate(Skills.class);
		Root e = update.from(Skills.class);
		update.set("skillId", Skills.getSkillId());
		update.set("skillName", Skills.getSkillName());
		update.where(cb.equal(e.get("skillId"), Skills.getSkillId()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public boolean createSkills(Skills Skills) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(Skills);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}
	
	
}
