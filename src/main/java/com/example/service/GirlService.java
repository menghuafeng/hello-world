package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enums.ResultEnum;
import com.example.exception.GirlException;
import com.example.model.Girl;
import com.example.repository.GirlRepository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	/**
	 * 例子:直接插入两条数据
	 */
	@Transactional
	public void insertTwo(){
		Girl girlA=new Girl();
		girlA.setAge(19);
		girlA.setCupSize("A");
		girlRepository.save(girlA);
		
		Girl girlB=new Girl();
		girlB.setAge(20);
		girlB.setCupSize("BBB");
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id) throws Exception{
		Girl girl=girlRepository.findOne(id);
		Integer age=girl.getAge();
		//利用异常抛出的方式打印信息
		if(age<10){
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age>10&&age<16){
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
			
		}
		
	}
	
	public Girl getOne(Integer id){
		return girlRepository.getOne(id);
	}
}
