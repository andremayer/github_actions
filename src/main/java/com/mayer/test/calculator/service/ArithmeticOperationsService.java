package com.mayer.test.calculator.service;

import com.mayer.test.calculator.domain.dto.OperandDTO;
import com.mayer.test.calculator.domain.dto.ResultDTO;

public interface ArithmeticOperationsService {
	
	ResultDTO add(OperandDTO dto);

	ResultDTO subtract(OperandDTO dto);

}
