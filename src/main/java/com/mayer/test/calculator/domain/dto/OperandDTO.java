package com.mayer.test.calculator.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OperandDTO implements Serializable {
	
	private static final long serialVersionUID = 3378723997062490515L;
	private BigDecimal firstOperand;
	private BigDecimal secondOperand;

	public BigDecimal getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(BigDecimal firstOperand) {
		this.firstOperand = firstOperand;
	}

	public BigDecimal getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(BigDecimal secondOperand) {
		this.secondOperand = secondOperand;
	}

}
