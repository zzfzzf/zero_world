package com.zzy.domain.base;
// Generated 2016-7-4 10:01:06 by Hibernate Tools 3.4.0.CR1

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.zzy.domain.cross.ZUserGRole;
import com.zzy.domain.cross.ZUserPosition;

/**
 * ZUser generated by hbm2java
 */
@Entity
@Table(name = "z_user", catalog = "zero")
public class ZUser implements java.io.Serializable {

	private String id;
	private String username;
	private String password;
	private String nickName;
	private String specialSign;
	private Integer status;
	private Integer vip;
	private Integer money;
	private String qq;
	private String phone;
	private GImage headImageId;
	private Set<GRole> role;
	private Set<ZUserPosition> user_pisition;
	@OneToMany(fetch = FetchType.LAZY)  
    @JoinColumn(name="user_id") 
	@NotFound(action=NotFoundAction.IGNORE) 
	public Set<ZUserPosition> getUser_pisition() {
		return user_pisition;
	}

	public void setUser_pisition(Set<ZUserPosition> user_pisition) {
		this.user_pisition = user_pisition;
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
    @JoinColumn(name="user_id")     
	@NotFound(action=NotFoundAction.IGNORE)
	public Set<GRole> getRole() {
		return role;
	}

	public void setRole(Set<GRole> role) {
		this.role = role;
	}
	

	public ZUser() {
	}


	

	public ZUser(String id) {
		this.id = id;
	}


	@Id

	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nick_name", length = 50)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	@Column(name = "special_sign", length = 50)
	public String getSpecialSign() {
		return this.specialSign;
	}

	public void setSpecialSign(String specialSign) {
		this.specialSign = specialSign;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "vip")
	public Integer getVip() {
		return this.vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	@Column(name = "money")
	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Column(name = "qq", length = 50)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
