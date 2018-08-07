package com.ssxxh.esignature.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 电子签章常亮
 * @author xwl
 *
 */
public class ESConst {

	/**
	 * 电子签章参数配置文件名称 
	 */
	public static final String ES_CONST_PROPERTY="esignature.properties";
	/**
	 * 签章接口名称
	 */
	public static final String SEAL_INTERFACE="sealAutoPdf";
	/**
	 * 验证签章接口名称
	 */
	public static final String VARIFY_INTERFACE="pdfVarify";
	/**
	 * 电子签章webservice地址
	 */
	public static String WEBSERVICE_URL;
	/**
	 * 电子签章系统id
	 */
	public static String SYS_ID;
	/**
	 * 电子签章系统用户id
	 */
	public static String USER_ID;
	/**
	 * 电子签章系统用户密码
	 */
	public static String USER_PSD;
	/**
	 * 是否合并模板
	 */
	public static String IS_MERGER;
	/**
	 * 是否加载二维码
	 */
	public static String IS_CODEBAR;
	
	/**
	 * 请求和响应头
	 */
	public static String XML_TITLE;
	
	public static Properties pros = new Properties();
	
	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(ES_CONST_PROPERTY);
			pros = new Properties();
			pros.load(in);
			WEBSERVICE_URL=pros.getProperty("webservice_url");
			SYS_ID=pros.getProperty("sys_id");
			USER_ID=pros.getProperty("user_id");
			USER_PSD=pros.getProperty("user_psd");
			IS_MERGER=pros.getProperty("is_merger");
			IS_CODEBAR=pros.getProperty("is_codebar");
			XML_TITLE=pros.getProperty("xml_title");
		} catch (Exception e) {
		}
	}
	
	/**
	 * 获取配置文件中的属性配置
	 * @param key
	 * @return
	 */
	public static String getConfig(String key){
		return pros.getProperty(key);
	}
}
