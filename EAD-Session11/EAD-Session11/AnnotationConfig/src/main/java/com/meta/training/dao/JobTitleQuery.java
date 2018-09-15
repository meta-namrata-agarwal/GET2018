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

import com.meta.training.model.JobTitleMaster;


@Repository
@Transactional
public class JobTitleQuery implements JobTitleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public JobTitleMaster getJobTitleMasterById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(JobTitleMaster.class);
		cr.add(Restrictions.eq("jobCode", id));
		return (JobTitleMaster) cr.uniqueResult();
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMasters() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(JobTitleMaster.class);
		return (List<JobTitleMaster>) cr.list();
	}

	@Override
	public boolean deleteJobTitleMaster(int id) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<JobTitleMaster> delete = cb.createCriteriaUpdate(JobTitleMaster.class);
		Root e = delete.from(JobTitleMaster.class);
		delete.set("isActive", 0);
		delete.where(cb.equal(e.get("jobCode"), id));
		return sessionFactory.getCurrentSession().createQuery(delete)
				.executeUpdate() > 0;
	}

	@Override
	public boolean updateJobTitleMaster(JobTitleMaster jobTitleMaster) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<JobTitleMaster> update = cb.createCriteriaUpdate(JobTitleMaster.class);
		Root e = update.from(JobTitleMaster.class);
		update.set("jobCode", jobTitleMaster.getJobCode());
		update.set("jobTitle", jobTitleMaster.getJobTitle());
		
		update.where(cb.equal(e.get("jobCode"), jobTitleMaster.getJobCode()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public boolean createJobTitleMaster(JobTitleMaster JobTitleMaster) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(JobTitleMaster);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}

	

	
}
