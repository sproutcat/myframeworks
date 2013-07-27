package com.fw.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.sys.model.Test;
import com.fw.sys.service.TestService;


@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/search")
	@ResponseBody
	public List<Test> search() {
		List<Test> rel;
		try {
			rel = testService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
			rel = new ArrayList<Test>();
		}
		return rel;
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public Map<String, Object> add(@RequestParam Test model) {
		Map<String, Object> msg = new HashMap<String, Object>();
		testService.save(model);
		msg.put("rel", "success");
		msg.put("msg", "成功新增记录！");
		return msg;
	}
}
