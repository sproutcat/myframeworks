package com.fw.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fw.common.model.AbstractModel;

@Entity
@Table(name="tb_menus")
public class Menus extends AbstractModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",  nullable = false, length = 36)
	private Long id;
	@Column(name = "TEXT")
	private String text;
	@Column(name = "TARGET")
	private String target;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="PARENT_ID")
	private Menus parent;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	private List<Menus> children = new ArrayList<Menus>();
	@Column(name = "ORDER_NUM")
	private Integer orderNum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<Menus> getChildren() {
		return children;
	}
	public void setChildren(List<Menus> children) {
		this.children = children;
	}
	public Menus getParent() {
		return parent;
	}
	public void setParent(Menus parent) {
		this.parent = parent;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		if(orderNum == null) {
			this.orderNum = 0;
		} else {
			this.orderNum = orderNum;
		}
	}
	
}
