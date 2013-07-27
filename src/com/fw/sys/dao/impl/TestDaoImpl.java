package com.fw.sys.dao.impl;

import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.sys.dao.TestDao;
import com.fw.sys.model.Test;

@Repository("testDao")
public class TestDaoImpl extends BaseHibernateDao<Test,Integer> implements TestDao  {
	
}
