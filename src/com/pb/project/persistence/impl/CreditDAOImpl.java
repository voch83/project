 package com.pb.project.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.pb.project.entity.impl.Bank;
import com.pb.project.entity.impl.Client;
import com.pb.project.entity.impl.Credit;
import com.pb.project.entity.impl.Currency;
import com.pb.project.persistence.CreditDAO;
import java.util.ArrayList;
import java.util.Date;

public class CreditDAOImpl implements CreditDAO {
	
	private Connection con;
        private Date date;
	
	public CreditDAOImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Credit findById(Integer id) {
		if (id == null) return null;
		Credit result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, CurrencyID, BankID, ClientID, "
					+ "CreditAmount, UnpaidAmount, DateStart, DateEnd, IsDelay "
					+ "from tbl_Credit where id = ?");
			pr.setInt(1, id);
			r = pr.executeQuery();
			if (r.next()) {
				Currency currency = new CurrencyDAOImpl(con).findById(r.getInt(2));
				Bank bank = new BankDAOImpl(con).findById(r.getInt(3));
				Client client = new ClientDAOImpl(con).findById(r.getInt(4));
                                date = r.getDate(8);
                                if(date != null){
                                 date = new java.sql.Date(r.getDate(8).getTime());
                                }
				result = new Credit(r.getInt(1), currency, bank, client,
						r.getDouble(5), r.getDouble(6), r.getDate(7),
                                       date,
						r.getBoolean(9));
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
	public List<Credit> findAll() {
		List<Credit> result = null;
		PreparedStatement pr;
		ResultSet r;
		try {
			pr = con.prepareStatement("select ID, CurrencyID, BankID, ClientID, "
					+ "CreditAmount, UnpaidAmount, DateStart, DateEnd, IsDelay "
					+ "from tbl_Credit");
			r = pr.executeQuery();
			while (r.next()) {
				Currency currency = new CurrencyDAOImpl(con).findById(r.getInt(2));
				Bank bank = new BankDAOImpl(con).findById(r.getInt(3));
				Client client = new ClientDAOImpl(con).findById(r.getInt(4));
                                date = r.getDate(8);
                                if(date != null){
                                 date = new java.sql.Date(r.getDate(8).getTime());
                                }
				result.add(new Credit(r.getInt(1), currency, bank, client,
						r.getDouble(5), r.getDouble(6), r.getDate(7), 
						date, 
						r.getBoolean(9)));
			}
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Credit credit) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("insert into tbl_Credit "
					+ "(CurrencyID, BankID, ClientID, CreditAmount, "
					+ "UnpaidAmount, DateStart, DateEnd, IsDelay) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
			pr.setInt(1, credit.getCurrency().getId());
			pr.setInt(2, credit.getBank().getId());
			pr.setInt(3, credit.getClient().getId());
			pr.setDouble(4, credit.getCreditAmount());
			pr.setDouble(5, credit.getUnpaidAmount());
			pr.setDate(6, new java.sql.Date(credit.getDateStart().getTime()));
                        date =  credit.getDateEnd();
                        if(date != null){
			pr.setDate(7, new java.sql.Date(date.getTime()));
                        }else {
                        pr.setDate(7,null);  
                        }
                        pr.setBoolean(8, credit.getIsDelay());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void update(Credit credit) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("update tbl_Credit "
					+ "set CurrencyID = ?, BankID = ?, ClientID = ?, "
					+ "CreditAmount = ?, UnpaidAmount = ?, "
					+ "DateStart = ?, DateEnd = ?, IsDelay = ? "
					+ "where id = ?");
			pr.setInt(1, credit.getCurrency().getId());
			pr.setInt(2, credit.getBank().getId());
			pr.setInt(3, credit.getClient().getId());
			pr.setDouble(4, credit.getCreditAmount());
			pr.setDouble(5, credit.getUnpaidAmount());
			pr.setDate(6, new java.sql.Date(credit.getDateStart().getTime()));
			date =  credit.getDateEnd();
                        if(date != null){
			pr.setDate(7, new java.sql.Date(date.getTime()));
                        }else {
                        pr.setDate(7,null);  
                        }
			pr.setBoolean(8, credit.getIsDelay());
			pr.setInt(9, credit.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Credit credit) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement("delete from tbl_Credit where id = ?");
			pr.setInt(1, credit.getId());
			pr.execute();
			pr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@SuppressWarnings("null")
	@Override
	public List<Credit> findByClient(Client client) {
		if (client == null) return null;
		List<Credit> result = new ArrayList<>();
		PreparedStatement pr;
		ResultSet r;
		try {
                    
			pr = con.prepareStatement("select ID, CurrencyID, BankID, ClientID, "
					+ "CreditAmount, UnpaidAmount, DateStart, DateEnd, IsDelay "
					+ "from tbl_Credit where ClientID = ?");
			pr.setInt(1, client.getId());
			r = pr.executeQuery();
                        
			while (r.next()) {
                                date = r.getDate(8);
                                if(date != null){
                                 date = new java.sql.Date(r.getDate(8).getTime());
                                }
				Currency currency = new CurrencyDAOImpl(con).findById(r.getInt(2));
				Bank bank = new BankDAOImpl(con).findById(r.getInt(3));
				Client clintNew = new ClientDAOImpl(con).findById(r.getInt(4));
                                
				result.add(new Credit(r.getInt(1), currency, bank, clintNew,
						r.getDouble(5), r.getDouble(6), r.getDate(7),
						date,
						r.getBoolean(9)));
			                         
                        }
			pr.close();
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
