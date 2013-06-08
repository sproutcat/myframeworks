package com.fw.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.demo.dao.TestDao;
import com.fw.demo.model.Test;

@Repository("testDao")
public class TestDaoImpl extends BaseHibernateDao<Test,Integer> implements TestDao  {
	
}
