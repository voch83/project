package com.pb.project.persistence;

import java.util.List;
import com.pb.project.entity.impl.Client;
import com.pb.project.entity.impl.Credit;

public interface CreditDAO extends DAO<Credit> {
	
	List<Credit> findByClient(Client client);
}
