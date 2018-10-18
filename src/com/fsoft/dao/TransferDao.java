package com.fsoft.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.fsoft.entities.Transfer;
import com.fsoft.utils.DatabaseUtils;

public class TransferDao {
	public List<Transfer> showAllTransaction(String account)throws ClassNotFoundException, IOException, SQLException
	  {
		  Connection connection = DatabaseUtils.getConnection();
		  List<Transfer> listTransfer = new ArrayList<>();
		    String sql = "SELECT * FROM TransactionHistory where account_tranfer = ? or account_receive=?";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setString(1,account);
		    preparedStatement.setString(2,account);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    try {
		      while (resultSet.next()) {
		        listTransfer.add(new Transfer(resultSet.getInt(1),resultSet.getLong(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
		      }
		      return listTransfer;
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  
		  
	  }
	public boolean insertTransfer(Transfer transfer)
		      throws ClassNotFoundException, IOException, SQLException {
		    Connection connection = DatabaseUtils.getConnection();
		    String sql = "insert into TransactionHistory values (?,?,?,?);";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setLong(1, transfer.getAmount());
		    preparedStatement.setString(2, transfer.getTransactionNote());
		    preparedStatement.setString(3, transfer.getAccountReceive());
		    preparedStatement.setString(4, transfer.getAccountTransfer());
		    int result = preparedStatement.executeUpdate();
		    try {
		      if (result > 0) {
		        return true;
		      }
		      return false;
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  }
	public boolean deleteRowHistory(int id)
		      throws ClassNotFoundException, IOException, SQLException {
		    Connection connection = DatabaseUtils.getConnection();
		    String sql = "delete from TransactionHistory where transaction_id = ? ;";
		    PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(1,id);   
		    int result = preparedStatement.executeUpdate();
		    try {
		      if (result > 0) {
		        return true;
		      }
		      return false;
		    } finally {
		      DatabaseUtils.closeConnection(connection);
		    }
		  }
	
	
}
