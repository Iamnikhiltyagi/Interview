package result.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbUtil.ConnectionProvider;
import userResult.ResultPojo;

public class ResultDb {
	private static final String jdbcURL = "com.mysql.jdbc.Driver";
	
	public void insertingUserResult(ResultPojo resultPojo) throws ClassNotFoundException, SQLException
	{
		Class.forName(jdbcURL);
		/*
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://192.168.1.188:3306/interview", "root", "9910"); //
		 * Connection connection = // DriverManager.getConnection(
		 * "jdbc:mysql://192.168.0.105:3306/interview", // "root", // "9910");
		 */		System.out.println("Connection Success\n");
		Connection connection=ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into result values(?,?,?,?,?,?)");
		
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, resultPojo.name);
		preparedStatement.setString(3, resultPojo.address);
		preparedStatement.setString(4, resultPojo.email);
		preparedStatement.setString(5, resultPojo.phoneNumber);
		preparedStatement.setInt(6,resultPojo.mcq_marks);
		
		int numberOfRowsUpdated = preparedStatement.executeUpdate();
		if (numberOfRowsUpdated != 1)
			throw new SQLException("Number of Rows Updated: " + numberOfRowsUpdated);
		preparedStatement.close();
	}

}
