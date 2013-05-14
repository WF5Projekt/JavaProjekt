package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.*;

import views.Main_View;
import views.newTicket_View;

public class Main_Controller implements ListSelectionListener {

	private Main_View MainView;
	private Ticket_Table tickets;
	

	public Main_Controller() {
		
		this.MainView = new Main_View();
		
		this.tickets = new Ticket_Table();
		
		try {
			init();
			addListener();
			start();

		} catch (Exception e) {
			JOptionPane.showInputDialog("main");
		}
		
		this.MainView.setVisible(true);
	}
	
	
	
	
	public void start(){
		tickets.refreshData();
	}
	
	//Alle Tabellen werden in der MainView verknüpft/festgelegt
	private void init(){
		this.MainView.setModel(tickets);
	}
	
	//Button-Listener werden festgelegt
	private void addListener(){
		MainView.addListenerButton_ticketRefresh(new ticketRefreshButtonListener());
		MainView.addListenerButton_ticketNew(new ticketNewButtonListener());
		
		
		//Tabellen-Listener
		MainView.tickets.getSelectionModel().addListSelectionListener(this);
	}

	

	
	//Sub-Klassen für die Button-Listener
	class ticketRefreshButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
				tickets.refreshData();
		}

	}
	class ticketNewButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			new newTicket_View().setVisible(true);
		}
		
	}
	
	//Setzt die TicketInfo auf die Daten des aktuellen Ticket-Objekts aus der Tabelle
	private void showTicketInfo() {
        int selectedRow = MainView.getSelectedTicket();
        if (selectedRow != -1) {
            Ticket tmpTicket = tickets.getTicketAtRow(selectedRow);
            // Set additional Info for selected Disc
            // if no info exists label is set to '-'
            try{
            	
            
            MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim().equals("")) ? tmpTicket.beschreibung : "-");
            MainView.setInfoStatus(!(tmpTicket.status.trim().equals("")) ? tmpTicket.status : "-");
            MainView.setInfoKategorie(!(tmpTicket.kategorie.trim().equals("")) ? tmpTicket.kategorie : "-");
            MainView.setInfoLevel(!(tmpTicket.level.trim().equals("")) ? tmpTicket.level : "-");
            MainView.setInfoPriorität(!(tmpTicket.prioritaet.trim().equals("")) ? tmpTicket.prioritaet : "-");
            MainView.setInfoErstellzeitpunkt(!(tmpTicket.erstellzeitpunkt.trim().equals("")) ? tmpTicket.erstellzeitpunkt : "-");
            
            MainView.setInfoEmail_K(!(tmpTicket.email_k.equals("")) ? tmpTicket.email_k : "-");
            MainView.setInfoNachname_K(!(tmpTicket.nachname_k.equals("")) ? tmpTicket.nachname_k : "-");
            MainView.setInfoVorname_K(!(tmpTicket.vorname_k.trim().equals("")) ? tmpTicket.vorname_k : "-");
            MainView.setInfoTelefon_K(!(tmpTicket.telefon_k.equals("")) ? tmpTicket.telefon_k : "-");
            
            
            MainView.setInfoAbteilung(!(tmpTicket.abteilung.equals("")) ? tmpTicket.abteilung : "-");
            MainView.setInfoEmail_M(!(tmpTicket.email_m.equals("")) ? tmpTicket.email_m : "-");
            MainView.setInfoNachname_M(!(tmpTicket.nachname_m.trim().equals("")) ? tmpTicket.nachname_m : "-");
            MainView.setInfoVorname_M(!(tmpTicket.vorname_m.trim().equals("")) ? tmpTicket.vorname_m : "-");
            MainView.setInfoTelefon_M(!(tmpTicket.telefon_m.equals("")) ? tmpTicket.telefon_m : "-");
            
            }catch (Exception e) {
    			JOptionPane.showInputDialog(tmpTicket.telefon_k);
    		}
    		
        }

	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
        if (source == MainView.tickets.getSelectionModel()) {
            showTicketInfo();
        } /*else if (source == TableSales.getSelectionModel()) {
            int selectedRow = TableSales.getSelectedRow();
            if (selectedRow != -1) {
                Sale sale = saleTableModel.getSaleAtRow(selectedRow);
                saleItemTableModel.refreshData(sale);
            } else {
                saleItemTableModel.clearData();
            }*/
	}
}
