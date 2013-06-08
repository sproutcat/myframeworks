package com.fw.demo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fw.common.dao.hibernate.BaseHibernateDao;
import com.fw.demo.dao.MenusDao;
import com.fw.demo.model.Menus;

@Repository("menusDao")
public class MenusDaoImpl extends BaseHibernateDao<Menus, Integer> implements MenusDao {
	
	public List<Menus> listAll() {
        return list("from Menus where parent is null order by orderNum");
    }

	public void deleteAll() {
		Query q = getSession().createQuery("delete from Menus where 1=1");
		q.executeUpdate();
	}
}
