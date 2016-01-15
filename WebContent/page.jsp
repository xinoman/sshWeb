<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<s:set var="url" value="%{param.url}" />
<s:set var="urlNameSpace" value="%{param.urlNameSpace}" />
<script type="text/javascript">
	function getCurrentPage(page){
		var a = document.getElementById("indexPageHref");     
	    a.href = '${url}?pageNo='+page;          
	    a.setAttribute("onclick",'');            
	    a.click("return false"); 
	}
</script>
<div style='display: none'>  
   <s:a id="indexPageHref"></s:a>
</div> 
<tr>
	<td colspan="6">
	           共<font color="red"><s:property value="pageResults.totalCount"/></font>条记录&nbsp;
		共<font color="red"><s:property value="pageResults.pageCount"/></font>页 &nbsp;
		每页显示<font color="red"><s:property value="pageResults.pageSize"/></font>条&nbsp;
		当前第<font color="red"><s:property value="pageResults.currentPage"/></font>页&nbsp;
		
		<s:if test="%{pageResults.currentPage == 1}">
			首页 上一页
		</s:if>
		<s:else>
			<s:a href="%{url}?pageNo=1" namespace="%{urlNameSpace}">第一页</s:a>
			<s:a href="%{url}?pageNo=%{pageResults.currentPage-1}" namespace="%{urlNameSpace}">上一页</s:a>
		</s:else> 
		
		<s:if test="%{pageResults.currentPage == pageResults.pageCount}">
			下一页 末页
		</s:if>
		<s:else>						
			<s:a href="%{url}?pageNo=%{pageResults.currentPage+1}" namespace="%{urlNameSpace}">下一页</s:a>
			<s:a href="%{url}?pageNo=%{pageResults.pageCount}" namespace="%{urlNameSpace}">末页</s:a>
		</s:else>					
		
		<select name="indexPage" id="indexPage">
			<s:iterator var="pageResults.pageCount" begin="1" end="pageResults.pageCount" status="s">
			    <option onclick="javascript:getCurrentPage(${s.index+1});" value="${s.index+1}" ${pageResults.currentPage eq s.index+1 ? "selected" : ""}>第${s.index+1}页</option>
			</s:iterator>
		</select>
	<td/>
</tr>
