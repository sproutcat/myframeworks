package com.fw.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fw.common.controller.BaseController;


@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

	
	
	@RequestMapping(value ="/list")
	public String list(){
		return "authlist";
	}
	
	@RequestMapping(value = "/ToAdd",method = {RequestMethod.GET})
	public String ToAdd(){
		
		return "";
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
	
	
}
