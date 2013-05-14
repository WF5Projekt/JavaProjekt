package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Kategorie extends Database_Model{
	
	public String id;
	public String bezeichnung;
	
	public Kategorie(String id, String bezeichnung){
		this.id = id;
		this.bezeichnung = bezeichnung;
	}
	
	 public static ArrayList<Kategorie> all() {
	        Connection con = getConnection();
	        ArrayList<Kategorie> attribute = new ArrayList<Kategorie>();
	        Statement query;
	        try {
	            query = con.createStatement();
	            String sql = "SELECT * FROM Kategorie";								//Tabelle eintragen

	            ResultSet result = query.executeQuery(sql);
	            while (result.next()) {
	                attribute.add(getKategorieWithResultSet(result));
	            }
	            query.close();
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return attribute;
	    }
	 private static Kategorie getKategorieWithResultSet(ResultSet result) {

		 Kategorie kategorie = null;

			try {
				
				String id = result.getString("idKategorie");					// Tabelle eintragen
				String bezeichnung = result.getString("bezeichnung");
				
				
				kategorie = new Kategorie( id, bezeichnung);

			} catch (SQLException e) {
				JOptionPane
						.showInputDialog("Fehler beim Erstellen der Kategorie-Kombobox");
			}

			return kategorie;

		}
	 @Override
	    public String toString() {
	        return this.bezeichnung;
	    }
}
