package com.userprofiling.database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class MySQLAccess {
	
	public Connection connection;
	public Statement statement;
	public ResultSet resultset;
	public PreparedStatement preparedstatement;
	
	public MySQLAccess()
	{
		Connect_To_DB con = new Connect_To_DB();
		connection = con.Create_Connection();
		System.out.println("Call to constructor.");
	}
	public void addToUsername(String screenname) throws SQLException
	{
		if(connection==null)
		{
			System.out.println("Failed to connect to database.");
		}
		else
		{
			preparedstatement = (PreparedStatement) connection.prepareStatement("INSERT INTO `username` VALUES (default,?);");
			preparedstatement.setString(1, screenname);
			preparedstatement.executeUpdate();
			System.out.println("insert complete");
		}
	}
	
}
