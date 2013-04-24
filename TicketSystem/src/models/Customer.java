package models;



import java.sql.*;
import java.util.ArrayList;

public class Customer extends Database_Model {

    public String idKunde;
    public String name;
    public String vorname;



    public Customer(String idKunde, String name, String vorname) {
		this.idKunde = idKunde;
		this.name = name;
		this.vorname = vorname;
	}
    
	public Customer(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}


	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
    public static ArrayList<Customer> all() {
        
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        Connection con = getConnection();
        Statement query;
        try {
            query = con.createStatement();
            String sql = "SELECT * FROM kunde ORDER BY idKunde";

            ResultSet result = query.executeQuery(sql);
            //Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter mit Methode...
            while (result.next()) {
                customers.add(getCustomersWithResultSet(result));
            }
            query.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
    //Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Kunde
    private static Customer getCustomersWithResultSet(ResultSet result) {
        Customer newCustomer = null;
        try { 
            String idKunde = result.getString("idKunde");
            String name = result.getString("name");
            String vorname = result.getString("vorname");
            newCustomer = new Customer(idKunde, name, vorname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCustomer;

    }
    // 
    public Object[] toJTableArray() {
        Object[] customerAttributeArray = {this.idKunde, this.name, this.vorname};
        return customerAttributeArray;
    }
    
    // Speichern der Tabelle
    
    public void save() {
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "UPDATE kunde SET "
                    + "idKunde = '" + this.idKunde + "', "
                    + "name = '" + this.name + "', "
                    + "surname = '" + this.vorname
                    + "WHERE idKunde = '" + this.idKunde +"';";
            
            stmt.execute(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Lösche Kunde
    public void delete(){
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "DELETE FROM kunde "
                    + "WHERE idKunde = '" + this.idKunde +"';";
            stmt.execute(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
