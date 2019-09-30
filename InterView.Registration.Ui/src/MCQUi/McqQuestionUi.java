package MCQUi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import questions.Utility.AnswerOptionPojo;
import questions.logic.layer.McqQuestion;
import result.logic.layer.Result;

public class McqQuestionUi  {


	public void questionPaper(String name, String email, String address, String phoneNumber)
			throws ClassNotFoundException, SQLException {
		int count = 0;
		long startTime = System.currentTimeMillis();
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
				System.out.println("\t" + ch + ". " + anOptionForThisQuestion.options);
				ch++;
			}
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String ans = sc.next().toLowerCase();
			char c = ans.charAt(0);
			outer:
			if (c >= 'a' & c < ch) {
				if (ans.equals(question.getCurrectAnswerId())) {
					count++;
				}
			} else {
				System.err.println("Enter correct choice please: ");
				ans = sc.next().toLowerCase();
				break  outer;
			}
		
      }
		// System.out.println("total marks:" + count);
		Result rslt = new Result();
		rslt.storeResult(name, email, address, phoneNumber, count);

		System.out.println("Correct answers are :" + count);

		long stopTime = System.currentTimeMillis();
		Long elapsedTime = stopTime - startTime;

		long diffSeconds = elapsedTime / 1000 % 60;
		long diffMinutes = elapsedTime / (60 * 1000) % 60;
		long diffHours = elapsedTime / (60 * 60 * 1000) % 24;
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");

	}

}
