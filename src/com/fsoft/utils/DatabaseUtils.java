package com.fsoft.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.fsoft.dao.AccountDao;

public class DatabaseUtils {
  static final String FILE_NAME = "/DBConfig.properties";

  public static Connection getConnection()
      throws IOException, ClassNotFoundException, SQLException {
    Properties properties = new Properties();
    properties.load(DatabaseUtils.class.getResourceAsStream(FILE_NAME));
    String driver = properties.getProperty("driver");
    String server = properties.getProperty("server");
    String dbName = properties.getProperty("dbname");
    String user = properties.getProperty("user");
    String pass = properties.getProperty("pass");

    Class.forName(driver);
    return DriverManager.getConnection(server + ";databaseName=" + dbName, user,
        pass);
  }

  
  public static void closeConnection(Connection connection)
      throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }
  public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		if(getConnection()!=null) {
			System.out.println("Success!");
		}
		
	}

}
