package com.operation.result;


public class OperationResult {

	private String summary;
	private String detail;
	private String alert;
	private boolean display;
	
	public OperationResult() {}

	public OperationResult(String summary, String detail, String alert, boolean display) {
		super();
		this.summary = summary;
		this.detail = detail;
		this.alert = alert;
		this.display = display;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}
	
}
