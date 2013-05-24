package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Kunde_Table extends AbstractTableModel {

	
	private String[] columnNames = Kunde.getColumnNames();
	private ArrayList<Kunde> kunden;
	private ArrayList<Kunde> backup;
	
	public ArrayList<Kunde> getArray(){
		return this.kunden;
	}
	
	public void setList(ArrayList<Kunde> kunden){
		this.kunden = kunden;
		this.backup = kunden;
		fireTableDataChanged();
	}
	public void setSearch(ArrayList<Kunde> searchList){
		this.kunden = searchList;
		fireTableDataChanged();
	}
	public void Reset(){
		this.kunden = backup;
		fireTableDataChanged();
	}
	
	public ArrayList<Kunde> getList(){
		return this.backup;
	}
	
	
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
		return kunden.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return kunden.get(row).getValue(col);
	}

}
