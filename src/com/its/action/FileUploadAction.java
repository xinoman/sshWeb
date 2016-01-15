/**
 * 
 */
package com.its.action;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.its.util.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月24日 下午3:15:22
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
@Controller
@Scope("prototype")
public class FileUploadAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7828731057457850407L;
	
	private static final Log log = LogFactory.getLog(FileUploadAction.class);	

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private List<File> upload;

	// 文件名
	private List<String> uploadFileName;

	// Mime类型
	private List<String> uploadContentType;	
	
	public String fileUploadUI(){
		return "fileUpload";
	}
	
	 // 接受依赖注入的属性
	private String allowTypes;
	private String savePath;	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#addActionError(java.lang.String)
	 */
	@Override
	public void addActionError(String anErrorMessage) {
		// TODO Auto-generated method stub
		if(anErrorMessage.startsWith("the request was rejected because its size")){
			super.addActionError("你上传的文件大小超过允许的大小限制！"); 
		} else {
			super.addActionError(anErrorMessage);
		}		
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		//根据服务器的文件保存地址和原文件名创建目录文件全路径  也可写绝对路径。		
//        String savePath = ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + "\\";
		String savePath = "D:\\IMAGE\\";		
        FileUtil.createDir(savePath);
        log.info("文件保存路径："+ savePath);        
        log.info("允许上传的文件类型："+ this.getAllowTypes());
        
        for(int i=0;i<upload.size();i++){        	
        	log.info("上传的文件类型："+ uploadContentType.get(i)+ " - "+uploadFileName.get(i));
        	FileUtil.copyFile(upload.get(i), new File(savePath+uploadFileName.get(i)));
        }
        return SUCCESS;
       /* if(this.getAllowTypes().indexOf(this.getFileContentType()) != -1){
        	File destFile  = new File(savePath);
       	    FileUtil.copyFile(file, destFile);
    		return SUCCESS;
        } else {
        	//界面错误提示信息
			this.addFieldError("error", this.getFileContentType()+"：文件格式不符合要求！参考格式如下："+ this.getAllowTypes());
        	return ERROR;
        }*/		
		
	}

	/**
	 * @return the upload
	 */
	public List<File> getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}	

	/**
	 * @return the uploadFileName
	 */
	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the uploadContentType
	 */
	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the allowTypes
	 */
	public String getAllowTypes() {
		return allowTypes;
	}

	/**
	 * @param allowTypes the allowTypes to set
	 */
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}

	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}	

}
