package com.meta.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meta.training.model.EmployeeSkills;

@Repository
@Transactional
public class EmployeeSkillsQuery implements EmployeeSkillDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSkills> getEmployeeSkilllsByEmpId(int empCode) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				EmployeeSkills.class);
		cr.add(Restrictions.eq("empCode", empCode));
		return (List<EmployeeSkills>) cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSkills> getmployeeSkilllsBySkillId(int skillId) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				EmployeeSkills.class);
		cr.add(Restrictions.eq("skillId", skillId));
		return (List<EmployeeSkills>) cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeSkills> getAllemployeeSkillls() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				EmployeeSkills.class);
		//cr.add(Restrictions.eq("empCode", empCode));
		return (List<EmployeeSkills>) cr.list();
	}

	@Override
	public boolean deletemployeeSkilllsBySkill(int empCde, int skillId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllEmployeeSkilllsByEmpId(int empCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatemployeeSkillls(int empSkillId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createmployeeSkillls(EmployeeSkills jd) {
//		System.out.println(jd.toString());
//		CriteriaBuilder cb = sessionFactory.getCurrentSession()
//				.getCriteriaBuilder();
//		CriteriaUpdate<EmployeeSkills> update = cb
//				.createCriteriaUpdate(EmployeeSkills.class);
//		Root e = update.from(EmployeeSkills.class);
//		update.set("empCode", jd.getEmpCode());
//		update.set("skillId", jd.getSkillId());
//		update.set("skillCode",jd.getSkillCode());
//		update.where(cb.equal(e.get("empCode"), jd.getEmpCode()));
//
//		return sessionFactory.getCurrentSession().createQuery(update)
//				.executeUpdate() > 0;
		
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(jd);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}

}
