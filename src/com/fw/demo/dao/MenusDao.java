package com.fw.demo.dao;

import com.fw.common.dao.IBaseDao;
import com.fw.demo.model.Menus;

public interface MenusDao extends IBaseDao<Menus, Integer> {

	public void deleteAll();
	
}
