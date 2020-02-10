package alex.CarWashProject.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection conn;

private DBUtil() {}
	
	public static Connection openConnection() throws SQLException  {
		String url = "jdbc:mysql://localhost:3306/carwashdb?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "aa";
		String password = "1234";
		
		conn =  DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
	
}
