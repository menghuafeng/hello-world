package com.example.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Girl;
import com.example.model.Result;
import com.example.repository.GirlRepository;
import com.example.service.GirlService;
import com.example.until.ResultUntil;

@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlServcie;
	
	
	public static final Logger logger=LoggerFactory.getLogger(GirlController.class);
	/**
	 * 查询所有
	 */
	@ApiOperation(value = "查找所有")
	@GetMapping(value="/girls")
	public List<Girl> girlList(){
		logger.info("girlList方法执行了");
		return girlRepository.findAll();
	}
	  /**
     * 添加一个女生
     * @return
     */
	@ApiOperation(value = "添加一个人员,但是不知道为毛这个地方不能成功呐")
    @PostMapping(value = "/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { 
            
        	return ResultUntil.error(-1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        
        return ResultUntil.success(girlRepository.save(girl));
    }
	/**
	 * 查找单个
	 */
	@GetMapping(value="/girls/{id}")
	public Girl getOne(@PathVariable("id") Integer id){
		return girlRepository.findOne(id);
	}
	/**
	 * 更新
	 */
	@PutMapping(value="/girls/{id}")
	public Girl update(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize){
		Girl girl=new Girl();
		girl.setCupSize(cupSize);
		girl.setId(id);
		
		return girlRepository.save(girl);
	}
	/**
	 * 删除
	 */
	@DeleteMapping(value="/girls/{id}")
	public void delete(@PathVariable("id") Integer id){
		girlRepository.delete(id);
	}
	/**
	 * 根据非唯一属性查找
	 * 注:此处的访问路径与查询ID的访问路径一致,若是请求方法也一样话,就会查找到两个同样相同的方法,会报错
	 */
	@PostMapping(value="/girls/{age}")
	public List<Girl> findByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	/**
	 * 同时插入两条数据(示例)
	 */
	@PostMapping(value="/girls/insertTwo")
	public void insertTwo(){
		girlServcie.insertTwo();
	}
	
	/**
	 * 根据传入的年龄判断在哪个学习阶段
	 * <10岁 小学
	 * 10~16初中
	 * @throws Exception 
	 * 
	 */
	@PostMapping(value="/girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlServcie.getAge(id);
	} 
	
}
