package com.fw.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fw.common.dao.IBaseDao;
import com.fw.common.service.impl.BaseService;
import com.fw.test.dao.TestDao;
import com.fw.test.model.Test;
import com.fw.test.service.TestService;

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
