package com.wang.pojo;


import java.util.Date;


public class Plan {


	@Override
	public String toString() {
		return "Plan [id=" + id + ", user_id=" + user_id + ", name=" + name
				+ ", content=" + content + ", begin_time=" + begin_time
				+ ", finish=" + finish + "]";
	}
	private Integer id;
	private Integer user_id;
	private String name;
	private String content;
	private Date begin_time;
	private Boolean finish;
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

	public Boolean getFinish() {
		return finish;
	}
	public void setFinish(Boolean finish) {
		this.finish = finish;
	}

	
	

}
