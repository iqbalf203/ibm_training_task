package com.example.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.AlbumNotFoundException;
import com.example.model.ErrorResponseModel;

@ControllerAdvice
public class AlbumExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleAlbumNotFoundException(AlbumNotFoundException e)
	{
		ErrorResponseModel model=new ErrorResponseModel(e.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.ordinal());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

}