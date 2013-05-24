package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Priorität extends Database_Model {

	public String id;
	public String bezeichnung;
	
	public ArrayList<Priorität> inhalt;

	public Priorität(String id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}
	
	public Priorität(){
		this.inhalt = all();
	}
	
	public ArrayList<Priorität> getArray(){
		return this.inhalt;
	}
	public static ArrayList<Priorität> all() {
		Connection con = getConnection();
		ArrayList<Priorität> attribute = new ArrayList<Priorität>();
		Statement query;
		try {
			query = con.createStatement();
			String sql = "SELECT * FROM Prioritaet"; // Tabelle eintragen

			ResultSet result = query.executeQuery(sql);
			while (result.next()) {
				attribute.add(getPrioritätWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attribute;
	}

	private static Priorität getPrioritätWithResultSet(ResultSet result) {

		Priorität priorität = null;

		try {

			String id = result.getString("idPrioritaet"); // Tabelle eintragen
			String bezeichnung = result.getString("bezeichnung");

			priorität= new Priorität(id, bezeichnung);

		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler beim Erstellen des Objektes");
		}

		return priorität;

	}
	
	

	@Override
	public String toString() {
		return this.bezeichnung;
	}
	

}
