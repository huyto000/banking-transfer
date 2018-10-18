package com.fsoft.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.entities.Account;
import com.fsoft.utils.DatabaseUtils;

import sun.security.pkcs11.Secmod.DbMode;

public class AccountDao {
  public boolean checkLogin(Account account)
      throws ClassNotFoundException, IOException, SQLException {
    Connection connection = DatabaseUtils.getConnection();
    String sql = "SELECT * FROM Account WHERE account = ? AND pass_word = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, account.getAccount());
    preparedStatement.setString(2, account.getPassword());
    ResultSet resultSet = preparedStatement.executeQuery();
    try {
      if (resultSet.next()) {
        return true;
      }
      return false;
    } finally {
      DatabaseUtils.closeConnection(connection);
    }
  }
  public String selectAccountByName(String name)throws ClassNotFoundException, IOException, SQLException
  {
	  Connection connection = DatabaseUtils.getConnection();
	    String sql = "SELECT balance FROM Account WHERE account = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setString(1,name);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    try {
	      if (resultSet.next()) {
	        return resultSet.getString(1);
	      }
	      return null;
	    } finally {
	      DatabaseUtils.closeConnection(connection);
	    }
	  
	  
  }
  public List<Account> getListAccount() throws ClassNotFoundException, IOException, SQLException{
	  List<Account> listAccount = new ArrayList<>();
	  Connection connection = DatabaseUtils.getConnection();
	    String sql = "SELECT * FROM Account";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   
	    ResultSet resultSet = preparedStatement.executeQuery();
	    try {
	      while(resultSet.next()) {
	        listAccount.add(new Account(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4)));
	      }
	      
	    } finally {
	      DatabaseUtils.closeConnection(connection);
	    }
	  return listAccount;
  }
  public void updateBalance(long balanceRest,String account) throws ClassNotFoundException, IOException, SQLException {
	  Connection connection = DatabaseUtils.getConnection();
	    String sql = "UPDATE Account set balance = balance-? where account = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   preparedStatement.setLong(1,balanceRest);
	   preparedStatement.setString(2,account);
	   preparedStatement.executeQuery();
	      DatabaseUtils.closeConnection(connection);
	    
	  
  }
  
  public void changePass(String newPass,String account) throws ClassNotFoundException, IOException, SQLException {
	  Connection connection = DatabaseUtils.getConnection();
	    String sql = "UPDATE Account set pass_word = ? where account = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   preparedStatement.setString(1,newPass);
	   preparedStatement.setString(2,account);
	   preparedStatement.executeQuery();
	      DatabaseUtils.closeConnection(connection);
	    
	  
  }
  
  
 
  /*public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
	AccountDao a = new AccountDao();
	
	
	a.changePass("87654321", a.getListAccount().get(0).getAccount());
	for (Account c : a.getListAccount()) {
		System.out.println(c.getPassword());
	} 
}*/
}
