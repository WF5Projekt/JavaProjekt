package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Ticket_Table extends AbstractTableModel {

	private String[] columnNames = Ticket.getTableColumnNames();;

	
	private ArrayList<Ticket> tickets;
	private ArrayList<Ticket> backup;
	
	public void setList(ArrayList<Ticket> tickets){
		this.tickets = tickets;
		this.backup = tickets;
		fireTableDataChanged();
	}
	public void setSearch(ArrayList<Ticket> searchList){
		this.tickets = searchList;
		fireTableDataChanged();
	}
	public void Reset(){
		this.tickets = backup;
		fireTableDataChanged();
	}
	
	
	public ArrayList<Ticket> getList(){
		return this.backup;
	}
	
	public Ticket getTicketAtRow(int row) {
		return tickets.get(row);
	}

	public int getRowOfTicket(Ticket ticket) {
		return tickets.indexOf(ticket);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return tickets.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return tickets.get(row).getValue(col);
	}

}
