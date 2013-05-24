package models;

import java.sql.*;
import javax.swing.JOptionPane;

public abstract class Database_Model {

	
	
	protected static Connection getConnection() {

		String dbHost = "i-intra-02.informatik.hs-ulm.de";
		String dbPort = "3306";
		String database = "wfprj_wf5_15";
		String dbUser = "wfprj_wf5_15";
		String dbPassword = "wfprj_wf5_15";

		Connection conn = null;
		try {
			// Loading MySQL Driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + database + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPassword);

			// catch Error: MySQL Driver not found
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "MySQL Driver not found.",
					"Information", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			// catch Error: Connection to Database failed
		} catch (SQLException e) {
			JOptionPane
					.showMessageDialog(null,
							"Connection to Database failed \ndbHost: " + dbHost
									+ "\ndbPort: " + dbPort + "\ndatabase: "
									+ database, "Information",
							JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			// catch other Errors
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Unexpected Error.",
					"Information", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		return conn;
	}


	

}