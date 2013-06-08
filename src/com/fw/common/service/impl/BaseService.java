package com.fw.common.service.impl;

import com.fw.common.Constants;
import com.fw.common.dao.IBaseDao;
import com.fw.common.pagination.Page;
import com.fw.common.pagination.PageUtil;
import com.fw.common.service.IBaseService;

import java.util.List;

public abstract class BaseService<M extends java.io.Serializable, PK extends java.io.Serializable> implements IBaseService<M, PK> {
    
    protected IBaseDao<M, PK> baseDao;
    
    public abstract void setBaseDao(IBaseDao<M, PK> baseDao);
    

    public M save(M model) {
        baseDao.save(model);
        return model;
    }
    
    public void merge(M model) {
        baseDao.merge(model);
    }

    
    public void saveOrUpdate(M model) {
        baseDao.saveOrUpdate(model);
    }

    
    public void update(M model) {
        baseDao.update(model);
    }
    
    
    public void delete(PK id) {
        baseDao.delete(id);
    }

    
    public void deleteObject(M model) {
        baseDao.deleteObject(model);
    }

    
    public M get(PK id) {
        return baseDao.get(id);
    }

   
    
    
    public int countAll() {
        return baseDao.countAll();
    }

    
    public List<M> listAll() {
        return baseDao.listAll();
    }
    
    public Page<M> listAll(int pn) {

        return this.listAll(pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
    public Page<M> listAllWithOptimize(int pn) {
        return this.listAllWithOptimize(pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
    
    public Page<M> listAll(int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = baseDao.listAll(pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    public Page<M> listAllWithOptimize(int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = baseDao.listAll(pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    
    
    public Page<M> pre(PK pk, int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = baseDao.pre(pk, pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    
    public Page<M> next(PK pk, int pn, int pageSize) {
        Integer count = countAll();
        List<M> items = baseDao.next(pk, pn, pageSize);
        return PageUtil.getPage(count, pn, items, pageSize);
    }
    
    public Page<M> pre(PK pk, int pn) {
        return pre(pk, pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
    public Page<M> next(PK pk, int pn) {
        return next(pk, pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
}
