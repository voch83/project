package com.pb.project.service.impl;

import java.sql.Connection;

import com.pb.project.entity.impl.Credit;
import com.pb.project.persistence.impl.CreditDAOImpl;
import com.pb.project.service.CreditService;

public class CreditServiceImpl implements CreditService {
	
	private CreditDAOImpl dao;
	
	public CreditServiceImpl(Connection con) {
		super();
		dao = new CreditDAOImpl(con);
	}

	@Override
	public void insert(Credit credit) {	
		dao.insert(credit);
	}

	@Override
	public void update(Credit credit) {
		dao.update(credit);
	}

}
