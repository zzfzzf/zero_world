package com.zzy.domain.base;
// Generated 2016-7-18 21:58:17 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZUser generated by hbm2java
 */
@Entity
@Table(name = "z_user", catalog = "zero")
public class ZUser implements java.io.Serializable {

	private String id;
	private String user;
	private String password;
	private String nickName;
	private String headImageId;
	private String specialSign;
	private Integer status;
	private Integer vip;
	private Integer money;
	private String qq;
	private String phone;

	public ZUser() {
	}

	public ZUser(String id) {
		this.id = id;
	}

	public ZUser(String id, String user, String password, String nickName, String headImageId, String specialSign,
			Integer status, Integer vip, Integer money, String qq, String phone) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.nickName = nickName;
		this.headImageId = headImageId;
		this.specialSign = specialSign;
		this.status = status;
		this.vip = vip;
		this.money = money;
		this.qq = qq;
		this.phone = phone;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "user", length = 50)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
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

	@Column(name = "head_image_id", length = 50)
	public String getHeadImageId() {
		return this.headImageId;
	}

	public void setHeadImageId(String headImageId) {
		this.headImageId = headImageId;
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
