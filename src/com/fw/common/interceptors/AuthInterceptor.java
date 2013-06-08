package com.fw.common.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
/**
 * Ȩ��权限拦截器
 * @author Administrator
 *
 */
public class AuthInterceptor implements HandlerInterceptor {

	//controller之前执行
	
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2) throws Exception {
		
		// TODO 权限验证
		
		//System.out.println("url---------------  " + arg0.getRequestURI());
		return true;
	}
	
	
	
	
	//controller之后执行
	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {

		return new ModelAndView(new RedirectView("loginController.do?login"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//update-begin--Author:zhaojunfu  Date:20130330 for：session 失效跳转(要进行2次跳转，才能将主页面一起跳转)
		request.getRequestDispatcher("index.jso").forward(request, response);
		//update-end--Author:zhaojunfu  Date:20130330 for：session 失效跳转(要进行2次跳转，才能将主页面一起跳转)
	}

}
