package com.fw.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.test.dao.TestDao;
import com.fw.test.model.Test;

@Repository("testDao")
public class TestDaoImpl extends BaseHibernateDao<Test,Integer> implements TestDao  {
	
}
