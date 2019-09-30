package questions.logic.layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import MCQ.Db.MCQDataBase;
import questions.Utility.AnswerOptionPojo;
import questions.Utility.QuestionPojo;

public class McqQuestion {

	private QuestionPojo mypojo = null;

	// private AnswerOptionPojo answerPojo=null;

	public List<AnswerOptionPojo> myOptions = new ArrayList<AnswerOptionPojo>();

	public McqQuestion(QuestionPojo pojo, List<AnswerOptionPojo> allAnswers) {
		this.mypojo = pojo;

		// ==============1===================
		// for(AnswerOptionPojo itm : allAnswers) {
		// if(itm.questionId == pojo.questionId) {
		// myOptions.add(itm);
		// }
		// }

		// ===============2===============
		myOptions = allAnswers.stream().filter(itm -> itm.questionId.equals(pojo.questionId))
				.collect(Collectors.toList());

	}

	public String getQuestion() {
		return this.mypojo.question;
	}

	public String getQuestionId() {
		return this.mypojo.questionId;
	}

	public String getCurrectAnswerId() {
		return this.mypojo.currect_option;
	}

	/*
	 * public String getAnsKey() { return this.mypojo.ans_key; }
	 */
	// get all question randomly from question_paper db
	public static List<McqQuestion> showQuestions() throws ClassNotFoundException, SQLException {
		MCQDataBase mcqDB = new MCQDataBase();
		List<QuestionPojo> questionPojos = mcqDB.getQuestions();
		List<AnswerOptionPojo> answerPojos = mcqDB.getOptions();
		List<McqQuestion> questions = new ArrayList<>();
		for (QuestionPojo questionPojo : questionPojos) {
			questions.add(new McqQuestion(questionPojo, answerPojos));
		}
		return questions;
	}

	public List<AnswerOptionPojo> showOptions() {
		return myOptions;
	}

}
