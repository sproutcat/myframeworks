package com.fw.demo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
@Table(name="tb_auths")
public class Auth extends AbstractModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REC_ID", nullable = false, length = 36)
	private Long recid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPID")
	private Auth auth;
	@Column(name = "CDESC", length = 200)
	private String desc;
	@Column(name = "CNAME", length = 100)
	private String name;
	@Column(name = "CSEQ", precision = 22, scale = 0)
	private BigDecimal seq;
	@Column(name = "URL", length = 200)
	private String url;
	//权限类型
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auth")
	private Set<RoleAuth> roleauths = new HashSet<RoleAuth>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auth")
	private Set<Auth> auths = new HashSet<Auth>(0);
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSeq() {
		return seq;
	}
	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<RoleAuth> getRoleauths() {
		return roleauths;
	}
	public void setRoleauths(Set<RoleAuth> roleauths) {
		this.roleauths = roleauths;
	}
	public Set<Auth> getAuths() {
		return auths;
	}
	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}
	
	
	
	
	
}
