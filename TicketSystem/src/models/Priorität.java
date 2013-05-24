package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Priorit�t extends Database_Model {

	public String id;
	public String bezeichnung;
	
	public ArrayList<Priorit�t> inhalt;

	public Priorit�t(String id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}
	
	public Priorit�t(){
		this.inhalt = all();
	}
	
	public ArrayList<Priorit�t> getArray(){
		return this.inhalt;
	}
	public static ArrayList<Priorit�t> all() {
		Connection con = getConnection();
		ArrayList<Priorit�t> attribute = new ArrayList<Priorit�t>();
		Statement query;
		try {
			query = con.createStatement();
			String sql = "SELECT * FROM Prioritaet"; // Tabelle eintragen

			ResultSet result = query.executeQuery(sql);
			while (result.next()) {
				attribute.add(getPriorit�tWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attribute;
	}

	private static Priorit�t getPriorit�tWithResultSet(ResultSet result) {

		Priorit�t priorit�t = null;

		try {

			String id = result.getString("idPrioritaet"); // Tabelle eintragen
			String bezeichnung = result.getString("bezeichnung");

			priorit�t= new Priorit�t(id, bezeichnung);

		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler beim Erstellen des Objektes");
		}

		return priorit�t;

	}
	
	

	@Override
	public String toString() {
		return this.bezeichnung;
	}
	

}
