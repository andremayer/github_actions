package com.mayer.test.calculator.service.impl;

import static com.mayer.test.calculator.exceptions.ApiExceptions.FIRST_OPERAND_IS_NULL;
import static com.mayer.test.calculator.exceptions.ApiExceptions.SECOND_OPERAND_IS_NULL;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayer.test.calculator.domain.dto.OperandDTO;
import com.mayer.test.calculator.domain.dto.ResultDTO;
import com.mayer.test.calculator.exceptions.ApiExceptions;
import com.mayer.test.calculator.exceptions.OperandException;
import com.mayer.test.calculator.service.ArithmeticOperationsService;

@Service
public class ArithmeticOperationsServiceImpl implements ArithmeticOperationsService {

	@Autowired
	public ArithmeticOperationsServiceImpl() {

	}

	@Override
	public ResultDTO add(OperandDTO dto) {
		final BigDecimal firstOperand = getOperand(dto.getFirstOperand(), FIRST_OPERAND_IS_NULL);
		final BigDecimal secondOperand = getOperand(dto.getSecondOperand(), SECOND_OPERAND_IS_NULL);

		final BigDecimal result = firstOperand.add(secondOperand);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResult(result);
		return resultDTO;
	}

	@Override
	public ResultDTO subtract(OperandDTO dto) {
		final BigDecimal firstOperand = getOperand(dto.getFirstOperand(), FIRST_OPERAND_IS_NULL);
		final BigDecimal secondOperand = getOperand(dto.getSecondOperand(), SECOND_OPERAND_IS_NULL);

		final BigDecimal resultSubtract = firstOperand.subtract(secondOperand);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResult(resultSubtract);
		return resultDTO;
	}

	private BigDecimal getOperand(final BigDecimal operand, final ApiExceptions exception) {
		return Optional.ofNullable(operand).orElseThrow(() -> new OperandException(exception));
	}

}
