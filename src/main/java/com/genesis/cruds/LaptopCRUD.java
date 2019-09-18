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

import com.genesis.beans.Laptop;
import com.genesis.util.Util;

public class LaptopCRUD {

	SessionFactory sf;
	Session session;
	Transaction t;
	CriteriaBuilder cb;
	public LaptopCRUD(Util u) {
		sf=u.getSF();
		session=sf.openSession();
		cb=session.getCriteriaBuilder();
		
	}
	
	public void addLaptop(Laptop e) {
		try {
			t=session.beginTransaction();
			session.save(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void updateLaptop(Laptop e) {
		try {
			t=session.beginTransaction();
			session.update(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void deleteLaptop(Laptop e) {
		try{
			t=session.beginTransaction();
			
			session.delete(e);
			t.commit();
		}catch(Exception ex) {
			t.rollback();
			System.out.println("Error:"+ex.getMessage());
		}
	}
	
	public void viewAllLaptop() {
		CriteriaQuery<Laptop> criteriaQuery= cb.createQuery(Laptop.class);
		Root<Laptop> root=criteriaQuery.from(Laptop.class);
        criteriaQuery.select(root);
        Query query=session.createQuery(criteriaQuery);
        @SuppressWarnings("unchecked")
		List<Laptop> l=query.getResultList();
        for(Laptop e:l ) {
        	System.out.println(e);
        }
	}
	
	public Laptop searchLaptop(int id) {
		CriteriaQuery<Laptop> criteriaQuery= cb.createQuery(Laptop.class);
		Root<Laptop> root=criteriaQuery.from(Laptop.class);
        criteriaQuery.select(root).where(cb.equal(root.get("eno"), id));
        Query query=session.createQuery(criteriaQuery);
        try{
        	return (Laptop) query.getSingleResult();
        }
        catch(NoResultException r) {
        	return null;
        }
	}
}
