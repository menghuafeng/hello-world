package com.example.until;

import com.example.model.Result;

/**
 *一个返回固定格式信息的工具类
 */
public class ResultUntil {
	
	/**
	 * 返回成功的信息
	 * @param object
	 * @return
	 */
	public static Result<Object> success(Object object){
		
		Result<Object> result=new Result<Object>();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		
		return result;
	}
	
	/**
	 * 返回错误的信息
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result error(Integer code,String msg){
		
		Result result=new Result();
		result.setCode(code);
		result.setMsg(msg);
		
		return result;
	}
	/**
	 * 返回错误的信息
	 * @param msg
	 * @return
	 */
	public static Result error(String msg){
		Result result=new Result<>();
		result.setMsg(msg);
		return result;
	}
	
}
