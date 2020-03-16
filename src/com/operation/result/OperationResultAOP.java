package com.operation.result;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperationResultAOP {
	
	@Autowired
	private OperationResultHolder operationResultHolder;
	
	@After("execution ( * com.operation.result.OperationResultHolder.getOperationResult())")
	public void reset() {
		operationResultHolder.setResetResult();
	}

}
