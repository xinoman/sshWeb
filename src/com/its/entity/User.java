package com.its.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:33:24
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */

@Entity
@Table(name = "T_USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5310047300475316543L;
	
	private String id;
	private String username;
	private String password;
	private int age;	
	private Date lastLoginTime;
	
	/**
	 * 
	 */
	public User() {		
		
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "USERNAME" , length = 20, unique = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD" , length = 20, unique = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "AGE" , length = 10, unique = false )
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "LAST_LOGIN_TIME" , unique = false )
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
