package com.fw.sys.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fw.common.model.AbstractModel;

/**
 * 用户表
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_users")
public class User extends AbstractModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REC_ID",  nullable = false, length = 36)
	private Long recid;
	@Column(name = "real_Name")
	private String realName;
	@Column(name = "sub_Company")
	private String subCompany;
	@Column(name = "DEPARTMENT")
	private String department;
	@Column(name = "MAIL")
	private String mail;
	@Column(name = "MOBLIE")
	private String mobile;
	@Column(name = "USER_TYPE")
	private String userType;
	@Column(name = "STATUS")
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATETIME" ,length = 7)
	private Date createtime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFYTIME" ,length = 7)
	private Date modifytime;
	
	@Column(name = "CNAME",unique = true, nullable = false, length = 100)
	private String name;
	@Column(name = "PWD")
	private String pwd;
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	//private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	
	public Long getRecid() {
		return recid;
	}
	public void setRecid(Long recid) {
		this.recid = recid;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSubCompany() {
		return subCompany;
	}
	public void setSubCompany(String subCompany) {
		this.subCompany = subCompany;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/*public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}*/
	
}
