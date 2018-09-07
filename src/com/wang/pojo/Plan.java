package com.wang.pojo;


import java.util.Date;


public class Plan {
	private Integer id;
	private Integer user_id;
	private String name;
	private String content;
	private Date begin_time;
	private Date end_time;
	private Boolean expire;
	private Boolean finish;
	private Boolean punish_method;
	private String punish_content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Boolean getExpire() {
		return expire;
	}
	public void setExpire(Boolean expire) {
		this.expire = expire;
	}
	public Boolean getFinish() {
		return finish;
	}
	public void setFinish(Boolean finish) {
		this.finish = finish;
	}
	public Boolean getPunish_method() {
		return punish_method;
	}
	public void setPunish_method(Boolean punish_method) {
		this.punish_method = punish_method;
	}
	public String getPunish_content() {
		return punish_content;
	}
	public void setPunish_content(String punish_content) {
		this.punish_content = punish_content;
	}
	
	

}
