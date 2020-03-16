package com.operation.result;

import org.springframework.stereotype.Component;

@Component
public class OperationResultHolder {
	
	private final static OperationResult operationResult = new OperationResult();
	
	public void setSuccessResult(String detail) {
		operationResult.setSummary("Baþarýlý");
		operationResult.setDetail(detail);
		operationResult.setAlert("alert-success");
		operationResult.setDisplay(true);
	}
	
	public void setDangerResult(String detail) {
		operationResult.setSummary("Error!");
		operationResult.setDetail(detail);
		operationResult.setAlert("alert-danger");
		operationResult.setDisplay(true);
	}
	
	public void setResetResult() {
		operationResult.setSummary("");
		operationResult.setDetail("");
		operationResult.setAlert("");
		operationResult.setDisplay(false);
	}
	
	public OperationResult getOperationResult() {
		return new OperationResult(operationResult.getSummary() , operationResult.getDetail() , operationResult.getAlert() , operationResult.isDisplay());
	}

}
