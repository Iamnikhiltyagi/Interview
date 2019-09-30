package MCQUi;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import questions.Utility.AnswerOptionPojo;
import questions.logic.layer.McqQuestion;
import result.logic.layer.Result;

public class McqQuestionUi extends TimerTask {

	public static int i = 0;

	@Override
	public void run() {
		i++;
		if (i > 30) {
			System.out.println("time over");
			System.exit(i);
		}

	}

	public void questionPaper(String name, String email, String address, String phoneNumber)
			throws ClassNotFoundException, SQLException {
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
				System.out.println("\t" + ch + ". " + anOptionForThisQuestion.options);
				ch++;
			}
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			String ans = sc.next();
			if (ans.equals(question.getCurrectAnswerId())) {
				count++;

			}

		}
		// System.out.println("total marks:" + count);
		Result rslt = new Result();
		rslt.storeResult(name, email, address, phoneNumber, count);

		System.out.println("Correct answers are :" + count);

	}

}
