package com.fw.sys.dao;

import com.fw.common.dao.IBaseDao;
import com.fw.sys.model.Menus;

public interface MenusDao extends IBaseDao<Menus, Integer> {

	public void deleteAll();
	
}
