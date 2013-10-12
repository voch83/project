package com.pb.project.persistence;

import java.util.Date;

import com.pb.project.entity.impl.Client;

public interface ClientDAO extends DAO<Client> {

	Client findByPassportNumber(String passportNumber);
	
	Client findByNameAndBirthDay(String firstName, String lastName,
			String patronymic, Date birthDay);
	
	Client findByInn(String inn);
}
