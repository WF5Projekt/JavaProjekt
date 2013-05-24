package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Kunde_Table extends AbstractTableModel {

	
	
	
	private String[] columnNames;
	private Object[][] data = {};
	private ArrayList<Kunde> inhalt;
	
	public ArrayList<Kunde> getArray(){
		return this.inhalt;
	}
	
	// Refresh der Daten für die Tabelle
	public void refreshData() {
		try {
			columnNames = Kunde.getColumnNames();
			inhalt = Kunde.all();
			data = new Object[inhalt.size()][];
			for (int i = 0; i < inhalt.size(); i++) {
				Kunde tmp = inhalt.get(i);
				data[i] = tmp.toJTableArray();
			}
			this.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showInputDialog("Fehler in Kunden_Table");
		}
	}
	
	public void searchData(String spalte, String suche){
		try{
			inhalt = Kunde.search(spalte, suche);
			data = new Object[inhalt.size()][];
			for (int i = 0; i < inhalt.size(); i++) {
				Kunde tmp = inhalt.get(i);
				data[i] = tmp.toJTableArray();
			}
			this.fireTableDataChanged();	
		}catch( Exception e){
			JOptionPane.showInputDialog("Fehler bei Ticket Suche");
		}
	}

	// AbstractTable bietet automatisch folgende Funktionen

	public Kunde getKundeAtRow(int row) {
		return inhalt.get(row);
	}

	public int getRowOfKunde(Kunde c) {
		return inhalt.indexOf(c);
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

	    for (int i = 0; (i < inhalt.size()) && (index == -1); i++) {
	        if (inhalt.get(i).idKunde.equals(idKunde)) {
	            index = i;
	        }
	    }
	    
	    if(index == -1){
	    	return null;
	    }
	    else{
	    	return inhalt.get(index);
	    }
		
	}

}
