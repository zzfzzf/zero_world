package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GLand generated by hbm2java
 */
@Entity
@Table(name = "g_land", catalog = "zero")
public class GLand implements java.io.Serializable {

	private String id;
	private String roleId;
	private String name;
	private String detail;
	private Integer size;
	private Date startTime;
	private Date endTime;
	private Date ownTime;
	private Integer isRent;

	public GLand() {
	}

	public GLand(String id, Date startTime, Date endTime, Date ownTime) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ownTime = ownTime;
	}

	public GLand(String id, String roleId, String name, String detail, Integer size, Date startTime, Date endTime,
			Date ownTime, Integer isRent) {
		this.id = id;
		this.roleId = roleId;
		this.name = name;
		this.detail = detail;
		this.size = size;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ownTime = ownTime;
		this.isRent = isRent;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "role_id", length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	@Column(name = "size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false, length = 0)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = false, length = 0)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "own_time", nullable = false, length = 0)
	public Date getOwnTime() {
		return this.ownTime;
	}

	public void setOwnTime(Date ownTime) {
		this.ownTime = ownTime;
	}

	@Column(name = "is_rent")
	public Integer getIsRent() {
		return this.isRent;
	}

	public void setIsRent(Integer isRent) {
		this.isRent = isRent;
	}

}