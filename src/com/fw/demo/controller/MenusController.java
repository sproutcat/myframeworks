package com.fw.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fw.demo.service.MenusService;


/**
 * 
 * <p>Title: MenusController.java</p>
 * <p>Description: 菜单控制器</p>
 * <p>Date: 2013-5-19</p>
 * @author 唐珍果
 * @version 1.0
 */
@Controller
@RequestMapping("/menus")
public class MenusController {
	@Autowired
	private MenusService menusService;
	
	@RequestMapping(value = "/menusList", method = {RequestMethod.GET})
	public String menusList(HttpServletRequest request) {
		
		return "sys/menusList";
	}
}
