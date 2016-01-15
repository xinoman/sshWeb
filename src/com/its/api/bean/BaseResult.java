/**
 * 
 */
package com.its.api.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:32:40
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BaseResult {
	
	@XmlElement(required = true)
	private String returnCode;
	
	@XmlElement(required = true)
	private String action;

	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

}
