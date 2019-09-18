package com.genesis.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
	public SessionFactory getSF() {
		Configuration config=new Configuration().configure();
		return config.buildSessionFactory();
		
	}
}
