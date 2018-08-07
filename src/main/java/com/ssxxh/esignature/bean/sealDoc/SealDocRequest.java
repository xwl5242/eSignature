package com.ssxxh.esignature.bean.sealDoc;

import java.util.List;

import com.ssxxh.esignature.bean.BaseData;
import com.ssxxh.esignature.utils.ESConst;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 二维码功能未使用，请求体中的二维码相关字段无实际意义，不用考虑
 * @author xwl
 *
 */
@XStreamAlias("SealDocRequest")
public class SealDocRequest {
	@XStreamAlias("BASE_DATA")
	private BaseData baseData;
	@XStreamAlias("META_DATA")
	private MetaData metaData;
	@XStreamAlias("FILE_LIST")
	private SealDoc4TreeNodeList fileList;
	
	public SealDocRequest(){
		this.baseData=new BaseData();
		this.metaData=new MetaData();
	}
	
	public SealDocRequest(SealDoc4TreeNodeList fileList){
		this.baseData=new BaseData();
		this.metaData=new MetaData();
		this.fileList = fileList;
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

	public SealDoc4TreeNodeList getFileList() {
		return fileList;
	}

	public void setFileList(SealDoc4TreeNodeList fileList) {
		this.fileList = fileList;
	}

	@XStreamAlias("META_DATA")
	static class MetaData{
		@XStreamAlias("IS_MERGER")
		private String isMerger;//是否模板合并写死
		public MetaData(){
			this.isMerger = ESConst.IS_MERGER;
		}
		public String getIsMerger() {
			return isMerger;
		}
		public void setIsMerger(String isMerger) {
			this.isMerger = isMerger;
		}
	}
	
	public static class SealDoc4TreeNodeList {

		@XStreamImplicit(itemFieldName = "TREE_NODE")
		private List<SealDoc4TreeNode> list;

		public SealDoc4TreeNodeList(){}
		
		public SealDoc4TreeNodeList(List<SealDoc4TreeNode> list){
			this.list = list;
		}
		
		public List<SealDoc4TreeNode> getList() {
			return list;
		}

		public void setList(List<SealDoc4TreeNode> list) {
			this.list = list;
		}
		
	}
	
	@XStreamAlias("TREE_NODE")
	public static class SealDoc4TreeNode {
		@XStreamAlias("FILE_NO")
		private String fileNo;//文档名称
		@XStreamAlias("IS_CODEBAR")
		private String isCodebar;//是否加二维码
		@XStreamAlias("CERT_CODEBAR")
		private String certCodebar;//固定写死空
		@XStreamAlias("CODEBAR_TYPE")
		private String codebarType;//二维码类型1:p417,0:QR
		@XStreamAlias("CODEBAR_DATA")
		private String codebarData;//二维码编辑信息
		@XStreamAlias("X_COORDINATE")
		private String xCoordinate;//二维码左右偏移
		@XStreamAlias("Y_COORDINATE")
		private String yCoordinate;//二维码上下偏移
		@XStreamAlias("CODEBAR_SIZE")
		private String codebarSize;//二维码大小
		@XStreamAlias("CODEBAR_PAGE")
		private String codebarPage;//二维码加盖页码1,2,3,-1是最后一页0是所有页
		@XStreamAlias("SEAL_TYPE")
		private String sealType;//
		@XStreamAlias("RULE_TYPE")
		private String ruleType;//
		@XStreamAlias("RULE_NO")
		private String ruleNo;//规则号，多个规则用逗号隔开
		@XStreamAlias("CJ_TYPE")
		private String cjType;//应用场景data是模板数据合成，file是读取FILEPATH文件写死
		@XStreamAlias("REQUEST_TYPE")
		private String requestType;//固定写死空
		@XStreamAlias("FILE_PATH")
		private String filePath;//读取文件路径
		@XStreamAlias("MODEL_NAME")
		private String modelName;//模板名称
		@XStreamAlias("AREA_SEAL")
		private String areaSeal;//
		@XStreamAlias("APP_DATA")
		private AppData appData;//模板数据
		
		public SealDoc4TreeNode(){}
		
		public SealDoc4TreeNode(String fileNo, String ruleNo,String filePath) {
			this.fileNo = fileNo;
			this.isCodebar = ESConst.IS_CODEBAR;
			this.certCodebar = "";
			this.codebarType = "0";
			this.codebarData = "000000000000000000";
			this.xCoordinate = "30000";
			this.yCoordinate = "5000";
			this.codebarSize = "100";
			this.codebarPage = "0";
			this.sealType = "0";
			this.ruleType = "0";
			this.ruleNo = ruleNo;
			this.cjType = "file";
			this.requestType = "0";
			this.filePath = filePath;
			this.modelName = "模板1";
			this.areaSeal = "false";
			this.appData = new AppData();
		}
		
		public String getFileNo() {
			return fileNo;
		}

		public void setFileNo(String fileNo) {
			this.fileNo = fileNo;
		}

		public String getIsCodebar() {
			return isCodebar;
		}

		public void setIsCodebar(String isCodebar) {
			this.isCodebar = isCodebar;
		}

		public String getCertCodebar() {
			return certCodebar;
		}

		public void setCertCodebar(String certCodebar) {
			this.certCodebar = certCodebar;
		}

		public String getCodebarType() {
			return codebarType;
		}

		public void setCodebarType(String codebarType) {
			this.codebarType = codebarType;
		}

		public String getCodebarData() {
			return codebarData;
		}

		public void setCodebarData(String codebarData) {
			this.codebarData = codebarData;
		}

		public String getxCoordinate() {
			return xCoordinate;
		}

		public void setxCoordinate(String xCoordinate) {
			this.xCoordinate = xCoordinate;
		}

		public String getyCoordinate() {
			return yCoordinate;
		}

		public void setyCoordinate(String yCoordinate) {
			this.yCoordinate = yCoordinate;
		}

		public String getCodebarSize() {
			return codebarSize;
		}

		public void setCodebarSize(String codebarSize) {
			this.codebarSize = codebarSize;
		}

		public String getCodebarPage() {
			return codebarPage;
		}

		public void setCodebarPage(String codebarPage) {
			this.codebarPage = codebarPage;
		}

		public String getSealType() {
			return sealType;
		}

		public void setSealType(String sealType) {
			this.sealType = sealType;
		}

		public String getRuleType() {
			return ruleType;
		}

		public void setRuleType(String ruleType) {
			this.ruleType = ruleType;
		}

		public String getRuleNo() {
			return ruleNo;
		}

		public void setRuleNo(String ruleNo) {
			this.ruleNo = ruleNo;
		}

		public String getCjType() {
			return cjType;
		}

		public void setCjType(String cjType) {
			this.cjType = cjType;
		}

		public String getRequestType() {
			return requestType;
		}

		public void setRequestType(String requestType) {
			this.requestType = requestType;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getModelName() {
			return modelName;
		}

		public void setModelName(String modelName) {
			this.modelName = modelName;
		}

		public String getAreaSeal() {
			return areaSeal;
		}

		public void setAreaSeal(String areaSeal) {
			this.areaSeal = areaSeal;
		}

		public AppData getAppData() {
			return appData;
		}

		public void setAppData(AppData appData) {
			this.appData = appData;
		}



		@XStreamAlias("APP_DATA")
		static class AppData{
			@XStreamAlias("Info")
			private Info info;
			public AppData(){
				this.info=new Info();
			}
			public Info getInfo() {
				return info;
			}
			public void setInfo(Info info) {
				this.info = info;
			}
		}
		
		static class Info{
			@XStreamAlias("name")
			private String name;
			public String getName() {
				return name;
			}
			public Info(){
				this.name="SS";
			}
			public void setName(String name) {
				this.name = name;
			}
		}
	}
}
