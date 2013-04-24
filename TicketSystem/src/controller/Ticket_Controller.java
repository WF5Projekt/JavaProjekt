package controller;

import javax.swing.JOptionPane;

import views.Tab_View;
import models.Ticket_Table;


public class Ticket_Controller {

	private Ticket_Table TicketTable;
	private Tab_View TicketTab;
	
	
	public Ticket_Controller(){
		
		TicketTable = new Ticket_Table();
		TicketTab = new Tab_View("Tickets");
		
		TicketTab.setModel(TicketTable);
		
		try{
			TicketTable.refreshData();
			
		} catch(Exception e){
			JOptionPane.showInputDialog("Fehler bei erstem Laden der Kunden-Daten");
		}
    }
	public Tab_View getTab(){
		return this.TicketTab;
	}
	
	
}
