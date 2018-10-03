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

import com.meta.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {


	@Autowired
	private SessionFactory sessionFactory;

	public Project getProjectById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Project.class);
		cr.add(Restrictions.eq("projectId", id));
		return (Project) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Project.class);
		return (List<Project>) cr.list();
	}

	public boolean updateProject(Project project) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Project> update = cb.createCriteriaUpdate(Project.class);
		Root e = update.from(Project.class);
		update.set("projectId", project.getProjectId());
		update.set("projectName", project.getProjectName());
		update.set("description", project.getDescription());
		update.set("projectLogo", project.getProjectLogo());
		update.set("startDate", project.getStartDate());
		update.set("endDate", project.getEndDate());
		update.set("isActive", project.getIsActive());
		update.where(cb.equal(e.get("projectId"), project.getProjectId()));

		return sessionFactory.getCurrentSession().createQuery(update)
				.executeUpdate() > 0;
	}

	public boolean deleteProject(Project project) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();
		CriteriaUpdate<Project> delete = cb.createCriteriaUpdate(Project.class);
		Root e = delete.from(Project.class);
		delete.set("isActive", 0);
		delete.where(cb.equal(e.get("projectId"), project.getProjectId()));
		return sessionFactory.getCurrentSession().createQuery(delete)
				.executeUpdate() > 0;
	}

	public boolean createProject(Project project) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(project);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			session.close();
		}
	}
}