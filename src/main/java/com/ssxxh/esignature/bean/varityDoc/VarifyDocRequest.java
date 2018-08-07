package com.ssxxh.esignature.bean.varityDoc;

import com.ssxxh.esignature.bean.BaseData;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文档验证请求体
 * @author xwl
 *
 */
@XStreamAlias("VerifyDocRequest")
public class VarifyDocRequest {
	@XStreamAlias("BASE_DATA")
	private BaseData baseData;
	@XStreamAlias("META_DATA")
	private MetaData metaData;
	
	public VarifyDocRequest(String fileNo,String filePath){
		this.baseData=new BaseData();
		this.metaData=new MetaData(fileNo,filePath);
	}
	
	public BaseData getBaseData() {
		return baseData;
	}

	public void setBaseData(BaseData baseData) {
		this.baseData = baseData;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	@Override
	public String toString() {
		return "VerifyDocRequest [baseData=" + baseData + ", metaData="
				+ metaData + "]";
	}

	public static class MetaData{
		@XStreamAlias("FILE_NO")
		private String fileNo;//是否模板合并写死
		@XStreamAlias("FILE_PATH")
		private String filePath;
		
		public MetaData(String fileNo, String filePath) {
			super();
			this.fileNo = fileNo;
			this.filePath = filePath;
		}
		public String getFileNo() {
			return fileNo;
		}
		public void setFileNo(String fileNo) {
			this.fileNo = fileNo;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		@Override
		public String toString() {
			return "MetaData [fileNo=" + fileNo + ", filePath=" + filePath
					+ "]";
		}
		
	}
	
}
