package question.insert.Db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbUtil.ConnectionProvider;

import java.sql.Connection;

public class InsertQuestion {

	private static final String jdbcURL = "com.mysql.jdbc.Driver";

	public void insertingOption(String option, String qid, char option_label, String option_id)
			throws SQLException, ClassNotFoundException {
		String oplabel = Character.toString(option_label);
		/*
		 * Class.forName(jdbcURL); Connection connection =
		 * DriverManager.getConnection(
		 * "jdbc:mysql://192.168.1.188:3306/interview", "root", "9910");
		 */
		Connection connection=ConnectionProvider.getConnection();
		System.out.println("Connection Success\n");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into mcqoptions values(?,?,?,?);");

		preparedStatement.setString(1, qid);
		preparedStatement.setString(2, option);
		preparedStatement.setString(3, oplabel);
		preparedStatement.setString(4, option_id);

		int numberOfRowsUpdated = preparedStatement.executeUpdate();
		if (numberOfRowsUpdated != 1)
			throw new SQLException("Number of Rows Updated: " + numberOfRowsUpdated);
		preparedStatement.close();
	}

	public void insertingQuestion(String qid, String question, String correct_option)
			throws SQLException, ClassNotFoundException {
		/*
		 * Class.forName(jdbcURL); Connection connection =
		 * DriverManager.getConnection(
		 * "jdbc:mysql://192.168.1.188:3306/interview", "root", "9910");
		 */
		Connection connection=ConnectionProvider.getConnection();
		System.out.println("Connection Success\n");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into mcqquestions values(?,?,?,?);");

		preparedStatement.setString(1, qid);
		preparedStatement.setInt(2, 0);
		preparedStatement.setString(3, question);
		preparedStatement.setString(4, correct_option);

		int numberOfRowsUpdated = preparedStatement.executeUpdate();
		if (numberOfRowsUpdated != 1)
			throw new SQLException("Number of Rows Updated: " + numberOfRowsUpdated);
		preparedStatement.close();
	}
	
	public void deletingQuestion() throws SQLException
	{
		Connection connection=ConnectionProvider.getConnection();
		System.out.println("Connection Success\n");
		PreparedStatement preparedStatement = connection.prepareStatement("delete from mcqquestions ;");

	}

}
