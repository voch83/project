package com.pb.project.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pb.project.entity.impl.Bank;
import com.pb.project.persistence.BankDAO;
import java.sql.Statement;
import java.util.ArrayList;

public class BankDAOImpl implements BankDAO {
	
	private Connection con;
	
	public BankDAOImpl(Connection con) {
		super();
		this.con = con;
	}

        public Bank findByName(String name) {
		Bank result = null;
		          Statement pr;
		ResultSet r;
		try {
                    String sql = "select ID, Name "
					+ "from tbl_Bank where name = '"+name+"'";
			pr = con.createStatement();
//			pr.setString(1, name);
			r = pr.executeQuery(sql);
			if (r.next()) {
				result = new Bank(r.getInt(1), r.getString(2));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
        
	@Override
	public Bank findById(Integer id) {
		if (id == null) return null;
		Bank result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, Name "
					+ "from tbl_Bank where id = ?");
			pr.setInt(1, id);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Bank(r.getInt(1), r.getString(2));
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
	public List<Bank> findAll() {
		List<Bank> result = new ArrayList<>();
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, Name "
					+ "from tbl_Bank");
			r = pr.executeQuery();
			while (r.next()) {
				result.add(new Bank(r.getInt(1), r.getString(2)));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Bank bank) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("insert into tbl_Bank "
					+ "(Name) values (?)");
			pr.setString(1, bank.getName());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Bank bank) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("update tbl_Bank "
					+ "set Name = ? "
					+ "where id = ?");
			pr.setString(1, bank.getName());
			pr.setInt(2, bank.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Bank bank) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("delete from tbl_Client where id = ?");
			pr.setInt(1, bank.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
