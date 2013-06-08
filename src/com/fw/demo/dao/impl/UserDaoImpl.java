package com.fw.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.demo.dao.UserDao;
import com.fw.demo.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseHibernateDao<User,Integer> implements UserDao {

}
