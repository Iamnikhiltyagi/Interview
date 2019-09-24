package MCQ.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import questions.Utility.QuestionsPojo;

public class MCQDataBase {
	private static final String jdbcURL = "com.mysql.jdbc.Driver";
	
	public void retrieveQuestions() throws ClassNotFoundException, SQLException
	{
		Class.forName(jdbcURL);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interview","root","9910");
		System.out.println("Connection Success\n");
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM question_paper ORDER BY RAND() LIMIT 3;");
		System.out.println("preparedStatement");
		ResultSet rs=preparedStatement.executeQuery();
		
		while(rs.next())
		{
			System.out.println(" Question is: " + rs.getString(1) + "\n Option a is: " + rs.getString(2)
		+ "\n Option b is: " + rs.getString(3) + "\n Option c is: " + rs.getString(4) + "\n Option d is: "
			+ rs.getString(5)+"\n answer "+rs.getString(6));
	System.out.println("---------------------------");
		}
	}
	
	public List<QuestionsPojo> getQuestions() throws SQLException, ClassNotFoundException
	{
		List<QuestionsPojo> questionsList=new ArrayList<>();
		Class.forName(jdbcURL);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/interview","root","9910");
		System.out.println("Connection Success\n");
		
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM question_paper ORDER BY RAND() LIMIT 3;");
		System.out.println("preparedStatement");
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next())
		{
			QuestionsPojo questionPojo=new QuestionsPojo();
			questionPojo.question=rs.getString(1);
			questionPojo.question=rs.getString(2);
			questionPojo.question=rs.getString(3);
			questionPojo.question=rs.getString(4);
			questionPojo.question=rs.getString(5);
			questionPojo.question=rs.getString(6);
			questionsList.add(questionPojo);
		}
		return questionsList;
	}
}
