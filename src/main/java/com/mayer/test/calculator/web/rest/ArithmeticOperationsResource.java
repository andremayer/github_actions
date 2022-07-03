package com.mayer.test.calculator.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayer.test.calculator.domain.dto.OperandDTO;
import com.mayer.test.calculator.domain.dto.ResultDTO;
import com.mayer.test.calculator.exceptions.OperandException;
import com.mayer.test.calculator.service.ArithmeticOperationsService;

@RestController
@RequestMapping("/api")
public class ArithmeticOperationsResource {

	private final ArithmeticOperationsService arithmeticOperationsService;
	private final Logger log = LoggerFactory.getLogger(ArithmeticOperationsResource.class);

	@Autowired
	public ArithmeticOperationsResource(final ArithmeticOperationsService arithmeticOperationsService) {
		this.arithmeticOperationsService = arithmeticOperationsService;
	}

	@PostMapping("/addBrunelo")
	public ResponseEntity<ResultDTO> add(@RequestBody OperandDTO operandDTO) {
		log.debug("REST request to perform the add operation : {}", operandDTO);
		if (operandDTO != null) {
			final ResultDTO resultDTO = this.arithmeticOperationsService.add(operandDTO);
			return ResponseEntity.ok().body(resultDTO);
		}
		return ResponseEntity.badRequest().build();
	}

	
	@PostMapping("/subtract")
	public ResponseEntity<ResultDTO> subtract(@RequestBody OperandDTO operandDTO) {
		if (operandDTO != null) {
			final ResultDTO resultDTO = this.arithmeticOperationsService.subtract(operandDTO);
			return ResponseEntity.ok(resultDTO);
		}
		return ResponseEntity.badRequest().build();
	}
	

	@ExceptionHandler({ ArithmeticException.class, OperandException.class })
	public ResponseEntity<String> handleException(final RuntimeException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
