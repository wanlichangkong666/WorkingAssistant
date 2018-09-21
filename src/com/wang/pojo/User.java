package com.wang.pojo;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", sensor_id="
				+ sensor_id + ", admin=" + admin + "]";
	}
	private Integer id;
	private String password;
	private Integer sensor_id;
	private Boolean admin;//true涓虹鐞嗗憳 false涓烘櫘閫氱敤鎴�	
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
