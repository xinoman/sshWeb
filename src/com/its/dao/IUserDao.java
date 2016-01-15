package com.its.dao;

import java.io.Serializable;

import com.its.entity.User;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:20:56
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public interface IUserDao extends BaseDao<User, Serializable> {
	public User userLogin(String username, String password);

}
