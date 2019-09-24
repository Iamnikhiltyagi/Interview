package questions.logic.layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MCQ.Db.MCQDataBase;
import questions.Utility.QuestionsPojo;

public class MCQQuestions {

	public QuestionsPojo mypojo = null;

	public MCQQuestions(QuestionsPojo pojo) {
		this.mypojo = pojo;
	}

	public String getQuesion() {
		return this.mypojo.question;
	}

	public String getOptionA() {
		return this.mypojo.optionA;
	}

	public String getOptionB() {
		return this.mypojo.optionB;
	}

	public String getOptionC() {
		return this.mypojo.optionC;
	}

	public String getOptionD() {
		return this.mypojo.optionD;
	}

	public String getCurrectAnswer() {
		return this.mypojo.correctOption;
	}
	//get all question randomly from question_paper db
	public static List<MCQQuestions> showQuestions() throws ClassNotFoundException, SQLException {
		MCQDataBase mcqDB = new MCQDataBase();
		List<QuestionsPojo> questionPojo = mcqDB.getQuestions();
		List<MCQQuestions> questions = new ArrayList<>();
		for (QuestionsPojo pojo : questionPojo) {
			questions.add(new MCQQuestions(pojo));
		}
		return questions;
	}

}
