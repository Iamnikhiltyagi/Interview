package Registration;

import java.sql.SQLException;
import java.util.Scanner;

import interview.logic.layer.InterViwer;

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
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
	
		//StudentRegistration registration=new StudentRegistration();
		//registration.register();
		InterViwer iv=new InterViwer();
		iv.Questions();
		
	}

}
