package com.fw.sys.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fw.sys.model.Menus;
import com.fw.sys.model.User;
import com.fw.sys.service.MenusService;
import com.fw.sys.service.UserService;
import com.google.gson.Gson;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private MenusService menusService;
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss"); 
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET})
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		List<Menus> menus;
		try {
			menus = menusService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
			menus = new ArrayList<Menus>();
		}
		
		request.setAttribute("userName", "admin");
		request.setAttribute("currentDate", formatter.format(new Date()));
		request.setAttribute("menus", new Gson().toJson(getMenusTreeList(menus)));
		return "index";
	}
	
	private List<Object> getMenusTreeList(List<Menus> menus) {
		List<Object> rel = new ArrayList<Object>();
		for(Menus mn : menus) {
			Map<String, Object> obj = new HashMap<String, Object>();
			if(mn.getTarget() != null && !mn.getTarget().isEmpty()) {
				obj.put("id", mn.getTarget());
			}
			obj.put("text", mn.getText());
			if(mn.getChildren() == null || mn.getChildren().isEmpty()) {
				obj.put("leaf", true);
			} else {
				obj.put("expanded", true);
				obj.put("children", getMenusTreeList(mn.getChildren()));
			}
			rel.add(obj);
		}
		return rel;
	}

	@RequestMapping(value = "/list")
	public String login(HttpServletRequest request, User user,Model model){
		try {
			for(User u : userService.listAll()){
				System.out.println(u.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("users", userService.listAll());
		return "userlist";
	}
	
	@RequestMapping(value = "/toAdduser", method = {RequestMethod.GET})
	public String toAdd(HttpServletRequest request){
		
		return "useradd";
	}
	
	@RequestMapping(value = "/adduser", method = {RequestMethod.POST})
	public String addUser(HttpServletRequest request, User user){
		User u = new User();
		u.setName("admin");
		u.setRealName(user.getRealName());
		u.setSubCompany(user.getSubCompany()) ;
		u.setMail(user.getMail());
		u.setMobile(user.getMobile());
		u.setModifytime(new Date());
		u.setCreatetime(new Date());
		u.setStatus("1");
		u.setDepartment(user.getDepartment());
		u.save();
		return "userlist";
	}
	
}
