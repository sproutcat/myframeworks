package com.fw.sys.dao.impl;

import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.sys.dao.UserDao;
import com.fw.sys.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDao<User,Integer> implements UserDao {

}
