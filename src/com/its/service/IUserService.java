package com.its.service;

import java.util.List;

import com.its.entity.User;
import com.its.util.PageResults;


/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:34:00
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public interface IUserService {
	
	public void addUser(User user);
	public User findUserById(String userId);
	public void updateUser(User user);
	public void deleteUser(String id);
	public List<User> getUserList();
	public PageResults<User> getUserPageList(int pageNo, int pageSize);
	public User userLogin(User user);

}
