package com.pb.project.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pb.project.entity.impl.Client;
import com.pb.project.persistence.ClientDAO;

public class ClientDAOImpl implements ClientDAO {
	
	private Connection con;

	public ClientDAOImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Client findById(Integer id) {
		if (id == null) return null;
		Client result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image "
					+ "from tbl_Client where id = ?");
			pr.setInt(1, id);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Client(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						new java.util.Date(r.getDate(6).getTime()),
						r.getString(7),r.getBytes(8));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("null")
	@Override
	public List<Client> findAll() {
		List<Client> result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image "
					+ "from tbl_Client");
			r = pr.executeQuery();
			while (r.next()) {
				result.add(new Client(r.getInt(1), r.getString(2), r
						.getString(3), r.getString(4), r.getString(5),
						new java.util.Date(r.getDate(6).getTime()), 
						r.getString(7),r.getBytes(8)));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Client client) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("insert into tbl_Client "
					+ "(INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image) "
					+ "values (?, ?, ?, ?, ?, ?, ?)");
			pr.setString(1, client.getInn());
			pr.setString(2, client.getFirstName());
			pr.setString(3, client.getLastName());
			pr.setString(4, client.getPatronymic());
			pr.setDate(5, new java.sql.Date(client.getBirthDay().getTime()));
			pr.setString(6, client.getPassportNumber());
                        pr.setBytes(7, client.getImage());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Client client) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("update tbl_Client "
					+ "set INN = ?, FirstName = ?, LastName = ?, "
					+ "Patronymic = ?, BirthDay = ?, "
					+ "PassportNumber = ? "
					+ "where id = ?");
			pr.setString(1, client.getInn());
			pr.setString(2, client.getFirstName());
			pr.setString(3, client.getLastName());
			pr.setString(4, client.getPatronymic());
			pr.setDate(5, new java.sql.Date(client.getBirthDay().getTime()));
			pr.setString(6, client.getPassportNumber());
			pr.setInt(7, client.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Client client) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("delete from tbl_Client where id = ?");
			pr.setInt(1, client.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client findByPassportNumber(String passportNumber) {
		if (passportNumber == null) return null;
		Client result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image "
					+ "from tbl_Client where PassportNumber = ?");
			pr.setString(1, passportNumber);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Client(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						new java.util.Date(r.getDate(6).getTime()),
						r.getString(7), r.getBytes(8));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("null")
	@Override
	public Client findByNameAndBirthDay(String firstName,
			String lastName, String patronymic, Date birthDay) {
		if (firstName == null || lastName == null || patronymic == null
				|| birthDay == null) {
			return null;
		}
		Client result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image "
					+ "from tbl_Client where FirstName = ? and "
					+ "LastName = ? and Patronymic = ? and BirthDay = ?");
			pr.setString(1, firstName);
			pr.setString(2, lastName);
			pr.setString(3, patronymic);
			pr.setDate(4, new java.sql.Date (birthDay.getTime()));
			r = pr.executeQuery();
			while (r.next()) {
				result=new Client(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						new java.util.Date(r.getDate(6).getTime()), 
						r.getString(7),r.getBytes(8));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Client findByInn(String inn) {
		if (inn == null) return null;
		Client result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, INN, FirstName, LastName, "
					+ "Patronymic, BirthDay, PassportNumber, image "
					+ "from tbl_Client where INN = ?");
			pr.setString(1, inn);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Client(r.getInt(1), r.getString(2),
						r.getString(3), r.getString(4), r.getString(5),
						new java.util.Date(r.getDate(6).getTime()),
						r.getString(7), r.getBytes(8));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
