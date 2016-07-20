package com.zzy.domain.cross;
// Generated 2016-7-4 10:01:06 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.zzy.domain.base.GSkill;

/**
 * GSkillVocation generated by hbm2java
 */
@Entity
@Table(name = "g_vocation_skill", catalog = "zero")
public class GVocationSkill implements java.io.Serializable {

	private String id;
	private GSkill skill;
	private String vocationId;

	@Column(name="vocation_id",length=32)
	public String getVocationId() {
		return vocationId;
	}
	
	public void setVocationId(String vocationId) {
		this.vocationId = vocationId;
	}
	  

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")  
	@NotFound(action=NotFoundAction.IGNORE)
	public GSkill getSkill() {
		return skill;
	}

	public void setSkill(GSkill skill) {
		this.skill = skill;
	}

	public GVocationSkill() {
	}

	public GVocationSkill(String id) {
		this.id = id;
	}
 
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
