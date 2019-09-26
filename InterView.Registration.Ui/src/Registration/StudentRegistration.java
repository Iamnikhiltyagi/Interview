package Registration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interview.logic.layer.InterViwer;
import questions.Utility.AnswerOptionPojo;
import questions.Utility.QuestionPojo;
import questions.logic.layer.McqQuestion;

public class StudentRegistration {

	static boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	// interviewer new registration
	public void register() throws ClassNotFoundException, SQLException {
		System.out.println("Welcome!!!! Please Enter Details For Registration  ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();

		System.out.println("Enter Email id ");
		String email = sc.nextLine();

		System.out.println("Enter Address ");
		String address = sc.nextLine();

		System.out.println("Enter Phone Number ");
		String phoneNumber = sc.next();

		sc.close();
		InterViwer interviwer = new InterViwer();
		interviwer.createRecord(name, email, address, phoneNumber);
		System.out.println("hillo git");

	}

	// get all question randomly from question_paper db
	public void questionPaper() throws ClassNotFoundException, SQLException {
		int count = 0;

		List<McqQuestion> allQuestions = McqQuestion.showQuestions();
		int i = 0;
		for (McqQuestion question : allQuestions) {
			i++;
			System.out.println("Question:" + i);
			System.out.print("\t" + question.getQuestion());
			System.out.println();

			List<AnswerOptionPojo> allOptions = question.showOptions();
			for (AnswerOptionPojo anOptionForThisQuestion : allOptions) {
				System.out.println(anOptionForThisQuestion.option);
			}
			System.out.println();

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String ans = sc.next();
			if (ans.equals(question.getCurrectAnswer())) {
				count++;
			}

		}
		System.out.println("Correct answers are :" + count);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("CHOICE\n1-->interviewer register\n2-->start test");
		System.out.println("enter your choice");
		StudentRegistration registration = new StudentRegistration();
		Scanner sc = new Scanner(System.in);
		int inputChoice = sc.nextInt();
		if (inputChoice == 1)
			registration.register();
		if (inputChoice == 2)
			registration.questionPaper();

	}

}
