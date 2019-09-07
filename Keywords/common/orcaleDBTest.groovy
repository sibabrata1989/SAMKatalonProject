package common

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.mysql.jdbc.Connection

public class orcaleDBTest {
	private static Connection connection = null;
	//Establishing a connection to the DataBase
	 
	@Keyword
	 
	def connectDB(String url, String dbname, String port, String username, String password){
	String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname	 
	if(connection != null && !connection.isClosed()){
	connection.close()
	}
	connection = DriverManager.getConnection(conn, username, password) 
	return connection
	 
	}
	
	 
	//Executing the constructed Query and Saving results in resultset
	 
	@Keyword
	 
	def executeQuery(String queryString) { 
	Statement stm = connection.createStatement()
	ResultSet rs = stm.executeQuery(queryString)
	return rs
	 
	}
	 
	//Closing the connection
	 
	@Keyword
	 
	def closeDatabaseConnection() {
	if(connection != null && !connection.isClosed()){
	connection.close() 
	}
	connection = null
	 
	}
	 
	//Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	@Keyword
	def execute(String queryString) {
	Statement stm = connection.createStatement()
	boolean result = stm.execute(queryString)
	return result
	 
	}
	 
}
