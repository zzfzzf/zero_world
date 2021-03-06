package com.zzy.domain.base;
// Generated 2016-7-4 10:01:06 by Hibernate Tools 3.4.0.CR1

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zzy.base.BaseEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.zzy.domain.cross.GRoleBuff;
import com.zzy.domain.cross.GRoleFriend;
import com.zzy.domain.cross.GRoleSkill;

/**
 * GRole generated by hbm2java
 */
@Entity
@Table(name = "g_role", catalog = "zero")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // 延迟加载问题
public class GRole  extends BaseEntity implements java.io.Serializable {
	private String id;
	private String name;
	private Integer maxBlood;
	private Integer maxEnergy;
	private Integer speed;
	private Integer blood; 
	private Integer energy;
	private Integer level;
	private Integer experience;
	private Integer gender;
	private Integer status;
	private Integer strength;
	private Integer agility;
	private Integer intellect;
	private Integer lucky;
	private String conditions;
	private Integer attack;
	private Integer defense;
	private GVocation vocation;
	private Set<GRoleSkill> role_skill;
    private Set<GRoleFriend> role_friend; 
    private GBag bag;
    private GEquip equip;
    private GRace race;
    private Set<GRoleBuff> role_buff;
    private Set<GLand> land;
    private GImage headImageId;
    private GArea area;
    private String userId;
    
    @Column(name = "user_id", length = 50)
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@ManyToOne
    @JoinColumn(name = "area_id")  
	@NotFound(action=NotFoundAction.IGNORE)
    public GArea getArea() {
		return area;
	}

	public void setArea(GArea area) {
		this.area = area;
	}

	@OneToOne 
    @JoinColumn(name="head_image_id",unique=true)
    @NotFound(action=NotFoundAction.IGNORE)
    public GImage getHeadImageId() {
  		return headImageId;   
  	} 

  	public void setHeadImageId(GImage headImageId) {
  		this.headImageId = headImageId;
  	}

	@OneToMany
    @JoinColumn(name="role_id")    
	@NotFound(action=NotFoundAction.IGNORE)
    public Set<GLand> getLand() {
		return land;
	}

	public void setLand(Set<GLand> land) {
		this.land = land;
	}

	@OneToMany
    @JoinColumn(name="role_id") 
	@NotFound(action=NotFoundAction.IGNORE)
    public Set<GRoleBuff> getRole_buff() {
		return role_buff;
	}

	public void setRole_buff(Set<GRoleBuff> role_buff) {
		this.role_buff = role_buff;
	}

	@OneToOne
    @JoinColumn(name="race_id",unique=true)
    @NotFound(action=NotFoundAction.IGNORE)
    public GRace getRace() {
		return race;
	}

	public void setRace(GRace race) {
		this.race = race;
	}

	@OneToOne
    @JoinColumn(name="equip_id",unique=true)
	@NotFound(action=NotFoundAction.IGNORE)
    public GEquip getEquip() {
		return equip;
	}

	public void setEquip(GEquip equip) {
		this.equip = equip;
	}

	@OneToOne
    @JoinColumn(name="bag_id",unique=true)
	@NotFound(action=NotFoundAction.IGNORE)
    public GBag getBag() {
		return bag;  
	} 

	public void setBag(GBag bag) {
		this.bag = bag;
	}

	@OneToMany(fetch = FetchType.LAZY)  
    @JoinColumn(name="role_id") 
	@NotFound(action=NotFoundAction.IGNORE)
    public Set<GRoleFriend> getRole_friend() {
		return role_friend;
	}

	public void setRole_friend(Set<GRoleFriend> role_friend) {
		this.role_friend = role_friend;
	} 

	@OneToMany(fetch = FetchType.LAZY)   
	@JoinColumn(name="role_id") 
	@NotFound(action=NotFoundAction.IGNORE)
    public Set<GRoleSkill> getRole_skill() {
    	return role_skill;  
    }
    
    public void setRole_skill(Set<GRoleSkill> role_skill) {
    	this.role_skill = role_skill;
    }

	public GRole(String id) {}


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

	
	@Column(name = "speed")
	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	@Column(name = "max_blood")
	public Integer getMaxBlood() {
		return maxBlood;
	}

	public void setMaxBlood(Integer maxBlood) {
		this.maxBlood = maxBlood;
	}
	@Column(name = "max_energy")
	public Integer getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(Integer maxEnergy) {
		this.maxEnergy = maxEnergy;
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
	 

    @OneToOne    
    @JoinColumn(name="vocation_id")
    @NotFound(action=NotFoundAction.IGNORE)
	public GVocation getVocation() { 
		return this.vocation;  
	}

	public void setVocation(GVocation vocation) {
		this.vocation = vocation;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public GRole setStatus(Integer status) {
		this.status = status;
		return this;
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

	
	@Column(name = "attack")
	public Integer getAttack() {
		return this.attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	@Column(name = "defense")
	public Integer getDefense() {
		return this.defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	 
}
