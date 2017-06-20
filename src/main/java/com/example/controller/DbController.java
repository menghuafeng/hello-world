package com.example.controller;

import io.swagger.annotations.ApiOperation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author sks
*
*/
@Controller
@RequestMapping("/mydb")
public class DbController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/getUsers")
	 @ApiOperation(value="测试-getCount", notes="getCount更多说明")
	public List<Map<String, Object>> getDbType() {
		String sql = "select * from users";
		// 查询数据库所有的数据
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		// 遍历所有数据
		for (Map<String, Object> map : list) {
			Set<Entry<String, Object>> entries = map.entrySet();
			if (entries != null) {
				Iterator<Entry<String, Object>> iterator = entries.iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = (Entry<String, Object>) iterator
							.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
				}
			}
		}
		return list;
	}

	@GetMapping("/user/{id}")
	public Map<String, Object> getUser(@PathVariable String id) {
		Map<String, Object> map = null;

		// 获取所有数据
		List<Map<String, Object>> list = getDbType();

		// 匹配对应数据
		for (Map<String, Object> dbmap : list) {

			Set<String> set = dbmap.keySet();

			for (String key : set) {
				if (key.equals("id")) {
					if (dbmap.get(key).equals(id)) {
						map = dbmap;
					}
				}
			}
		}

		if (map == null) {
			map = list.get(0);
		}
		return map;
	}

}
