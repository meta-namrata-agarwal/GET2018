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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meta.training.model.Employee;
import com.meta.training.model.Employee;
import com.meta.training.model.Employee;

@Repository
@Transactional
public class EmployeeQuery implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public static String jobDetails = "select jd.dateOfJoining, jd.totalExp,jt.jobTitle,p.projectName,e1.firstName,e2.firstName from jobdetails jd"
			+ " inner join jobtitlemaster jt"
			+ " inner join project p"
			+ " inner join employee e1"
			+ " inner join employee e2 "
			+ " where jd.empCode=? and jt.jobCode=jd.jobCode and e1.empCode=jd.reportingManagerId and e2.empCode=jd.teamLeadId and p.projectId=jd.currProjId";

	@Override
	public Employee getEmployeeById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		cr.add(Restrictions.eq("empCode", id));
		return (Employee) cr.uniqueResult();
	}

	@Override
	public Employee getEmployeeByMail(String email) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		cr.add(Restrictions.eq("emailId", email));
		return (Employee) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		cr.add(Restrictions.eq("isActive", true));
		return (List<Employee>) cr.list();
	}

	@Override
	public boolean deleteEmployee(int id) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Employee> delete = cb
				.createCriteriaUpdate(Employee.class);
		Root e = delete.from(Employee.class);
		delete.set("isActive", 0);
		delete.where(cb.equal(e.get("empCode"), id));
		return sessionFactory.getCurrentSession().createQuery(delete)
				.executeUpdate() > 0;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Employee> update = cb
				.createCriteriaUpdate(Employee.class);
		Root e = update.from(Employee.class);
		update.set("empCode", emp.getEmpCode());
		update.set("firstName", emp.getFirstName());
		update.set("lastName", emp.getLastName());
		update.set("dob", emp.getDob());
		update.set("emailId", emp.getEmailId());
		update.set("isActive", emp.getIsActive());
		update.set("gender", emp.getGender());
		update.set("primaryContact", emp.getPrimaryContact());
		update.set("secondaryContact", emp.getSecondaryContact());
		update.set("skypeId", emp.getSkypeId());
		update.set("profilePicture", emp.getProfilePicture());
		update.where(cb.equal(e.get("empCode"), emp.getEmpCode()));
		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	@Override
	public boolean createEmployee(Employee emp) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> empByName(String firstName) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		cr.add(Restrictions.eq("firstName", firstName));
		return (List<Employee>) cr.list();
	}

	@Override
	public Employee loginParameter(String email, String password) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		cr.add(Restrictions.eq("emailId", email));
		cr.add(Restrictions.eq("password", password));
		return (Employee) cr.uniqueResult();
	}

	@Override
	public List<Employee> getEmpByName(String name) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		String[] nameDivide = name.split(" ");
		Criterion r1 = Restrictions.or(
				Restrictions.like("firstName", "%" + nameDivide[0] + "%"),
				Restrictions.like("lastName", "%" + nameDivide[0] + "%"));
		if (nameDivide.length == 1) {

			cr.add(r1);
		} else {
			Criterion r2 = Restrictions.and(
					Restrictions.like("firstName", "%" + nameDivide[0] + "%"),
					Restrictions.like("lastName", "%" + nameDivide[1] + "%"));
			// cr.add(Restrictions
			// .disjunction()
			// .add(Restrictions.like("firstName", "%"+name+"%"))
			// .add(Restrictions.like("lastName", "%"+name+"%")));
			// .add(Restrictions.disjunction()
			// .add(Restrictions.like("firstName", "%"+name+"%"))
			// .add(Restrictions.eq("lastName", "%"+name+"%"))));
			cr.add(Restrictions.or(r1, r2));
		}
		return (List<Employee>) cr.list();

	}

}
