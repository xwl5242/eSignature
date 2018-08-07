package com.ssxxh.esignature.bean.varityDoc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文档验证响应体
 */
@XStreamAlias("VarifyPdfResponse")
public class VarifyDocResponse {

	@XStreamAlias("RetData")
	private RetData retData;
	
	public RetData getRetData() {
		return retData;
	}

	public void setRetData(RetData retData) {
		this.retData = retData;
	}

	@Override
	public String toString() {
		return "VarifyDocResponse [retData=" + retData + "]";
	}

	public static class RetData{
		@XStreamAlias("RET_CODE")
		private String retCode;
		@XStreamAlias("FILE_MSG")
		private String fileMsg;
		public String getRetCode() {
			return retCode;
		}
		public void setRetCode(String retCode) {
			this.retCode = retCode;
		}
		public String getFileMsg() {
			return fileMsg;
		}
		public void setFileMsg(String fileMsg) {
			this.fileMsg = fileMsg;
		}
		@Override
		public String toString() {
			return "RetData [retCode=" + retCode + ", fileMsg=" + fileMsg + "]";
		}
		
	}
}
