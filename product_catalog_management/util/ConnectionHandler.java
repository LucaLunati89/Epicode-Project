package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

	//declare constant that represent parameters that DriverManager Class use for connection with DB
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/Store";
	public static final String DB_USERNAME = "postgres";
	public static final String DB_PASSWORD = "postgres";

	//private attribute of type Connection
	private Connection connection;

	//create a constructor to handling the Connection whit database
	public ConnectionHandler() throws ClassNotFoundException {

		//driver postgresql
		Class.forName("org.postgresql.Driver");

	}

	public Connection getConnection() throws SQLException {

		// create a value for connection that get connection
		if ( connection == null || connection.isClosed() ) {
			connection = DriverManager.getConnection( DB_URL, DB_USERNAME, DB_PASSWORD );
		}

		return connection;
	}

	public void closeConnection() throws SQLException{

		// create a value of null to connection and close it
		if ( connection != null && !connection.isClosed() ) {
			connection.close();
			connection = null;
		}
	}

}
