/**
 * 
 */
package com.its.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月16日 下午3:54:32
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class BaseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433247553717009362L;
	
	private int pageNo;//第几页 

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	

}
