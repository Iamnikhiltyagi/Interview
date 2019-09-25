package Registration;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import interview.logic.layer.InterViwer;
import questions.logic.layer.MCQQuestions;

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
<<<<<<< HEAD
		Scanner sc = new Scanner(System.in);
=======

>>>>>>> 5ae8e95d1ad33860b01e5a36cb2fedb09c474302
		List<MCQQuestions> allQuestion = MCQQuestions.showQuestions();
		int i = 0;
		for (MCQQuestions question : allQuestion) {
			i++;
			System.out.println("Question:" + i);
			System.out.print("\t" + question.getQuesion());
			System.out.println();
			System.out.println("\t a. " + question.getOptionA());
			System.out.println("\t b. " + question.getOptionB());
			System.out.println("\t c. " + question.getOptionC());
			System.out.println("\t d. " + question.getOptionD());
			System.out.println();
<<<<<<< HEAD

=======
			Scanner sc = new Scanner(System.in);
>>>>>>> 5ae8e95d1ad33860b01e5a36cb2fedb09c474302
			System.out.println("Enter your choice: ");
			String ans = sc.next();
			if (ans.equals(question.getCurrectAnswer())) {
				count++;
			}

		}
		System.out.println("Correct answers are :" + count);
<<<<<<< HEAD
		sc.close();
=======
>>>>>>> 5ae8e95d1ad33860b01e5a36cb2fedb09c474302

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
<<<<<<< HEAD
		System.out.println("hello .......");
		StudentRegistration registration = new StudentRegistration();
		// registration.register();
		// InterViwer iv=new InterViwer();
		// iv.Questions();
		registration.questionPaper();
		// MCQDataBase mc=new MCQDataBase();
		// mc.retrieveQuestions();
=======
		System.out.println("CHOICE\n1-->interviewer register\n2-->start test");
		System.out.println("enter your choice");
		StudentRegistration registration = new StudentRegistration();
		Scanner sc=new Scanner(System.in);
		int inputChoice=sc.nextInt();
		if(inputChoice==1)
		registration.register();
		if(inputChoice==2)
		registration.questionPaper();
>>>>>>> 5ae8e95d1ad33860b01e5a36cb2fedb09c474302

	}

}
