package com.fw.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fw.common.dao.IBaseDao;
import com.fw.common.service.impl.BaseService;
import com.fw.demo.dao.TestDao;
import com.fw.demo.model.Test;
import com.fw.demo.service.TestService;

@Service("testService")
public class TestServiceImpl extends BaseService<Test, Integer> implements TestService {
	@Autowired
	private TestDao testDao;

	@Autowired
    @Qualifier("testDao")
    @Override
    public void setBaseDao(IBaseDao<Test, Integer> baseDao) {
        this.baseDao = baseDao;
        this.testDao = (TestDao) baseDao;
    }

}
