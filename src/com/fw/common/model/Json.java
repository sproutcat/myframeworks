package com.fw.common.model;

import java.io.Serializable;
/**
 * JSON通用类
 * @author ljj
 *
 */
		
public class Json implements Serializable{

	private boolean success = false;// �Ƿ�ɹ�
	private String msg = "";// ��ʾ��Ϣ
	private Object obj = null;// ������Ϣ
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}
