package MCQ.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbUtil.ConnectionProvider;
import questions.Utility.AnswerOptionPojo;
import questions.Utility.QuestionPojo;

public class MCQDataBase {
	private static final String jdbcURL = "com.mysql.jdbc.Driver";

	/*
	 * public void retrieveQuestions() throws ClassNotFoundException,
	 * SQLException { Class.forName(jdbcURL); Connection connection =
	 * DriverManager.getConnection("jdbc:mysql://192.168.1.188:3306/interview",
	 * "root", "9910"); // Connection connection =
	 * DriverManager.getConnection("jdbc:mysql://192.168.0.105:3306/interview",
	 * "root", // "9910"); System.out.println("Connection Success\n");
	 * PreparedStatement preparedStatement = connection
	 * .prepareStatement("SELECT * FROM question_paper ORDER BY RAND() LIMIT 3;"
	 * ); System.out.println("preparedStatement"); ResultSet rs =
	 * preparedStatement.executeQuery();
	 * 
	 * while (rs.next()) { System.out.println(" Question is: " + rs.getString(1)
	 * + "\n Option a is: " + rs.getString(2) + "\n Option b is: " +
	 * rs.getString(3) + "\n Option c is: " + rs.getString(4) +
	 * "\n Option d is: " + rs.getString(5) + "\n answer " + rs.getString(6)); }
	 * }
	 */

	// get all question randomly from question_paper db

	public List<QuestionPojo> getQuestions() throws SQLException, ClassNotFoundException {
		List<QuestionPojo> questionsList = new ArrayList<>();
		Class.forName(jdbcURL);
		/*
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://192.168.1.188:3306/interview", "root", "9910"); //
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://192.168.0.105:3306/interview", "root", // "9910");
		 */
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM mcqquestions ORDER BY RAND() LIMIT 3 ;");

		// PreparedStatement preparedStatement = connection.prepareStatement(
		// "SELECT t1.question,t2.options from mcq_question t1 inner join
		// mcq_option t2 on t1.question_id=t2.question_id;");

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			QuestionPojo questionPojo = new QuestionPojo();
			questionPojo.question = rs.getString(3);
			questionPojo.questionId = rs.getString(1);
			questionPojo.currect_option = rs.getString(4);
			questionsList.add(questionPojo);
		}
		return questionsList;
	}

	public List<AnswerOptionPojo> getOptions() throws ClassNotFoundException, SQLException {
		List<AnswerOptionPojo> optionsList = new ArrayList<>();
		Class.forName(jdbcURL);
		/*
		 * Connection connection = DriverManager.getConnection(
		 * "jdbc:mysql://192.168.1.188:3306/interview", "root", "9910"); //
		 * Connection connection = // DriverManager.getConnection(
		 * "jdbc:mysql://192.168.0.105:3306/interview", // "root", // "9910");
		 */ Connection connection = ConnectionProvider.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from mcqoptions;");
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			AnswerOptionPojo answerPojo = new AnswerOptionPojo();
			answerPojo.questionId = rs.getString(1);
			answerPojo.optionId = rs.getString(4);
			answerPojo.options = rs.getString(2);
			optionsList.add(answerPojo);
		}

		return optionsList;
	}
}
