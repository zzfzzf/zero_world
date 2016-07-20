package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GRole generated by hbm2java
 */
@Entity
@Table(name = "g_role", catalog = "zero")
public class GRole implements java.io.Serializable {

	private String id;
	private String name;
	private String blood;
	private String energy;
	private Integer level;
	private Integer experience;
	private Integer gender;
	private String vocationId;
	private Integer status;
	private String bagId;
	private String equipId;
	private Integer strength;
	private Integer agility;
	private Integer intellect;
	private Integer lucky;
	private String conditions;
	private String raceId;
	private Integer attack;
	private Integer defens;
	private String headImageId;
	private String userId;
	private String area;

	public GRole() {
	}

	public GRole(String id) {
		this.id = id;
	}

	public GRole(String id, String name, String blood, String energy, Integer level, Integer experience, Integer gender,
			String vocationId, Integer status, String bagId, String equipId, Integer strength, Integer agility,
			Integer intellect, Integer lucky, String conditions, String raceId, Integer attack, Integer defens,
			String headImageId, String userId, String area) {
		this.id = id;
		this.name = name;
		this.blood = blood;
		this.energy = energy;
		this.level = level;
		this.experience = experience;
		this.gender = gender;
		this.vocationId = vocationId;
		this.status = status;
		this.bagId = bagId;
		this.equipId = equipId;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.lucky = lucky;
		this.conditions = conditions;
		this.raceId = raceId;
		this.attack = attack;
		this.defens = defens;
		this.headImageId = headImageId;
		this.userId = userId;
		this.area = area;
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

	@Column(name = "blood", length = 50)
	public String getBlood() {
		return this.blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	@Column(name = "energy", length = 50)
	public String getEnergy() {
		return this.energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "experience")
	public Integer getExperience() {
		return this.experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "vocation_id", length = 32)
	public String getVocationId() {
		return this.vocationId;
	}

	public void setVocationId(String vocationId) {
		this.vocationId = vocationId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "bag_id", length = 32)
	public String getBagId() {
		return this.bagId;
	}

	public void setBagId(String bagId) {
		this.bagId = bagId;
	}

	@Column(name = "equip_id", length = 32)
	public String getEquipId() {
		return this.equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
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

	@Column(name = "conditions", length = 50)
	public String getConditions() {
		return this.conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Column(name = "race_id", length = 32)
	public String getRaceId() {
		return this.raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	@Column(name = "attack")
	public Integer getAttack() {
		return this.attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	@Column(name = "defens")
	public Integer getDefens() {
		return this.defens;
	}

	public void setDefens(Integer defens) {
		this.defens = defens;
	}

	@Column(name = "head_image_id", length = 32)
	public String getHeadImageId() {
		return this.headImageId;
	}

	public void setHeadImageId(String headImageId) {
		this.headImageId = headImageId;
	}

	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "area", length = 32)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
