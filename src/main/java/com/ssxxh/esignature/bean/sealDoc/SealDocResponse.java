package com.ssxxh.esignature.bean.sealDoc;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 文档盖章响应体
 * @author Administrator
 *
 */
@XStreamAlias("SealDocResponse")
public class SealDocResponse {
	
	@XStreamAlias("FILE_LIST")
	private FileList fileList;
	
	public FileList getFileList() {
		return fileList;
	}

	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "SealDocResponse [fileList=" + fileList + "]";
	}
	
	public class FileList{
		@XStreamImplicit(itemFieldName = "TREE_NODE")
		private List<TreeNode> list;

		public List<TreeNode> getList() {
			return list;
		}
		public void setList(List<TreeNode> list) {
			this.list = list;
		}
		@Override
		public String toString() {
			return "FileList [list=" + list + "]";
		}
	}

	public class TreeNode{
		@XStreamAlias("RET_CODE")
		private String retCode;
		@XStreamAlias("FILE_NAME")
		private String fileName;
		@XStreamAlias("FILE_MSG")
		private String fileMsg;
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
			return "TreeNode [retCode=" + retCode + ", fileName=" + fileName
					+ ", fileMsg=" + fileMsg + "]";
		}
		
	}
}
