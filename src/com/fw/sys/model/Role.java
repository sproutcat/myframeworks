package com.fw.sys.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fw.common.model.AbstractModel;


@Entity
@Table(name="tb_roles")
public class Role extends AbstractModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REC_ID", nullable = false, length = 36)
	private Long recid;
	@Column(name = "CDESC", length = 200)
	private String desc;
	@Column(name = "CNAME", length = 100)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<RoleAuth> roleauths = new HashSet<RoleAuth>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<UserRole> userroles = new HashSet<UserRole>(0);
	
	
	
	public Long getRecid() {
		return recid;
	}
	public void setRecid(Long recid) {
		this.recid = recid;
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
	public Set<RoleAuth> getRoleauths() {
		return roleauths;
	}
	public void setRoleauths(Set<RoleAuth> roleauths) {
		this.roleauths = roleauths;
	}
	public Set<UserRole> getUserroles() {
		return userroles;
	}
	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}
	
	
}
