package com.example.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exception.GirlException;
import com.example.model.Result;
import com.example.until.ResultUntil;


/**
 *	捕获异常的类
 */
@ControllerAdvice
public class ExceptionHandle {

	private static final Logger logger=LoggerFactory.getLogger(ExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		if(e instanceof GirlException){
			GirlException girlException=(GirlException)e;
			return ResultUntil.error(girlException.getCode(),girlException.getMessage());
		}else{
			logger.error("[系统异常] {}", e);
			return ResultUntil.error(-1, "未知错误");
		}
	}
}
