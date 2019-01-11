package com.aurospaces.neighbourhood.bean;

public class PathologyTestTypeBean {
	private String testTypeId;
	private String testTypeName;
	private String testDescription;
	private String sMsg;

	public String getsMsg() {
		return sMsg;
	}

	public void setsMsg(String sMsg) {
		this.sMsg = sMsg;
	}

	public String getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(String testTypeId) {
		this.testTypeId = testTypeId;
	}

	public String getTestTypeName() {
		return testTypeName;
	}

	public void setTestTypeName(String testTypeName) {
		this.testTypeName = testTypeName;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

}
