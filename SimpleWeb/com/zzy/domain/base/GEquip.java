package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GEquip generated by hbm2java
 */
@Entity
@Table(name = "g_equip", catalog = "zero")
public class GEquip implements java.io.Serializable {

	private String id;
	private String detail;
	private String name;

	public GEquip() {
	}

	public GEquip(String id) {
		this.id = id;
	}

	public GEquip(String id, String detail, String name) {
		this.id = id;
		this.detail = detail;
		this.name = name;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "detail", length = 50)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
