package com.biddingya.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.biddingya.exception.ExceptionResponse;
import com.biddingya.exception.BiddingyaNotFoundException;

@ControllerAdvice
public class BiddingyaExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BiddingyaNotFoundException.class)
	public ModelAndView handleStoreNotFoundException(BiddingyaNotFoundException ex, WebRequest webRequest) {
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setDescription("No Data Found");
		ModelAndView model = new ModelAndView();
		model.addObject("message", response.getMessage());
		model.addObject("description", response.getDescription());
		model.addObject("dateTime", response.getDateTime());
		model.setViewName("ErrorPage");
		return model;
	}


}
