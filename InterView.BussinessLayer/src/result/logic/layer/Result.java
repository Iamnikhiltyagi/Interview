package result.logic.layer;

import java.sql.SQLException;

import result.Db.ResultDb;
import userResult.ResultPojo;

public class Result {

	public void storeResult(String name, String email, String address, String phoneNumber, int mcq_marks)
			throws ClassNotFoundException, SQLException {
		ResultPojo rpojo = new ResultPojo();
		rpojo.name = name;
		rpojo.address = address;
		rpojo.email = email;
		rpojo.phoneNumber = phoneNumber;
		rpojo.mcq_marks = mcq_marks;
		ResultDb rDB = new ResultDb();
		rDB.insertingUserResult(rpojo);
	}

}
