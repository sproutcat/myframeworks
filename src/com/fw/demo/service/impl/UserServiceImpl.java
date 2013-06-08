package com.fw.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fw.common.dao.IBaseDao;
import com.fw.common.service.impl.BaseService;
import com.fw.demo.dao.UserDao;
import com.fw.demo.model.User;
import com.fw.demo.service.UserService;


@Service("userService")
public class UserServiceImpl extends BaseService<User, Integer> implements UserService {

		@Autowired
		private UserDao userDao;

		@Autowired
	    @Qualifier("userDao")
	    @Override
	    public void setBaseDao(IBaseDao<User, Integer> userDao) {
	        this.baseDao = userDao;
	        this.userDao = (UserDao) userDao;
	    }



}
