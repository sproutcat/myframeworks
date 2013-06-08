package com.fw.common.interceptors;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyWebBinding implements WebBindingInitializer {

	public void initBinder(WebDataBinder arg0, WebRequest arg1) {
		arg0.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
