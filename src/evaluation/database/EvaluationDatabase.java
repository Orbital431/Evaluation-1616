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
		
	public ResultSet getTables() throws SQLException
	{
		DatabaseMetaData md = c.getMetaData();
		return rs = md.getTables(null, null, "%", null);
	}
		
	public int createTable() throws SQLException
	{
		stmt = c.createStatement();
		cmd = "CREATE TABLE EVALUATION " +
				"(id INTEGER not NULL, " +
				"name VARCHAR(255) not NULL, " +
				"rate VARCHAR(7) not NULL, " +
				"desig VARCHAR(7) NULL, " +
				"ssn VARCHAR(11) not NULL , " +
				"PRIMARY KEY (id) )";
		return stmt.executeUpdate(cmd);
	}
}


