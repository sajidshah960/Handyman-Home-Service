package interfaces;

import java.sql.*;


public class DBHandler {
	Statement stmt;
	Connection conn;
	ResultSet result;
	int _result;

	public ResultSet _executeQuery(String q) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/handyhomeservices?autoReconnect=true&useSSL=false","root","1234");
			this.stmt = conn.createStatement();
			this.result =  this.stmt.executeQuery(q);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this.result;
	}
public int _insertQuery(String q) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/handyhomeservices?autoReconnect=true&useSSL=false","root","1234");
			this.stmt = conn.createStatement();
			this._result =  this.stmt.executeUpdate(q);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this._result;
	}
	
	
	
};
