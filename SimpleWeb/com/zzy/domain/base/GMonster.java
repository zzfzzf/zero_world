package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GMonster generated by hbm2java
 */
@Entity
@Table(name = "g_monster", catalog = "zero")
public class GMonster implements java.io.Serializable {

	private String id;
	private Long attack;
	private Long defens;
	private Integer quality;
	private String name;
	private Integer level;
	private Integer blood;
	private Integer energy;
	private Integer strength;
	private Integer agility;
	private Integer intellect;
	private Integer lucky;
	private String geniusId;
	private Integer type;

	public GMonster() {
	}

	public GMonster(String id) {
		this.id = id;
	}

	public GMonster(String id, Long attack, Long defens, Integer quality, String name, Integer level, Integer blood,
			Integer energy, Integer strength, Integer agility, Integer intellect, Integer lucky, String geniusId,
			Integer type) {
		this.id = id;
		this.attack = attack;
		this.defens = defens;
		this.quality = quality;
		this.name = name;
		this.level = level;
		this.blood = blood;
		this.energy = energy;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.lucky = lucky;
		this.geniusId = geniusId;
		this.type = type;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "attack")
	public Long getAttack() {
		return this.attack;
	}

	public void setAttack(Long attack) {
		this.attack = attack;
	}

	@Column(name = "defens")
	public Long getDefens() {
		return this.defens;
	}

	public void setDefens(Long defens) {
		this.defens = defens;
	}

	@Column(name = "quality")
	public Integer getQuality() {
		return this.quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "blood")
	public Integer getBlood() {
		return this.blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	@Column(name = "energy")
	public Integer getEnergy() {
		return this.energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	@Column(name = "strength")
	public Integer getStrength() {
		return this.strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	@Column(name = "agility")
	public Integer getAgility() {
		return this.agility;
	}

	public void setAgility(Integer agility) {
		this.agility = agility;
	}

	@Column(name = "intellect")
	public Integer getIntellect() {
		return this.intellect;
	}

	public void setIntellect(Integer intellect) {
		this.intellect = intellect;
	}

	@Column(name = "lucky")
	public Integer getLucky() {
		return this.lucky;
	}

	public void setLucky(Integer lucky) {
		this.lucky = lucky;
	}

	@Column(name = "genius_id", length = 32)
	public String getGeniusId() {
		return this.geniusId;
	}

	public void setGeniusId(String geniusId) {
		this.geniusId = geniusId;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}