package com.loveboy.sys.user.form.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.ibatis.type.Alias;

@Alias("SYS_DICT")
@XmlAccessorType(XmlAccessType.FIELD)
public class SysDictVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 231L;

	private Long id;
	
	private String type;
	
	private String value;
	
	private String name;
	
	private String remark;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
