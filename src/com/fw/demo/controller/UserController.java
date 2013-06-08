package com.fw.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.common.pagination.Page;
import com.fw.demo.model.User;
import com.fw.demo.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value ="/list")
	public String list(HttpServletRequest request,Model model){
		model.addAttribute("user", userService.listAll());
		return "userlist";
	}
	
	@RequestMapping(value = "/ToAdd",method = {RequestMethod.GET})
	public String ToAdd(){
		
		return "useradd";
	}
	
	@RequestMapping(value ="/ToEdit" ,method = {RequestMethod.GET})
	public String ToEdit(){
		
		return "";
	}
	
	@RequestMapping(value ="/AddAuth")
	public String AddAuth(){
		
		return "";
	}
	
	@RequestMapping(value ="/EditAuth")
	public String EditAuth(){
		
		return "";
	}
	
	
	@RequestMapping(value ="/search")
	@ResponseBody
	public Map<String, Object> search(@RequestParam(value = "pagesize", required = false, defaultValue = "20") int pageSize, 
			@RequestParam(value = "pagenum", required = false, defaultValue = "1") int pageNum){
		Map<String, Object> rel = new HashMap<String, Object>();
		Page<User> users = userService.listAll(pageNum, pageSize);
		rel.put("totalCount", users.getTotalCount());
		rel.put("rel", users.getItems());
		return rel;
	}
	
}
