package com.its.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.its.dao.IUserDao;
import com.its.entity.User;
import com.its.service.IUserService;
import com.its.util.PageResults;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:33:49
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.delete(id);
	}

	@Override
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		String hql = "from User";
		list =  userDao.getListByHQL(hql, null);
		return list;
	}

	@Override
	public User userLogin(User user) {
		User object = userDao.userLogin(user.getUsername(), user.getPassword());
		return object;
	}

	@Override
	public User findUserById(String userId) {
		User user = (User)userDao.load(userId);
		return user;
	}

	@Override
	public PageResults<User> getUserPageList(int pageNo, int pageSize) {
		String hql = "from User";
		String countHql = "select count(*) from User";
		return userDao.findPageByFetchedHql(hql, countHql, pageNo, pageSize, null);
	}

}
