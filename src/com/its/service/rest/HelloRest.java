/**
 * 
 */
package com.its.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.its.api.bean.UserResult;
import com.its.service.IUserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:33:54
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：
 * 视图部分： swagger-ui是一系列css\js资源，它通过html页面向用户展示一个应用的RESTful API信息。它通过向swagger-core后台模块发送ajax请求获取必要的信息。
 * 后台部分： swagger-core通过 @com.wordnik.swagger.annotations.Api、 @com.wordnik.swagger.annotations.ApiOperation这样的注解，即可让swagger知道你的API信息，从而以json格式应答web页面的ajax请求。
 */
@Path("/v1/wefolder")
@Produces({"application/json"})
@Api(value = "/v1/wefolder", description = "Hello Restful API")
@Controller
public class HelloRest {
	
	private static final Log log = LogFactory.getLog(HelloRest.class);	
	
	public static final String STANDARD_RETURN_CODE = "<b>returnCode</b> - <br>50000: Success<br>40000: Fail<br>E10001: Timeout<br>";
	
	@Autowired
	private IUserService userService;	
	
	@GET	
	@Path("/getInfo/")
	@Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Say Hello", response = UserResult.class, notes = "sayHello<br><br>"
			+ STANDARD_RETURN_CODE)
	public UserResult sayHello() {
		UserResult result = new UserResult();
		result.setAction("getInfo");
		result.setReturnCode("50000");
		result.setUsers(userService.getUserList());
		log.info("记录总数："+userService.getUserList().size());
		return result;
	}

	@GET
	@Path("/{param}")
	@Produces("text/plain;charset=UTF-8")
	public String sayHelloToUTF8(@PathParam("param") String username) {
		return "Hello " + username;
	}

}
