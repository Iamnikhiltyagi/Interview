package MCQUi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import questions.logic.layer.McqQuestion;
import result.logic.layer.Result;
import userResult.ResultPojo;
import questions.Utility.AnswerOptionPojo;

public class McqQuestionUi {
	
	public void questionPaper(String name, String email, String address, String phoneNumber) throws ClassNotFoundException, SQLException {
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
		Result rslt=new Result();
		rslt.storeResult(name,email,address,phoneNumber,count);
		//System.out.println("Correct answers are :" + count);

	}

}
