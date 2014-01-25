package evaluation.database;

import java.sql.*;

public class EvaluationDatabase {
	
	private static String _USER;
	private static String _PASS;
	
	private static String _JDBC_DRIVER, _DB_URL;
	private static String cmd;

	Connection c = null;
	Statement stmt = null;
	ResultSet rs;
	
	public EvaluationDatabase(String driver, String url, String user, String pass)
	{
		try {
			_JDBC_DRIVER = driver;
			_DB_URL = url;
			System.out.println(_JDBC_DRIVER);
			Class.forName( _JDBC_DRIVER  );
			c = DriverManager.getConnection( _DB_URL , user, pass);
			stmt = c.createStatement();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public ResultSet getTables()
	{
		cmd = "SELECT name FROM sqlite_master WHERE type='table'";
		try {
			stmt.execute(cmd);
			//return stmt.toString();
			return rs = stmt.executeQuery(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
		
}


