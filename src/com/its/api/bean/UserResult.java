/**
 * 
 */
package com.its.api.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.its.entity.User;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:32:45
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserResult extends BaseResult {
	
	private List<User> users;

	/**
	 * @param users
	 */
	public UserResult() {
		users = new ArrayList<User>();;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
