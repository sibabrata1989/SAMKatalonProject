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
	 
	def connectDB(String username, String password){
	String conn = 'jdbc:oracle:thin:@nitstdb3.ci0hkmd2sbmx.ap-southeast-2.rds.amazonaws.com:1521:NIDB'	 
	if(connection != null && !connection.isClosed()){
	connection.close()
	}
	connection = DriverManager.getConnection(conn, username, password) 
	return connection
	 
	}
	
	 
	//Executing the constructed Query and Saving results in resultset
	 
	@Keyword
	 
	def executeQuery(String event) { 
	Statement stm = connection.createStatement()
	String query = 'select EVENT_UUID, Event_name from Event where Event_name = eventName and COMPANY_ID = 561'
	String selectQuery = query.replace('eventName', event)
	ResultSet rs = stm.executeQuery(selectQuery)
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
