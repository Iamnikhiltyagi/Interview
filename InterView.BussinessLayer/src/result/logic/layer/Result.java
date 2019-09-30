package result.logic.layer;

import java.sql.SQLException;

import result.Db.ResultDb;
import userResult.ResultPojo;

public class Result {

	public void storeResult(String name, String email, String address, String phoneNumber, int mcq_marks)
			throws ClassNotFoundException, SQLException {
		ResultPojo resultpojo = new ResultPojo();
		resultpojo.name = name;
		resultpojo.address = address;
		resultpojo.email = email;
		resultpojo.phoneNumber = phoneNumber;
		resultpojo.mcq_marks = mcq_marks;
		ResultDb resultDB = new ResultDb();
		resultDB.insertingUserResult(resultpojo);
	}

}
