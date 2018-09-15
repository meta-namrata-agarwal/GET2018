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

import com.meta.training.model.JobDetails;
import com.meta.training.model.JobDetails;
import com.meta.training.model.JobDetails;

@Repository
@Transactional
public class JobDetailQuery implements JobDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public JobDetails getJobDetailByJobId(int jid) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class);
		cr.add(Restrictions.eq("jobDetailId", jid));
		return (JobDetails) cr.uniqueResult();
	}

	@Override
	public JobDetails getJobDetailByEmployeeId(int eId) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class);
		cr.add(Restrictions.eq("empCode", eId));
		return (JobDetails) cr.uniqueResult();
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class);
		return (List<JobDetails>) cr.list();
	}

	@Override
	public boolean deleteJobDetails(int empCode) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<JobDetails> delete = cb
				.createCriteriaUpdate(JobDetails.class);
		Root e = delete.from(JobDetails.class);
		delete.set("isActive", 0);
		delete.where(cb.equal(e.get("empCode"),empCode));
		return sessionFactory.getCurrentSession().createQuery(delete)
				.executeUpdate() > 0;
	}

	@Override
	public boolean updateJobDetails(JobDetails jd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createJobDetails(JobDetails jd) {
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
