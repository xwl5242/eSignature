package com.ssxxh.esignature.utils;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * webservice请求工具类
 * @author Administrator
 *
 */
public class WebServiceUtils {
	
	private static Logger log = LoggerFactory.getLogger(WebServiceUtils.class);
	
	/**
	 * 发起webservice请求
	 * @param reqXml 请求中xml字符串
	 * @param interfaceName 访问接口名称
	 */
	public static String execute(String reqXml,String interfaceName) throws Exception{
		log.info("webservice调用开始！reqXml:"+reqXml+",interfaceName:"+interfaceName);
		try {
			String nameSpaceUri = "http://serv";
			Service service = new Service();
			Call call;
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(ESConst.WEBSERVICE_URL));
			call.setOperationName(new QName(nameSpaceUri, interfaceName));
			return (String) call.invoke(new Object[] { reqXml });
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
