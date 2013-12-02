package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * De database manager die een connectie maakt met de database
 * @author Stef en Roald
 * @since 1-11-2013
 * @version 2.0
 */
public class DBmanager {
	private static DBmanager uniqueInstance = null;
	private String user, password;
	private static Connection con = null;

	private DBmanager(String dbNaam) {
		user = "root";
		password = "a";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (!dbExists(dbNaam)) {
				System.err.println("DBmanager: De database bestaat niet....");
			}

			else {
				System.out.println("DBmanager: Database bestaat");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static synchronized DBmanager getInstance(String dbNaam) {
		if (uniqueInstance == null) {
			uniqueInstance = new DBmanager(dbNaam);
		}
		return uniqueInstance;
	}

    public Boolean dbExists(String dbNaam) {
		Boolean exists = true;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ dbNaam, user, password);
			System.out.println("DBManager: Connected");
		} catch (Exception e) {
			System.out.println(e);
			exists = false;
		}
		return (exists);
	}

    public void close() {
		try {
			con.close();
			uniqueInstance = null;
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public Connection getConnection() {
		return con;
	}
}