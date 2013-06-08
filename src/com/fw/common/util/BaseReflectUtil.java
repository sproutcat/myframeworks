package com.fw.common.util;

import java.lang.reflect.Method;
import java.util.Date;


public class BaseReflectUtil {
	
	public static Object getValue(Object obj, String name) {
		Object ret = null;
		Method ms[] = obj.getClass().getMethods();
		for (Method mth : ms) {
			if (mth.getName().equalsIgnoreCase("get" + name)) {
				try {
					ret = mth.invoke(obj, new Object[] {});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public static String getStrValue(Object obj, String name) {
		if(getValue(obj, name) != null) {
			return getValue(obj, name).toString();
		} else {
			return "";
		}
	}
	
	public static Integer getIntValue(Object obj,String name){
		return Integer.parseInt("" + getValue(obj, name));
	}
	
	public static Float getFloatValue(Object obj,String name){
		return Float.parseFloat("" + getValue(obj, name));
	}
	
	public static Double getDoubleValue(Object obj,String name){
		return Double.parseDouble("" + getValue(obj, name));
	}
	
	public static Long getLongValue(Object obj,String name){
		return Long.parseLong("" + getValue(obj, name));
	}
	
	public static Boolean getBooleanValue(Object obj,String name){
		if (getValue(obj, name) != null) {
			return Boolean.parseBoolean("" + getValue(obj, name));
		} else {
			return false;
		}
	}
	
	public static Date getDataValue(Object obj, String name) {
		return (Date) getValue(obj, name);
	}
}
