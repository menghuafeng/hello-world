package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Girl;
import com.example.service.GirlService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private GirlService girlService;
	
	/**
	 * 测试查询一个人员的方法
	 */
	@Test
	public void getOneTest(){
		Girl girl=girlService.getOne(25);
		System.out.println(girl);
		Assert.assertEquals(new Integer(22), girl.getAge());
	}
}
