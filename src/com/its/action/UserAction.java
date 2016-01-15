package com.its.action;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.its.entity.User;
import com.its.service.IUserService;
import com.its.util.CryptoUtil;
import com.its.util.PageResults;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:32:31
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction {
	
	private static final Log log = LogFactory.getLog(UserAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520367636997416409L;
	
	private String[] ids;
	private User user;
	private PageResults<User> pageResults;	
	
	@Resource
	private IUserService userService;	
	
	/**
	 * @return the ids
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}	
	
	/**
	 * @return the pageResults
	 */
	public PageResults<User> getPageResults() {
		return pageResults;
	}

	/**
	 * @param pageResults the pageResults to set
	 */
	public void setPageResults(PageResults<User> pageResults) {
		this.pageResults = pageResults;
	}

	public String addUI()
	{
		return "addUser";
	}
	
	public String save() throws Exception
	{
		//MD5加密		
		String password = CryptoUtil.doDigest(user.getUsername()+user.getPassword());
		user.setPassword(password);
		userService.addUser(user);		
		return SUCCESS;
	}
	
	public String updateUI() {
		user = userService.findUserById(user.getId());
		return "updateUser";
	}
	
	public String update() throws Exception
	{
		//MD5加密
		String password = CryptoUtil.doDigest(user.getUsername()+user.getPassword());
		user.setPassword(password);
		userService.updateUser(user);
		return SUCCESS;
	}
	
	public String delete()
	{
		log.info("UserAction.deleteUser()" + " id = "+ user.getId());
		userService.deleteUser(user.getId());
		return SUCCESS;
	}
	
	public String deleteSelected()
	{
		log.info("UserAction.deleteUser()" + " ids = "+ ids.length);
		for(int i=0;i<ids.length;i++){
			log.info("删除记录ID:"+ids[i]);
			userService.deleteUser(ids[i]);
		}		
		return SUCCESS;
	}
	
	public String queryAllUser(){
		pageResults = userService.getUserPageList(this.getPageNo(), 5);
		return "userList";
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	
}
