package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Ticket_Table extends AbstractTableModel {

	
	private String[] columnNames;
	private String art;

	private ArrayList<Ticket> tickets;
	private ArrayList<Ticket> backup;

	public Ticket_Table(String art){
		if(art.equals("Tickets"))
			columnNames = Ticket.getColumnNames();
		if(art.equals("FAQ")){
			columnNames = Ticket.getFAQColumnNames();
		}
		if(art.equals("Gelöst"))
			columnNames = Ticket.getGelöstColumnNames();
		this.art = art;
	}
	
	public void setList(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
		this.backup = tickets;
		fireTableDataChanged();
	}
	
	public void reset(){
		this.tickets = backup;
		fireTableDataChanged();
	}

	public ArrayList<Ticket> getList() {
		return this.backup;
	}

	public void searchTicket(String spalte, String suche) {

		suche = suche.trim().toUpperCase();
		
		if (!(suche.equals("") || spalte.equals(""))) {
			
			ArrayList<Ticket> searchList = new ArrayList<Ticket>();
			
			for (Ticket t : backup) {
				switch (spalte) {
				case "ID":
					if (t.idTicket.toUpperCase().matches(
							"(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				case "Beschreibung":
					if (t.beschreibung.toUpperCase().matches(
							"(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				case "Level":
					if (t.level.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				case "Kategorie":
					if (t.kategorie.toUpperCase().matches(
							"(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				case "Priorität":
					if (t.prioritaet.toUpperCase().matches(
							"(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				case "Status":
					if (t.status.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(t);
					break;
				}
			}

			this.tickets = searchList;
		} else
		{
			reset();
		}
		fireTableDataChanged();
	}
	
	public Ticket getTicketWithID(String idTicket){
		Ticket tmpTicket = null;
		for(Ticket t : tickets)
			if(t.idTicket.matches(idTicket.trim()))
				tmpTicket = t;
		return tmpTicket;
	}

	public void getFertigeTickets() {
	ArrayList<Ticket> searchList = new ArrayList<Ticket>();
		
		for (Ticket t : backup) {
		
				if (t.idStatus.matches("4") && t.idMitarbeiter == null)
					searchList.add(t);
		
		}
		this.tickets = searchList;
		
		fireTableDataChanged();
	
	}
	
	public void getNeueTickets(){
		
		ArrayList<Ticket> searchList = new ArrayList<Ticket>();
		
		for (Ticket t : backup) {
		
				if (t.idStatus.matches("1") && t.idMitarbeiter == null)
					searchList.add(t);
		
		}
		this.tickets = searchList;
		
		fireTableDataChanged();
	}
	public void getMeineTickets(Mitarbeiter user){
		ArrayList<Ticket> searchList = new ArrayList<Ticket>();
		
		for (Ticket t : backup) {
		
				if (t.idMitarbeiter != null && t.idMitarbeiter.matches(user.idMitarbeiter))
					searchList.add(t);
		
		}
		this.tickets = searchList;
		
		fireTableDataChanged();
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
		
		if(art.equals("Tickets"))
			return tickets.get(row).getValue(col);
		else if(art.equals("FAQ"))
			return tickets.get(row).getFAQValue(col);
		else
			return tickets.get(row).getGelöstValue(col);
	}


}
