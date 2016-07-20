package com.zzy.domain.base;
// Generated 2016-7-13 16:23:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GNpc generated by hbm2java
 */
@Entity
@Table(name = "g_npc", catalog = "zero")
public class GNpc implements java.io.Serializable {

	private String id;
	private String name;
	private String detail;
	private Integer type;
	private Integer gender;

	public GNpc() {
	}

	public GNpc(String id) {
		this.id = id;
	}

	public GNpc(String id, String name, String detail, Integer type, Integer gender) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.type = type;
		this.gender = gender;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "detail", length = 50)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

}
