/**
 * 
 */
package com.its.filter;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.ApiDescription;
import com.wordnik.swagger.model.Operation;
import com.wordnik.swagger.model.Parameter;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月21日 下午4:37:35
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class ApiAuthorizationFilterImpl implements SwaggerSpecFilter {

	/* (non-Javadoc)
	 * @see com.wordnik.swagger.core.filter.SwaggerSpecFilter#isOperationAllowed(com.wordnik.swagger.model.Operation, com.wordnik.swagger.model.ApiDescription, java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	public boolean isOperationAllowed(Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
		// TODO Auto-generated method stub
		if(true)
			  return true;
		    boolean isAuthorized = checkKey(params, headers);
		    if(isAuthorized) {
		      return true;
		    }
		    else {
		      if(!"GET".equals(operation.method()) || api.path().indexOf("/store") != -1) {
		        return false;
		      }
		      else return true;
		    }
	}

	/* (non-Javadoc)
	 * @see com.wordnik.swagger.core.filter.SwaggerSpecFilter#isParamAllowed(com.wordnik.swagger.model.Parameter, com.wordnik.swagger.model.Operation, com.wordnik.swagger.model.ApiDescription, java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
		// TODO Auto-generated method stub
		if (true)
			return true;
		boolean isAuthorized = checkKey(params, headers);
		if ((parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")) && !isAuthorized)
			return false;
		else
			return true;
	}
	
	public boolean checkKey(Map<String, List<String>> params, Map<String, List<String>> headers) {
		if (true)
			return true;	
		String keyValue = null;
		if (params.containsKey("api_key"))
			keyValue = params.get("api_key").get(0);
		else {
			if (headers.containsKey("api_key"))
				keyValue = headers.get("api_key").get(0);
		}
		if ("special-key".equals(keyValue))
			return true;
		else
			return false;
	}

}
