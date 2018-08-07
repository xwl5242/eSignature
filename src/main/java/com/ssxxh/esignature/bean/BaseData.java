package com.ssxxh.esignature.bean;

import com.ssxxh.esignature.utils.ESConst;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 签章系统中请求中的基本信息
 * @author Administrator
 *
 */
public class BaseData {

	@XStreamAlias("SYS_ID")
	private String SYS_ID;//应用系统id写死
	@XStreamAlias("USER_ID")
	private String USER_ID;//用户id写死
	@XStreamAlias("USER_PSD")
	private String USER_PSD;//用户密码写死
	public BaseData(){
		this.SYS_ID=ESConst.SYS_ID;
		this.USER_ID=ESConst.USER_ID;
		this.USER_PSD=ESConst.USER_PSD;
	}
	public String getSYS_ID() {
		return SYS_ID;
	}
	public void setSYS_ID(String sYS_ID) {
		SYS_ID = sYS_ID;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PSD() {
		return USER_PSD;
	}
	public void setUSER_PSD(String uSER_PSD) {
		USER_PSD = uSER_PSD;
	}
	
	@Override
	public String toString() {
		return "BaseData [SYS_ID=" + SYS_ID + ", USER_ID=" + USER_ID
				+ ", USER_PSD=" + USER_PSD + "]";
	}
}
