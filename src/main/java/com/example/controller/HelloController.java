package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author sks
*
*/
@RestController
@RequestMapping("/hello")
public class HelloController {

	@Value("${cupSize}")
	private String cupSize;
	
	//@GetMapping
	//@PostMapping
	//@PutMapping
	@RequestMapping(value="/say",method=RequestMethod.GET)
	public String say(@RequestParam(value="id",required=false,defaultValue="0") String myId){
		return "ID	:	"+myId;
	}
	
	@GetMapping(value="/woqu")
	public String cupSize(){
		return cupSize;
	}
	
}
