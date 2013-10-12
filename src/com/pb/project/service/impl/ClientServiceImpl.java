package com.pb.project.service.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import com.pb.project.entity.impl.Client;
import com.pb.project.entity.impl.Credit;
import com.pb.project.exception.ExsistDoubleClient;
import com.pb.project.persistence.impl.ClientDAOImpl;
import com.pb.project.persistence.impl.CreditDAOImpl;
import com.pb.project.service.ClientService;

public class ClientServiceImpl implements ClientService {
	
	private ClientDAOImpl clientDao;
	private CreditDAOImpl creditDao;
	
	public ClientServiceImpl(Connection con) {
		super();
		clientDao = new ClientDAOImpl(con);
		creditDao = new CreditDAOImpl(con);
	}

	@Override
	public Client findByPassportNumber(String passportNumber) {
		return clientDao.findByPassportNumber(passportNumber);
	}

	@Override
	public Client findByNameAndBirthDay(String firstName,
			String lastName, String patronymic, Date birthDay) {
		return clientDao.findByNameAndBirthDay(firstName, lastName, patronymic, birthDay);
	}

	@Override
	public Client findByInn(String inn) {
		return clientDao.findByInn(inn);
	}

	@Override
	public List<Credit> findCredits(Client client) {
		return creditDao.findByClient(client);
	}

	@Override
	public void insert(Client client) throws ExsistDoubleClient {
		String passportNumber = client.getPassportNumber();
		String inn = client.getInn();
		if (clientDao.findByPassportNumber(passportNumber) != null ||
			clientDao.findByInn(inn) != null) {
			throw new ExsistDoubleClient();
		}
		clientDao.insert(client);	
	}
}
