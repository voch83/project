package com.pb.project.service;

import java.util.Date;
import java.util.List;
import com.pb.project.entity.impl.Client;
import com.pb.project.entity.impl.Credit;
import com.pb.project.exception.ExsistDoubleClient;

public interface ClientService {
	
	Client findByPassportNumber(String passportNumber);
	
	Client findByNameAndBirthDay(String firstName, String lastName,
			String patronymic, Date birthDay);
	
	Client findByInn(String inn);
	
	List<Credit> findCredits(Client client);
	
	void insert(Client client) throws ExsistDoubleClient;

}
