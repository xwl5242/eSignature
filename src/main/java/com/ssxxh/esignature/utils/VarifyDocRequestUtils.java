package com.ssxxh.esignature.utils;

import com.ssxxh.esignature.bean.varityDoc.VarifyDocRequest;

/**
 * 文档验证请求工具类
 * @author Administrator
 *
 */
public class VarifyDocRequestUtils {

	/**
	 * 封装文档验证请求xml
	 * @param fileNo 文档在系统中的唯一编号
	 * @param filePath 文档在系统中的路径
	 * @return
	 */
	public static String reqXml(String fileNo,String filePath){
		VarifyDocRequest req = new VarifyDocRequest(fileNo, filePath);//封装请求xml
		return XmlUtils.toXml(req);
	}
}
