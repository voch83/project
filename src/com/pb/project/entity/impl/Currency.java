package com.pb.project.entity.impl;

import com.pb.project.entity.Entity;

public class Currency implements Entity {
	
	private Integer id;
	private String name;
	private String code;
	
	public Currency() {
	}
	
	public Currency(String name) {
		super();
		this.name = name;
	}
	
	public Currency(Integer id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
}
