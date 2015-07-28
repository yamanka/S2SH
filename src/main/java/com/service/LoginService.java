package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;

import com.entity.UserEntity;
import freemarker.template.utility.StringUtil;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
public String checkUser(String username,String password){
	List list=loginDao.getPassByName(username);
	if (list.size()>0){
	Object[] obj=(Object[])list.get(0);
	if ( obj[0].equals(password))
		return obj[1].toString();
	}
	return null;
}
public boolean registUser(String username,String password,String realname,String school,String phonenum,String email){
	List lists=loginDao.getPassByName(username);
	if (lists.size()>0) return false;
	UserEntity userEntity=new UserEntity();
	userEntity.setUsername(username);
	userEntity.setUserpassword(password);
	userEntity.setUserrealname(realname);
	userEntity.setUserschool(school);
	userEntity.setUserphonenum(phonenum);
	userEntity.setUseremail(email);
	userEntity.setIfvip("1");
	userEntity.setBsflag("0");
	Date date=new Date();
	userEntity.setCreatedate(date);
	userEntity.setChangedate(date);
	loginDao.getHibernateTemplate().saveOrUpdate(userEntity);
	return true;
}
}
