package QuestionEntry;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

import questionentry.logic.layer.Question;
import questions.Utility.PojoQuestion;

public class EnterQuestion {
	
	Question q=new Question();
	
	static int qstn_number=0;
	public void QuestionEntering() throws ClassNotFoundException, SQLException
	{
		PojoQuestion qPojo=new PojoQuestion();
		qPojo.q_id=UUID.randomUUID().toString();
		String qid=qPojo.q_id;
		qstn_number++;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter "+qstn_number+" question");
		String question=sc.nextLine();
		System.out.println("Enter 'y' to enter options");
		String ch=sc.next().toLowerCase();
		
		while(ch.equals("y"))
		{
			q.insertOption(qid);
			System.out.println("Do you want to enter more options??? \nPlease press  y  to enter more options");
			ch=sc.next().toLowerCase();
		}
		
		System.out.println("Enter correct option ");
		sc.nextLine();
		String correct_option=sc.nextLine();
		
		
		q.insertQuestion(qid, question, correct_option);
	}
	public void midQuestionEntering() throws ClassNotFoundException, SQLException
	{
		
		PojoQuestion qPojo=new PojoQuestion();
		qPojo.q_id=UUID.randomUUID().toString();
		String qid=qPojo.q_id;
		qstn_number++;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter "+qstn_number+" question");
		String question=sc.nextLine();
		System.out.println("Enter 'y' to enter options");
		String ch=sc.next().toLowerCase();
		
		while(ch.equals("y"))
		{
			q.midinsertOption(qid);
			System.out.println("Do you want to enter more options??? \nPlease press  y  to enter more options");
			ch=sc.next().toLowerCase();
		}
		
		System.out.println("Enter correct option ");
		sc.nextLine();
		String correct_option=sc.nextLine();
		
		
		q.midinsertQuestion(qid, question, correct_option);
	}
	
	public void delete() throws SQLException
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Question id you want to delete");
		String qid=sc.nextLine();
		q.deletingQuestion(qid);
	}

}
