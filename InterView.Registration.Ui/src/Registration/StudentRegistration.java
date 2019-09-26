package Registration;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Exception.ValidationException;
import interview.logic.layer.InterViwer;
import questions.Utility.AnswerOptionPojo;
import questions.logic.layer.McqQuestion;
import util.Utility;

public class StudentRegistration {

	// interviewer new registration
	public void register() throws ClassNotFoundException, SQLException, ValidationException {
		
		System.out.println("Welcome!!!! Please Enter Details For Registration  ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();
		while(name.isEmpty())
		{
			System.out.println("name can't be empty");
			name=sc.nextLine();
		}
		System.out.println("Enter Email id ");
		String email = sc.nextLine();
		while(email.isEmpty())
		{
			System.err.println("can not be empty, Please enter again");
			email = sc.nextLine();
		}
		while(Utility.isEmailValid(email)!=true)
		{
			System.err.println("email id not valid, Please enter again");
			email = sc.nextLine();

		}
		
		System.out.println("Enter Address ");
		String address = sc.nextLine();
		System.out.println();
		while(address.isEmpty())
		{
			System.out.println("address can't be empty");
			address=sc.nextLine();
		}
		System.out.println("Enter Phone Number ");
		String phoneNumber = sc.next();
		while(phoneNumber.isEmpty())
		{
			System.out.println("phoneNumber can't be empty");
			phoneNumber=sc.nextLine();
		}
		sc.close();
		InterViwer interviwer = new InterViwer();
		interviwer.createRecord(name, email, address, phoneNumber);
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

			char ch = 'a';
			List<AnswerOptionPojo> allOptions = question.showOptions();
			for (AnswerOptionPojo anOptionForThisQuestion : allOptions) {
				System.out.println("\t" + ch + ". " + anOptionForThisQuestion.option);
				ch++;
			}
			System.out.println();

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String ans = sc.next();
			if (ans.equals(question.getAnsKey())) {
				count++;
			}

		}
		System.out.println("Correct answers are :" + count);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ValidationException {

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
