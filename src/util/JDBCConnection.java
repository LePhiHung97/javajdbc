package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String hostName = "3307";
		String dbName = "studentDB";
		String userName = "root";
		String password = "lephihung";

		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://localhost:" + hostName + "/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

}
