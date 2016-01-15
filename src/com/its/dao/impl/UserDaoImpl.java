package com.its.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.its.dao.IUserDao;
import com.its.entity.User;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:21:07
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Serializable> implements IUserDao {
	
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	/**
	 * 向DAO层注入SessionFactory 
	 */
	@Resource
	private SessionFactory sessionFactory;	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		//需要开启事物，才能得到CurrentSession
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User userLogin(String username,String password) {
		String hql = "from User where username=:username and password=:password";     
        Query query = getSession().createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> list = query.list();
        if(list != null && list.size()>0){
        	//记录用户登录时间
        	User entity = list.get(0);
        	entity.setLastLoginTime(new Date());
        	this.update(entity);
        	return list.get(0);
        }
		return null;
	}	

}
