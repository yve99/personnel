package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectExample {
	private static String driver = "mysql";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String host = "localhost";
	private static String port = "3306";
	private static String database = "";
	private static String user = "";
	private static String password = "";
	
	
	static String getUrl() 
	{
		return "jdbc:" + driver + "://" + host + "/" + database ;
	}
	
	static String getDriverClassName()
	{
		return driverClassName;
	}
	
	static String getUser() 
	{
		return user;
	}

	static String getPassword() 
	{
		return password;
	}
}
