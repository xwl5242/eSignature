package com.ssxxh.esignature.utils;

import java.util.ArrayList;
import java.util.List;

import com.ssxxh.esignature.bean.sealDoc.SealDocRequest;

/**
 * 文档盖章请求工具类
 * @author Administrator
 *
 */
public class SealDocRequestUtils {

    /**
     * 获取请求xml字符串
     * @param tnlist treenode集合
     * <TREE_NODE>
	      <FILE_NO>1</FILE_NO>
	      <IS_CODEBAR>false</IS_CODEBAR>
	      <CERT_CODEBAR></CERT_CODEBAR>
	      <CODEBAR_TYPE>0</CODEBAR_TYPE>
	      <CODEBAR_DATA>000000000000000000</CODEBAR_DATA>
	      <X_COORDINATE>30000</X_COORDINATE>
	      <Y_COORDINATE>5000</Y_COORDINATE>
	      <CODEBAR_SIZE>100</CODEBAR_SIZE>
	      <CODEBAR_PAGE>0</CODEBAR_PAGE>
	      <SEAL_TYPE>0</SEAL_TYPE>
	      <RULE_TYPE>0</RULE_TYPE>
	      <RULE_NO>1</RULE_NO>
	      <CJ_TYPE>file</CJ_TYPE>
	      <REQUEST_TYPE>0</REQUEST_TYPE>
	      <FILE_PATH>1</FILE_PATH>
	      <MODEL_NAME>模板1</MODEL_NAME>
	      <AREA_SEAL>false</AREA_SEAL>
	      <APP_DATA>
	        <Info>
	          <name>SS</name>
	        </Info>
	      </APP_DATA>
	   </TREE_NODE>
     * @return 签章请求字符串
     */
    public static String reqXmlStr(List<SealDocRequest.SealDoc4TreeNode> tnlist){
    	SealDocRequest.SealDoc4TreeNodeList filelist = new SealDocRequest.SealDoc4TreeNodeList(tnlist);
    	SealDocRequest req = new SealDocRequest(filelist);
    	return XmlUtils.toXml(req);
    }
    
    /**
     * 获取请求xml字符串
     * @param fileNo 签章后的pdf文件名称
     * @param ruleNo 签章规则，在签章系统的后台设置
     * @param filePath 将要签章的pdf文件
     * @return 签章请求xml字符串
     */
    public static String reqXmlStr(String fileNo, String ruleNo,String filePath ){
    	SealDocRequest.SealDoc4TreeNode tn = new SealDocRequest.SealDoc4TreeNode(fileNo, ruleNo, filePath);
    	List<SealDocRequest.SealDoc4TreeNode> tnlist = new ArrayList<SealDocRequest.SealDoc4TreeNode>();
    	tnlist.add(tn);
    	return reqXmlStr(tnlist);
    }
    
}
