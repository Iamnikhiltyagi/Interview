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
	//interviewer new registration
	public void register() throws ClassNotFoundException, SQLException
	{
		System.out.println("Welcome!!!! Please Enter Details For Registration  ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Email id ");
		String email=sc.nextLine();
		
		System.out.println("Enter Address ");
		String address=sc.nextLine();
		
		System.out.println("Enter Phone Number ");
		String phoneNumber=sc.next();
		
		sc.close();
		InterViwer interviwer=new InterViwer();
		interviwer.createRecord(name, email, address, phoneNumber);
		System.out.println("hillo git");
		
		
	}
	//get all question randomly from question_paper db
	public void questionPaper() throws ClassNotFoundException, SQLException
	{
		
		List<MCQQuestions> allQuestion = MCQQuestions.showQuestions();
		int i = 0;
		for (MCQQuestions question : allQuestion) {
			i++;
			System.out.print(i + "--->");
<<<<<<< HEAD
			System.out.println("\t " +question.getQuesion());
			System.out.println("\t a. " + question.getOptionA());
			System.out.println("\t b. " + question.getOptionB());
			System.out.println("\t c. " + question.getOptionC());
			System.out.println("\t d. " + question.getOptionD());
=======
			System.out.print("\t" +question.getQuesion());
			System.out.println();
			System.out.print("\t" + question.getOptionA());
			System.out.print("\t" + question.getOptionB());
			System.out.print("\t" + question.getOptionC());
			System.out.print("\t" + question.getOptionD());
>>>>>>> 7ffefc2a07baae3b2722ea9f1b1f83a8b0e3919b
			System.out.println();
		}

	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	
		StudentRegistration registration=new StudentRegistration();
		//registration.register();
		InterViwer iv=new InterViwer();
		iv.Questions();
		registration.questionPaper();
		
	}

}
