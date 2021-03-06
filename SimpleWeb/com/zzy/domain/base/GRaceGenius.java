package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GRaceGenius generated by hbm2java
 */
@Entity
@Table(name = "g_race_genius", catalog = "zero")
public class GRaceGenius implements java.io.Serializable {

	private String id;
	private String raceId;
	private String geniusId;

	public GRaceGenius() {
	}

	public GRaceGenius(String id) {
		this.id = id;
	}

	public GRaceGenius(String id, String raceId, String geniusId) {
		this.id = id;
		this.raceId = raceId;
		this.geniusId = geniusId;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "race_id", length = 32)
	public String getRaceId() {
		return this.raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	@Column(name = "genius_id", length = 32)
	public String getGeniusId() {
		return this.geniusId;
	}

	public void setGeniusId(String geniusId) {
		this.geniusId = geniusId;
	}

}
