package questionentry.logic.layer;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

import question.insert.Db.InsertQuestion;
import questions.Utility.PojoOptions;
import questions.Utility.PojoQuestion;

public class Question {

	char  option_label='a';
	
	public void insertOption(String qid) throws ClassNotFoundException, SQLException
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter "+option_label+" option");
		
		String option=sc.nextLine();
		
		PojoOptions pOption = new PojoOptions();
		pOption.option_id=UUID.randomUUID().toString();
		String opId=pOption.option_id;
		pOption.q_id=qid;
		pOption.options=option;
		pOption.option_label=option_label;
		
		InsertQuestion insertQ=new InsertQuestion();
		insertQ.insertingOption(option,qid,option_label,opId);
		
		option_label++;
	}
	
	public void insertQuestion(String qid,int qstn_number,String question,String correct_option ) throws ClassNotFoundException, SQLException
	{
		PojoQuestion pQstn=new PojoQuestion();
		pQstn.q_id=qid;
		pQstn.question_number=qstn_number;
		pQstn.question=question;
		pQstn.correct_option=correct_option;
		
		InsertQuestion insertQ=new InsertQuestion();
		insertQ.insertingQuestion(qid, qstn_number, question, correct_option);
	}
}
