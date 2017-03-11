package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/studentmanagement";
	public static final String USER = "darilu44";
	public static final String PASSWORD = "darilu44";

	/* private constructor */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* Create a new connection to the database */
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to establish a connection to the database");
		}
		return connection;
	}

	/* Get the current connection to the database */
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
