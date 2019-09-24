package interview.logic.layer;

import java.sql.SQLException;

import MCQ.Db.MCQDataBase;
import interviewer.Utility.InterViwerPojo;
import interviwer.Db.InterviwerDb;

public class InterViwer {
	
	public void createRecord(String name,String email,String address,String phoneNumber) throws ClassNotFoundException, SQLException
	{
		InterViwerPojo interviwerPojo=new InterViwerPojo();
		interviwerPojo.name=name;
		interviwerPojo.email=email;
		interviwerPojo.address=address;
		interviwerPojo.phoneNumber=phoneNumber;
		
		InterviwerDb interviwerDb=new InterviwerDb();
		interviwerDb.insertingInterviwerRecord(interviwerPojo);
	}
	
	public void Questions() throws ClassNotFoundException, SQLException
	{
		MCQDataBase db=new MCQDataBase();
		db.retrieveQuestions();
	}

}
