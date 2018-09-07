package com.wang.pojo;

public class User {
	private Integer id;
	private String password;
	private Integer sensor_id;
	private Boolean admin;//true为管理员 false为普通用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(Integer sensor_id) {
		this.sensor_id = sensor_id;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


}
