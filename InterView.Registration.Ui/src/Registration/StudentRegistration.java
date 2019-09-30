package Registration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Exception.ValidationException;
import MCQUi.McqQuestionUi;
import QuestionEntry.EnterQuestion;
import util.Utility;

public class StudentRegistration {

	// interviewer new registration
	public void register() throws ClassNotFoundException, SQLException, ValidationException, IOException {

		System.out.println(
				"Welcome!!!! \n--------------------------------------------------------------\nPlease Enter Details For Registration  ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();
		while (name.isEmpty()) {
			System.out.println("name can't be empty");
			name = sc.nextLine();
		}
		System.out.println("Enter Email id ");
		String email = sc.nextLine();
		while (email.isEmpty()) {
			System.err.println("can not be empty, Please enter again");
			email = sc.nextLine();
		}
		while (Utility.isEmailValid(email) != true) {
			System.err.println("email id not valid, Please enter again");
			email = sc.nextLine();
		}

		System.out.println("Enter Address ");
		String address = sc.nextLine();
		System.out.println();
		while (address.isEmpty()) {
			System.out.println("address can't be empty");
			address = sc.nextLine();
		}
		System.out.println("Enter Phone Number ");
		String phoneNumber = sc.next();
		while (phoneNumber.isEmpty()) {
			System.out.println("phoneNumber can't be empty");
			phoneNumber = sc.nextLine();
		}

		// InterViwer interviwer = new InterViwer();
		// interviwer.createRecord(name, email, address, phoneNumber);

		System.out.println("To Start test press \"enter\" to continue to MCQ Questions");
		System.in.read();

		McqQuestionUi mcqQstnUi = new McqQuestionUi();
		mcqQstnUi.questionPaper(name, email, address, phoneNumber);
		sc.close();

	}

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, ValidationException, IOException {

		System.out.println("CHOICE\n1-->interviewer register\n2-->Inserting Question to database");
		System.out.println("enter your choice");
		EnterQuestion enterQ = new EnterQuestion();
		StudentRegistration registration = new StudentRegistration();
		Scanner sc = new Scanner(System.in);
		int inputChoice = sc.nextInt();
		if (inputChoice == 1) {
			System.out.println(
					"Total Time-30 second,Total Marks-3.\n--------------------------------------------------------------");
			Timer timer = new Timer();
			TimerTask task = new McqQuestionUi();

			timer.schedule(task, 2000, 1000);

			registration.register();
		}

		if (inputChoice == 2)
			enterQ.QuestionEntering();

		sc.close();

	}

}
