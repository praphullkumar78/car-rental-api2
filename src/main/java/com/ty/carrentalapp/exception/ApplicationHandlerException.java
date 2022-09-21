package com.ty.carrentalapp.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.carrentalapp.dto.ResposneStructure;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<ResposneStructure<String>> hand(NoIdFoundException exception) {

		ResposneStructure<String> resposneStructure = new ResposneStructure<>();
		resposneStructure.setStatus(HttpStatus.NOT_FOUND.value());
		resposneStructure.setMessage("not found ");
		resposneStructure.setData(exception.getMessage());
		return new ResponseEntity<ResposneStructure<String>>(resposneStructure, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> info = new LinkedHashMap<String, String>();

		List<FieldError> errors = ex.getFieldErrors();
		for (FieldError error : errors) {
			String fieldName = error.getField();
			String messageString = error.getDefaultMessage();
			info.put(fieldName, messageString);
		}

		ResposneStructure<Map<String, String>> resposneStructure = new ResposneStructure<>();
		resposneStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		resposneStructure.setMessage("BAD DATA");
		resposneStructure.setData(info);

		return new ResponseEntity<Object>(resposneStructure, HttpStatus.BAD_REQUEST);
	}

}
