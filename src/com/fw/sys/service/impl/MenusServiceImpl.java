package com.fw.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fw.common.dao.IBaseDao;
import com.fw.common.service.impl.BaseService;
import com.fw.sys.dao.MenusDao;
import com.fw.sys.model.Menus;
import com.fw.sys.service.MenusService;

@Service("menusService")
public class MenusServiceImpl extends BaseService<Menus, Integer> implements MenusService {
	@Autowired
	private MenusDao menusDao;
	

	@Autowired
    @Qualifier("menusDao")
    @Override
	public void setBaseDao(IBaseDao<Menus, Integer> baseDao) {
		this.baseDao = baseDao;
	}


	public void deleteAll() {
		menusDao.deleteAll();
	}

}
