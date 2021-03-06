package com.wang.pojo;

public class User {

	private Integer id;
	private String password;
	private String rfid;
	private String sensor;
	private Boolean attendance;
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

	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public Boolean getAttendance() {
		return attendance;
	}
	public void setAttendence(Boolean attendance) {
		this.attendance = attendance;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", rfid=" + rfid
				+ ", sensor=" + sensor + ", attendance=" + attendance
				+ ", admin=" + admin + "]";
	}


}
