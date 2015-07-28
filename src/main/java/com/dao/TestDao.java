package com.dao;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository(value="testDao")
public class TestDao extends HibernateDaoSupport{
	@Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory)   
    {   
  
        super.setSessionFactory(sessionFactory);   
    }  
	public void excuteBySql(String s){
		SQLQuery query=super.getSession().createSQLQuery(s);
		
		query.executeUpdate();
	}
}
