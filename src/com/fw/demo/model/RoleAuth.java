package com.fw.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fw.common.model.AbstractModel;

@Entity
@Table(name="tb_roleauths")
public class RoleAuth extends AbstractModel{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REC_ID",  nullable = false, length = 36)
	private Long recid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTHID")
	private Auth auth;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID")
	private Role role;
	
	
	
	
	public Long getRecid() {
		return recid;
	}
	public void setRecid(Long recid) {
		this.recid = recid;
	}
	public Auth getAuth() {
		return auth;
	}
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
