package com.genesis.cruds;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.genesis.beans.Project;
import com.genesis.util.Util;

public class ProjectCRUD {

	SessionFactory sf;
	Session session;
	Transaction t;
	CriteriaBuilder cb;
	public ProjectCRUD(Util u) {
		sf=u.getSF();
		session=sf.openSession();
		cb=session.getCriteriaBuilder();
	}
	
	public void addProject(Project e) {
		try {
			t=session.beginTransaction();
			session.save(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void updateProject(Project e) {
		try {
			t=session.beginTransaction();
			session.update(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void deleteProject(Project e) {
		try {
			t=session.beginTransaction();
			session.delete(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void viewAllProject() {
		CriteriaQuery<Project> criteriaQuery= cb.createQuery(Project.class);
		Root<Project> root=criteriaQuery.from(Project.class);
        criteriaQuery.select(root);
        Query query=session.createQuery(criteriaQuery);
        @SuppressWarnings("unchecked")
        List<Project> l=query.getResultList();
        for(Project e:l ) {
        	System.out.println(e);
        }
	}
	
	public Project searchProject(int id) {
		CriteriaQuery<Project> criteriaQuery= cb.createQuery(Project.class);
		Root<Project> root=criteriaQuery.from(Project.class);
        criteriaQuery.select(root).where(cb.equal(root.get("code"), id));
        Query query=session.createQuery(criteriaQuery);
        try{
        	return (Project) query.getSingleResult();
        }
        catch(NoResultException r) {
        	return null;
        }
	}
}
