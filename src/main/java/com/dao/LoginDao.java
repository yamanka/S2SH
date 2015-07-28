package com.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class LoginDao extends HibernateDaoSupport{
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory)   
    {   
  
        super.setSessionFactory(sessionFactory);   
    }  
	
	public List getPassByName(String s){
		Session session=super.getSession();
		List list=session.createSQLQuery("select user_password,user_id from t_ticketuser where if_vip='1' and user_name='"+s+"'").list();
		
		return list;
	}
	
}