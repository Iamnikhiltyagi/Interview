package util;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.ValidationException;
//import Registration.StudentRegistration;


public class Utility {
	public static boolean isEmailValid(String email) {
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	 public static String emailValid(String email) throws ClassNotFoundException, SQLException, ValidationException
	   {
		 
		if(isStringEmpty(email)||Utility.isEmailValid(email)!=true)
		{
			throw new ValidationException("not valid try again");
		}
		return email;
		}
	 public static boolean isStringEmpty(String string)
	 {
		return string==null||string.isEmpty();
		 
	 }
	  public static boolean isValidphoneNumber(String PhoneNumber) 
	    { 
	      
	        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}"); 
	        Matcher m = p.matcher(PhoneNumber); 
	        return (m.find() && m.group().equals(PhoneNumber)); 
	    } 
}
