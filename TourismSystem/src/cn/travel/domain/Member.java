package cn.travel.domain;

import java.util.Date;

public class Member {
	private Long uid;
	private String username;
	private String password;
	private String name;
	private Date birthday;
	private Character sex;
	private String telephone;
	private String email;
	private Character status;//用户级别(1:普通会员2:白金会员3:钻石会员9:终生会员)
	private String code;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Member [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", birthday=" + birthday + ", sex=" + sex + ", telephone=" + telephone + ", email=" + email
				+ ", status=" + status + ", code=" + code + "]";
	}

}
