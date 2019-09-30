package MCQUi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import questions.Utility.AnswerOptionPojo;
import questions.logic.layer.McqQuestion;
import result.logic.layer.Result;

public class McqQuestionUi extends TimerTask {
	
	private static final String studentRecord="E:\\userrecord\\studentRecord.txt";

	public static int i = 0;

	@Override
	public void run() {
		i++;
		if (i > 120) {
			System.out.println("time over");
			System.exit(i);
		}

	}

	public void questionPaper(String name, String email, String address, String phoneNumber)
			throws ClassNotFoundException, SQLException, IOException {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		File file = new File(studentRecord);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		fw = new FileWriter(file.getAbsoluteFile(), true);
		bw = new BufferedWriter(fw);
		
		bw.append("name is: "+name);
		bw.newLine();
		bw.append("email is: "+email);
		bw.newLine();
		
		int count = 0;

		List<McqQuestion> allQuestions = McqQuestion.showQuestions();
		int i = 0;
		for (McqQuestion question : allQuestions) {
			i++;
			
			System.out.println("Question:" + i);
			System.out.print("\t" + question.getQuestion());
			
			bw.newLine();
			bw.append("Question:" + i + question.getQuestion());
			bw.newLine();
			bw.newLine();
			bw.append("\n");
			
			System.out.println();

			char ch = 'a';
			List<AnswerOptionPojo> allOptions = question.showOptions();
			for (AnswerOptionPojo anOptionForThisQuestion : allOptions) {
				System.out.println("\t" + ch + ". " + anOptionForThisQuestion.options);
				bw.append(ch + ". " + anOptionForThisQuestion.options);
				bw.newLine();
				ch++;
			}
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String ans = sc.next();
			bw.append("option choosen: "+ans);
			bw.newLine();
			bw.append("correct option is "+question.getCurrectAnswerId());
			bw.newLine();
			if (ans.equals(question.getCurrectAnswerId())) {
				bw.append("marks obtained 1");
				bw.newLine();
				count++;
			}
			else
			{
				bw.append("Marks obtained 0");
				bw.newLine();
			}
			
		 
//			( BufferedWriter bw = 
//					new BufferedWriter (new FileWriter (studentRecord)) ) 
					
		}
		bw.append("Total marks are "+count);
		bw.newLine();
		bw.append("----------------------------------------------------------");
		bw.newLine();
		bw.close();
		// System.out.println("total marks:" + count);
		Result rslt = new Result();
		rslt.storeResult(name, email, address, phoneNumber, count);

		System.out.println("Correct answers are :" + count);

	}

}
