package com.loveboy.sys.user.form.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.ibatis.type.Alias;

public class SysUserVo implements Serializable {
	private Long id;

	private String account;

	private String wxId;
	private String qqId;
	private String wbId;
	@XmlTransient
	private String pwd;

	private Integer type; // 用户类型 0 业务用户， 98 运营用户只能查看，99超管用户

	private Integer status; // 用户状态 0 失效，1 正常

	private Integer userFrom; // 用户来源 0 壹号课堂，1JSM幼小，99系统

	private Date createTime;

	private Date lastLoginTime;

	private Long userInfoId;

	private String name;

	private String phone;

	private String address;

	private Long departId;

	private String departName;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getWbId() {
		return wbId;
	}

	public void setWbId(String wbId) {
		this.wbId = wbId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(Integer userFrom) {
		this.userFrom = userFrom;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

}
