package com.fw.demo.service;

import java.util.List;

import com.fw.common.service.IBaseService;
import com.fw.demo.model.Menus;

public interface MenusService extends IBaseService<Menus, Integer> {

	public void deleteAll();
	
}
