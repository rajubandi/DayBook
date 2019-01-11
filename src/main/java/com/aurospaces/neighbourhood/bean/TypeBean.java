/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

/**
 * @author Divya
 *
 */
public class TypeBean {
	private String TypeId;
	private String TypeDesc;
	private String TypeName;
	private String sMsg;

	public String getsMsg() {
		return sMsg;
	}

	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}

	public String getTypeId() {
		return TypeId;
	}

	public void setTypeId(String TypeId) {
		this.TypeId = TypeId;
	}

	public String getTypeDesc() {
		return TypeDesc;
	}

	public void setTypeDesc(String TypeDesc) {
		this.TypeDesc = TypeDesc;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}

}
