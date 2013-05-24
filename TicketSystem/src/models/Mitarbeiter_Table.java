package models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Mitarbeiter_Table extends AbstractTableModel{
	
	private String[] columnNames;

	
	private Object[][] data = {};
	private ArrayList<Mitarbeiter> inhalt;

	public ArrayList<Mitarbeiter> getArray(){
		return this.inhalt;
	}
	
	// Refresh der Daten für die Tabelle
		public void refreshData() {
			try {
				columnNames = Mitarbeiter.getColumnNames();
				inhalt = Mitarbeiter.all();
				data = new Object[inhalt.size()][];
				for (int i = 0; i < inhalt.size(); i++) {
					Mitarbeiter tmp = inhalt.get(i);
					data[i] = tmp.toJTableArray();
				}
				this.fireTableDataChanged();
			} catch (Exception e) {
				JOptionPane.showInputDialog("Fehler in Refresh_Data Mitarbeiter");
			}
		}
		
		public void searchData(String spalte, String suche){
			try{
				inhalt = Mitarbeiter.search(spalte, suche);
				data = new Object[inhalt.size()][];
				for (int i = 0; i < inhalt.size(); i++) {
					Mitarbeiter tmp = inhalt.get(i);
					data[i] = tmp.toJTableArray();
				}
				this.fireTableDataChanged();	
			}catch( Exception e){
				JOptionPane.showInputDialog("Fehler bei Ticket Suche");
			}
		}
		
		public Mitarbeiter getMitarbeiterWithID(String idMitarbeiter){
			
			
			int index = -1;

		    for (int i = 0; (i < inhalt.size()) && (index == -1); i++) {
		        if (inhalt.get(i).idMitarbeiter.equals(idMitarbeiter)) {
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
		
		// AbstractTable bietet automatisch folgende Funktionen

		public Mitarbeiter getEmployeeAtRow(int row) {
			return inhalt.get(row);
		}

		public int getRowOfEmployee(Mitarbeiter c) {
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

}
