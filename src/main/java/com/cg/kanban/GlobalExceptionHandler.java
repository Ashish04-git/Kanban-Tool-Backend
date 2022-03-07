package com.cg.kanban;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.kanban.exception.BacklogException;
import com.cg.kanban.exception.ErrorInfo;
import com.cg.kanban.exception.ProjectException;
import com.cg.kanban.exception.UserException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public @ResponseBody ErrorInfo userException(UserException usr, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), usr.getMessage(), req.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(ProjectException.class)
	public @ResponseBody ErrorInfo projectException(ProjectException proj, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), proj.getMessage(), req.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(BacklogException.class)
	public @ResponseBody ErrorInfo backlogException(BacklogException bck, HttpServletRequest req) {
		
		ErrorInfo error= new ErrorInfo(LocalDateTime.now(), bck.getMessage(), req.getRequestURI());
		return error;
	}

}
