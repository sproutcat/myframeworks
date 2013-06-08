package com.fw.common.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.common.util.SpringContextUtil;
import com.fw.demo.dao.MenusDao;
import com.fw.demo.model.Menus;
import com.fw.demo.service.MenusService;

/**
 * 
 * <p>Title: InitMySystem.java</p>
 * <p>Description: 自定义系统初始化类</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Date: 2013-6-8</p>
 * @author 唐珍果
 * @version 1.0
 */
public class InitMySystem extends HttpServlet {
	/**
	 * 
	 * @author 唐珍果
	 */
	private static final long serialVersionUID = 1L;
	private boolean isUpdateMenus = false;
	private String menusPath = "classes\\Menus.xml";
	@Autowired
	private MenusService menusService;
	
	public InitMySystem() {
		menusService = (MenusService) SpringContextUtil.getBean("menusService");
	}
	
	private void initMenus() {
		String filepath = getServletContext().getRealPath("\\") + "WEB-INF\\" + menusPath;
		System.out.println("---------------2.初始化系统菜单-------------" + filepath);
		SAXReader saxReader = new SAXReader();
		try {
			InputStream is = new FileInputStream(filepath);
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			Document document = saxReader.read(isr);

			Element root = document.getRootElement();
			
			try {
				isUpdateMenus = Boolean.parseBoolean(root.attribute("isUpdateMenus").getValue());
			} catch (Exception e) {
			}
			if(isUpdateMenus) {
				menusService.deleteAll();
				toSaveMenus(root, null);
			}
			
			isr.close();
			is.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void toSaveMenus(Element element, Menus parentMenus) {
		int i = 0;
		for (Iterator iterInner = element.elementIterator(); iterInner.hasNext();) {
			Element elementInner = (Element) iterInner.next();
			Menus menus = new Menus();
			// 获取person节点的text属性的值
			menus.setParent(parentMenus);
			menus.setOrderNum(i);
			i++;
			Attribute textAttr = elementInner.attribute("text");
			if (textAttr != null) {
				String text = textAttr.getValue();
				if (text != null && !text.equals("")) {
					menus.setText(text);
				}
			}
			Attribute xtypeAttr = elementInner.attribute("xtype");
			if (xtypeAttr != null) {
				String xtype = xtypeAttr.getValue();
				if (xtype != null && !xtype.equals("")) {
					menus.setTarget(xtype);
				}
			}
			menusService.save(menus);
			toSaveMenus(elementInner, menus);
		}
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("---------------1.自定义初始化-------------");
		super.init();
		initMenus();
	}
	
}
