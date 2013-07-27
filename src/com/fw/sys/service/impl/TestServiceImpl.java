package com.fw.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fw.common.dao.IBaseDao;
import com.fw.common.service.impl.BaseService;
import com.fw.sys.dao.TestDao;
import com.fw.sys.model.Test;
import com.fw.sys.service.TestService;

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
