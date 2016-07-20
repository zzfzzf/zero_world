package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZPositionPower generated by hbm2java
 */
@Entity
@Table(name = "z_position_power", catalog = "zero")
public class ZPositionPower implements java.io.Serializable {

	private String id;
	private String powerId;
	private String positionId;

	public ZPositionPower() {
	}

	public ZPositionPower(String id) {
		this.id = id;
	}

	public ZPositionPower(String id, String powerId, String positionId) {
		this.id = id;
		this.powerId = powerId;
		this.positionId = positionId;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "power_id", length = 32)
	public String getPowerId() {
		return this.powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	@Column(name = "position_id", length = 32)
	public String getPositionId() {
		return this.positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

}
