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

import com.genesis.beans.Employee;
import com.genesis.util.Util;

public class EmployeeCRUD {

	SessionFactory sf;
	Session session;
	Transaction t;
	CriteriaBuilder cb;
	int id;
	public EmployeeCRUD(Util u) {
		sf=u.getSF();
		session=sf.openSession();
		cb=session.getCriteriaBuilder();
		try{
        Query query=session.createQuery("select max(eno) from employee");
        
        	id= (Integer) query.getSingleResult();
        }
        catch(Exception r) {
        	id=0;
        }
	}
	
	public int addEmployee(Employee e) {
		try {
			e.setEno(++id);
			t=session.beginTransaction();
			session.save(e);
			t.commit();
			return id; 
		}catch(Exception s) {
			System.out.println(s.getMessage());
			t.rollback();
			id--;
			return -1;
		}
		
	}
	
	public boolean updateEmployee(Employee e) {
		try {
			
			t=session.beginTransaction();
			session.update(e);
			t.commit();
			return true;
		}catch(Exception s) {
			System.out.println(s.getMessage());
			t.rollback();
			return false;
		}
	}
	
	public void deleteEmployee(Employee e) {
		try{
			t=session.beginTransaction();
			session.delete(e);
			t.commit();
		}catch(Exception s) {
			System.out.println("Error:"+s.getMessage());
			t.rollback();
		}
	}
	
	public void viewAllEmployee() {
		CriteriaQuery<Employee> criteriaQuery= cb.createQuery(Employee.class);
		Root<Employee> root=criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        Query query=session.createQuery(criteriaQuery);
        @SuppressWarnings("unchecked")
		List<Employee> l=query.getResultList();
        for(Employee e:l ) {
        	System.out.println(e);
        }
	}
	
	public Employee searchEmployee(int id) {
		CriteriaQuery<Employee> criteriaQuery= cb.createQuery(Employee.class);
		Root<Employee> root=criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(cb.equal(root.get("eno"), id));
        Query query=session.createQuery(criteriaQuery);
        try{
        	return (Employee) query.getSingleResult();
        }
        catch(NoResultException r) {
        	return null;
        }
	}
	
	
}
