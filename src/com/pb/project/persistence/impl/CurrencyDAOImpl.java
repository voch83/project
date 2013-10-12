package com.pb.project.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pb.project.entity.impl.Currency;
import com.pb.project.persistence.CurrencyDAO;
import java.util.ArrayList;

public class CurrencyDAOImpl implements CurrencyDAO {

	private Connection con;
	
	public CurrencyDAOImpl(Connection con) {
		super();
		this.con = con;
	}
	
        public Currency findByName(String name) {
          Currency result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, Name, Code "
					+ "from tbl_Currency where name = ?");
			pr.setString(1, name);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Currency(r.getInt(1), r.getString(2), r.getString(3));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
        }
        
	@Override
	public Currency findById(Integer id) {
		if (id == null) return null;
		Currency result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, Name, Code "
					+ "from tbl_Currency where id = ?");
			pr.setInt(1, id);
			r = pr.executeQuery();
			if (r.next()) {
				result = new Currency(r.getInt(1), r.getString(2), r.getString(3));
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
	public List<Currency> findAll() {
		List<Currency> result = new ArrayList<>();
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, Name, Code "
					+ "from tbl_Currency");
			r = pr.executeQuery();
			while (r.next()) {
				result.add(new Currency(r.getInt(1), r.getString(2), r.getString(3)));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Currency currency) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("insert into tbl_Currency "
					+ "(Name, Code) values (?, ?)");
			pr.setString(1, currency.getName());
			pr.setString(2, currency.getCode());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Currency currency) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("update tbl_�urrency "
					+ "set Name = ?, Code = ? "
					+ "where id = ?");
			pr.setString(1, currency.getName());
			pr.setString(2, currency.getCode());
			pr.setInt(3, currency.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Currency currency) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("delete from tbl_�urrency where id = ?");
			pr.setInt(1, currency.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
