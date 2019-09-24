package interviwer.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interviewer.Utility.InterViwerPojo;

public class InterviwerDb {
	
	private static final String jdbcURL = "com.mysql.jdbc.Driver";
	
	public void insertingInterviwerRecord(InterViwerPojo interviwerpojo) throws ClassNotFoundException, SQLException
	{
		Class.forName(jdbcURL);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interview","root","9910");
		System.out.println("Connection Success\n");
		
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into interviwer_register values(?,?,?,?,?)");
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, interviwerpojo.name);
		preparedStatement.setString(3, interviwerpojo.address);
		preparedStatement.setString(4, interviwerpojo.email);
		preparedStatement.setString(5, interviwerpojo.phoneNumber);
		
		int numberOfRowsEffectted= preparedStatement.executeUpdate();
		preparedStatement.close();
		System.out.println("rows effected: "+numberOfRowsEffectted);
		
	}

}
