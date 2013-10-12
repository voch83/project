package com.pb.project.entity.impl;

import com.pb.project.entity.Entity;

public class Bank implements Entity {
	
	private Integer id;
	private String name;
	//GIT
	public Bank() {
	}
	
	public Bank(String name) {
		super();
		this.name = name;
	}

	public Bank(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

        @Override
	public Integer getId() {
		return id;
	}
	
        @Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + "]";
	}
}
