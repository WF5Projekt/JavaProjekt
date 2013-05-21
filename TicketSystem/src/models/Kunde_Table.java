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
	private ArrayList<Kunde> kunden;

	// Refresh der Daten für die Tabelle
	public void refreshData() {
		try {
			kunden = Kunde.all();
			data = new Object[kunden.size()][];
			for (int i = 0; i < kunden.size(); i++) {
				Kunde tmp = kunden.get(i);
				data[i] = tmp.toJTableArray();
			}
			this.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showInputDialog("Fehler in Kunden_Table");
		}
	}
	
	public void searchData(String spalte, String suche){
		try{
			kunden = Kunde.search(spalte, suche);
			data = new Object[kunden.size()][];
			for (int i = 0; i < kunden.size(); i++) {
				Kunde tmp = kunden.get(i);
				data[i] = tmp.toJTableArray();
			}
			this.fireTableDataChanged();	
		}catch( Exception e){
			JOptionPane.showInputDialog("Fehler bei Ticket Suche");
		}
	}

	// AbstractTable bietet automatisch folgende Funktionen

	public Kunde getKundeAtRow(int row) {
		return kunden.get(row);
	}

	public int getRowOfKunde(Kunde c) {
		return kunden.indexOf(c);
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

	public Kunde getKundeWithID(String idKunde) {
		int index = -1;

	    for (int i = 0; (i < kunden.size()) && (index == -1); i++) {
	        if (kunden.get(i).idKunde.equals(idKunde)) {
	            index = i;
	        }
	    }
	    
	    if(index == -1){
	    	return null;
	    }
	    else{
	    	return kunden.get(index);
	    }
		
	}

}
