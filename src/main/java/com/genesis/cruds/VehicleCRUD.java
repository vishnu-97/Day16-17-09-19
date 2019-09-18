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

import com.genesis.beans.Vehicle;
import com.genesis.util.Util;

public class VehicleCRUD {
	
	SessionFactory sf;
	Session session;
	Transaction t;
	CriteriaBuilder cb;
	public VehicleCRUD(Util u) {
		sf=u.getSF();
		session=sf.openSession();
		cb=session.getCriteriaBuilder();
	}
	
	public void addVehicle(Vehicle e) {
		try {
			t=session.beginTransaction();
			session.save(e);
			t.commit();
		}catch(Exception s) {
			System.out.println(s.getMessage());
			t.rollback();
		}
	}
	
	public void updateVehicle(Vehicle e) {
		try {
			t=session.beginTransaction();
			session.update(e);
			t.commit();
		}catch(Exception s) {
			System.out.println(s.getMessage());
			t.rollback();
		}
	}
	
	public void deleteVehicle(Vehicle e) {
		try {	
			t=session.beginTransaction();
			session.delete(e);
			t.commit();
		}catch(Exception s) {
			System.out.println(s.getMessage());
			t.rollback();
		}
	}
	
	public void viewAllVehicle() {
		CriteriaQuery<Vehicle> criteriaQuery= cb.createQuery(Vehicle.class);
		Root<Vehicle> root=criteriaQuery.from(Vehicle.class);
        criteriaQuery.select(root);
        Query query=session.createQuery(criteriaQuery);
        @SuppressWarnings("unchecked")
        List<Vehicle> l=query.getResultList();
        for(Vehicle e:l ) {
        	System.out.println(e);
        }
	}
	
	public Vehicle searchVehicle(String id) {
		CriteriaQuery<Vehicle> criteriaQuery= cb.createQuery(Vehicle.class);
		Root<Vehicle> root=criteriaQuery.from(Vehicle.class);
        criteriaQuery.select(root).where(cb.equal(root.get("regno"), id));
        Query query=session.createQuery(criteriaQuery);
        try{
        	return (Vehicle) query.getSingleResult();
        }
        catch(NoResultException r) {
        	return null;
        }
	}

}
