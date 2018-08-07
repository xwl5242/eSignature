package com.ssxxh.esignature.bean;

/**
 * 响应体
 * @author Administrator
 *
 */
public class RespBody {

	/**
	 * 响应code，0：成功，1：失败
	 */
	private String retCode;
	/**
	 * a:如果为盖章请求，返回盖章后文档的名称；b:如果为验证请求，没有返回
	 */
	private String fileName;
	/**
	 * retCode为1时，请求失败原因
	 * retCode为0时，a:如果为盖章请求，返回盖章后文档的下载地址；b:如果为验证请求，返回验证通过详情
	 */
	private String fileMsg;
	
	public RespBody(String retCode, String fileName, String fileMsg) {
		super();
		this.retCode = retCode;
		this.fileName = fileName;
		this.fileMsg = fileMsg;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileMsg() {
		return fileMsg;
	}
	public void setFileMsg(String fileMsg) {
		this.fileMsg = fileMsg;
	}
	@Override
	public String toString() {
		return "RespBody [retCode=" + retCode + ", fileName=" + fileName
				+ ", fileMsg=" + fileMsg + "]";
	}
	
}
