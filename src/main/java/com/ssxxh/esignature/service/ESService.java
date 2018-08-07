package com.ssxxh.esignature.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssxxh.esignature.bean.RespBody;
import com.ssxxh.esignature.bean.sealDoc.SealDocResponse;
import com.ssxxh.esignature.bean.varityDoc.VarifyDocResponse;
import com.ssxxh.esignature.utils.ESConst;
import com.ssxxh.esignature.utils.SealDocRequestUtils;
import com.ssxxh.esignature.utils.VarifyDocRequestUtils;
import com.ssxxh.esignature.utils.WebServiceUtils;
import com.ssxxh.esignature.utils.XmlUtils;

/**
 * 电子签章服务e-signature-service
 * @author Administrator
 *
 */
public class ESService {
	
	private static Logger log = LoggerFactory.getLogger(ESService.class);

	/**
	 * 文档盖章接口
	 * @param fileNo 盖章后文档在签章系统中的名称，必须保证唯一
	 * @param ruleNo 盖章规则号，在潜在系统中维护
	 * @param filePath 将要盖章的文档的网络地址
	 * @return
	 * @throws Exception
	 */
	public static RespBody sealDoc(String fileNo, String ruleNo,String filePath) throws Exception{
		log.info("文档盖章接口执行开始！fileNo:"+fileNo+",ruleNo:"+ruleNo+",filePath:"+filePath);
		String reqXml = SealDocRequestUtils.reqXmlStr(fileNo, ruleNo, filePath);//获取请求xml
		String respXml = WebServiceUtils.execute(reqXml, ESConst.SEAL_INTERFACE);//调用webservice接口，获取响应xml
		SealDocResponse resp = XmlUtils.parseFromXml(SealDocResponse.class, respXml);//解析并返回调用结果
		SealDocResponse.TreeNode tn = resp.getFileList().getList().get(0);//响应体中的treeNode
		RespBody respBody = new RespBody(tn.getRetCode(), tn.getFileName(),tn.getFileMsg());//转换为普通的响应体
		log.info("文档盖章接口执行结束！respBody："+respBody);
		return respBody;
	}
	
	/**
	 * 文档验证接口
	 * @param fileNo 文档在系统内唯一编号
	 * @param filePath 文档路径
	 * @return
	 * @throws Exception
	 */
	public static RespBody varifyDoc(String fileNo,String filePath) throws Exception{
		log.info("文档验证接口执行开始！fileNo:"+fileNo+",filePath:"+filePath);
		String reqXml = VarifyDocRequestUtils.reqXml(fileNo, filePath);//获取请求xml
		String respXml = WebServiceUtils.execute(reqXml, ESConst.VARIFY_INTERFACE);//调用webservice接口，获取响应xml
		VarifyDocResponse resp = XmlUtils.parseFromXml(VarifyDocResponse.class, respXml);//解析并返回调用结果
		VarifyDocResponse.RetData rd = resp.getRetData();//获取响应体中的响应结果
		RespBody respBody = new RespBody(rd.getRetCode(), "", rd.getFileMsg());
		log.info("文档验证接口执行结束！respBody："+respBody);
		return respBody;
	}
	
	public static byte[] pdf2Byte(String urlStr) throws Exception{
		URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
                //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
	}
}
