package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GVoice generated by hbm2java
 */
@Entity
@Table(name = "g_voice", catalog = "zero")
public class GVoice implements java.io.Serializable {

	private String id;
	private String name;
	private String detail;
	private String url;

	public GVoice() {
	}

	public GVoice(String id) {
		this.id = id;
	}

	public GVoice(String id, String name, String detail, String url) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.url = url;
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

	@Column(name = "url", length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}