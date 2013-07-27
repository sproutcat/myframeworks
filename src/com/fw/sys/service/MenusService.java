package com.fw.sys.service;

import java.util.List;

import com.fw.common.service.IBaseService;
import com.fw.sys.model.Menus;

public interface MenusService extends IBaseService<Menus, Integer> {

	public void deleteAll();
	
}
