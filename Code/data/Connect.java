package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String Url = "jdbc:sqlserver://localhost:1433;databaseName=QLTV;user=sa;password=lamlamlam01";
			conn = DriverManager.getConnection(Url);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return conn;

	}

}