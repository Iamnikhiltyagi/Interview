package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection con = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12306643", "sql12306643",
					"u5uX7S5qgb");
		} catch (Exception e) {
		}
	}

	public static Connection getConnection() {
		return con;
	}

}