package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		

		this.TicketTab.addListenerButton_Add(new addButtonListener());
		this.TicketTab.addListenerButton_Refresh(new refreshButtonListener());
		
		try{
			TicketTable.refreshData();
			
		} catch(Exception e){
			JOptionPane.showInputDialog("Fehler bei erstem Laden der Kunden-Daten");
		}
    }
	public Tab_View getTab(){
		return this.TicketTab;
	}
	
	class addButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(null, "Button hat noch keine Funktion", "Hinweis", JOptionPane.OK_CANCEL_OPTION);
		}

	}
	class refreshButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			TicketTable.refreshData();
		}
		
	}

	
	
}
