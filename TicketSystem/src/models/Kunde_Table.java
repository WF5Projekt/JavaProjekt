package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Kunde_Table extends AbstractTableModel {

	private String[] columnNames = { 
			"ID", 
			"Vorname", 
			"Nachname", 
			"Strasse", 
			"Stadt", 
			"Geb.Datum", 
			"E-Mail",
			"Telefonnr.", 
			"Username"
	};
	private Object[][] data = {};
	private ArrayList<Kunde> customers;

	// Refresh der Daten für die Tabelle
	public void refreshData() {
		try {
			customers = Kunde.all();
			data = new Object[customers.size()][];
			for (int i = 0; i < customers.size(); i++) {
				Kunde c = customers.get(i);
				data[i] = c.toJTableArray();
			}
			this.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showInputDialog("Fehler in Kunden_Table");
		}
	}
	
	public void searchData(String spalte, String suche){
		try{
			customers = Kunde.search(spalte, suche);
			data = new Object[customers.size()][];
			for (int i = 0; i < customers.size(); i++) {
				Kunde kunde = customers.get(i);
				data[i] = kunde.toJTableArray();
			}
			this.fireTableDataChanged();	
		}catch( Exception e){
			JOptionPane.showInputDialog("Fehler bei Ticket Suche");
		}
	}

	// AbstractTable bietet automatisch folgende Funktionen

	public Kunde getCustomerAtRow(int row) {
		return customers.get(row);
	}

	public int getRowOfCustomer(Kunde c) {
		return customers.indexOf(c);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
