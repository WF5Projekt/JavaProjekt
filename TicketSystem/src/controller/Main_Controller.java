package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.*;
import views.Main_View;
import views.newTicket_View;

public class Main_Controller implements ListSelectionListener {

	private Main_View MainView;
	public newTicket_View TicketNeu;

	private Ticket_Table tickets;
	private Kunde_Table kunden;

	// Komboboxen
	public ComboBoxModelKategorie ComboBoxKategorie;
	public ComboBoxModelPriorität ComboBoxPriorität;
	public ComboBoxModelKunde ComboBoxKunde;
	private ArrayList<Kategorie> combo_kategorien;
	private ArrayList<Priorität> combo_prioritäten;
	private ArrayList<Kunde> combo_kunden;

	public Main_Controller() {

		this.MainView = new Main_View();
		this.tickets = new Ticket_Table();
		this.kunden = new Kunde_Table();

		// Initialisierung der Komboboxen
		this.ComboBoxKategorie = new ComboBoxModelKategorie();
		this.ComboBoxPriorität = new ComboBoxModelPriorität();
		this.ComboBoxKunde = new ComboBoxModelKunde();
		this.combo_kategorien = Kategorie.all();
		this.combo_prioritäten = Priorität.all();
		this.combo_kunden = Kunde.all();

		try {
			init();
			addListener();
			start();

		} catch (Exception e) {
			JOptionPane.showInputDialog("main");
		}

		this.MainView.setVisible(true);
	}

	public void start() {
		tickets.refreshData();
		kunden.refreshData();
	}

	// Alle Tabellen werden in der MainView verknüpft/festgelegt
	private void init() {
		this.MainView.setModel(tickets);
		// this.MainView.setModel(customer);
	}

	// Button-Listener werden festgelegt
	private void addListener() {
		// Buttons im Ticket-Tab
		MainView.addListenerButton_ticketRefresh(new ticketRefreshButtonListener());
		MainView.addListenerButton_ticketNew(new ticketNewButtonListener());

		// Tabellen-Listener
		MainView.tickets.getSelectionModel().addListSelectionListener(this);
	}

	//
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source == MainView.tickets.getSelectionModel()) {
			showTicketInfo();
		} /*
		 * else if (source == TableSales.getSelectionModel()) { int selectedRow
		 * = TableSales.getSelectedRow(); if (selectedRow != -1) { Sale sale =
		 * saleTableModel.getSaleAtRow(selectedRow);
		 * saleItemTableModel.refreshData(sale); } else {
		 * saleItemTableModel.clearData(); }
		 */
	}

	// Sub-Klassen für die Button-Listener
	class ticketRefreshButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.refreshData();
		}

	}

	class ticketNewButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			TicketNeu = new newTicket_View();
			// Button für neues Ticket anlegen
			TicketNeu.addListenerButton(new neuesTicketButton());
			TicketNeu.kat.setModel(ComboBoxKategorie);
			TicketNeu.prio.setModel(ComboBoxPriorität);
			TicketNeu.kunde.setModel(ComboBoxKunde);

			TicketNeu.setVisible(true);
		}

	}

	class neuesTicketButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selIndexKat = TicketNeu.kat.getSelectedIndex();
			int selIndexPrio = TicketNeu.prio.getSelectedIndex();
			int selIndexKunde = TicketNeu.kunde.getSelectedIndex();

			Kategorie selectedKategorie = combo_kategorien.get(selIndexKat);
			Priorität selectedPriorität = combo_prioritäten.get(selIndexPrio);
			Kunde selectedKunde = combo_kunden.get(selIndexKunde);

			Ticket tmpTicket = new Ticket(null, null, null, null);

		}
	}

	// Setzt die TicketInfo auf die Daten des aktuellen Ticket-Objekts aus der
	// Tabelle
	private void showTicketInfo() {
		int selectedRow = MainView.getSelectedTicket();
		if (selectedRow != -1) {
			Ticket tmpTicket = tickets.getTicketAtRow(selectedRow);
			// Set additional Info for selected Disc
			// if no info exists label is set to '-'
			try {

				MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim()
						.equals("")) ? tmpTicket.beschreibung : "-");
				MainView.setInfoStatus(!(tmpTicket.status.trim().equals("")) ? tmpTicket.status
						: "-");
				MainView.setInfoKategorie(!(tmpTicket.kategorie.trim()
						.equals("")) ? tmpTicket.kategorie : "-");
				MainView.setInfoLevel(!(tmpTicket.level.trim().equals("")) ? tmpTicket.level
						: "-");
				MainView.setInfoPriorität(!(tmpTicket.prioritaet.trim()
						.equals("")) ? tmpTicket.prioritaet : "-");
				MainView.setInfoErstellzeitpunkt(!(tmpTicket.erstellzeitpunkt
						.trim().equals("")) ? tmpTicket.erstellzeitpunkt : "-");

				MainView.setInfoEmail_K(!(tmpTicket.email_k.equals("")) ? tmpTicket.email_k
						: "-");
				MainView.setInfoNachname_K(!(tmpTicket.nachname_k.equals("")) ? tmpTicket.nachname_k
						: "-");
				MainView.setInfoVorname_K(!(tmpTicket.vorname_k.trim()
						.equals("")) ? tmpTicket.vorname_k : "-");
				MainView.setInfoTelefon_K(!(tmpTicket.telefon_k.equals("")) ? tmpTicket.telefon_k
						: "-");

				MainView.setInfoAbteilung(!(tmpTicket.abteilung.equals("")) ? tmpTicket.abteilung
						: "-");
				MainView.setInfoEmail_M(!(tmpTicket.email_m.equals("")) ? tmpTicket.email_m
						: "-");
				MainView.setInfoNachname_M(!(tmpTicket.nachname_m.trim()
						.equals("")) ? tmpTicket.nachname_m : "-");
				MainView.setInfoVorname_M(!(tmpTicket.vorname_m.trim()
						.equals("")) ? tmpTicket.vorname_m : "-");
				MainView.setInfoTelefon_M(!(tmpTicket.telefon_m.equals("")) ? tmpTicket.telefon_m
						: "-");

			} catch (Exception e) {
				JOptionPane.showInputDialog(tmpTicket.telefon_k);
			}

		}

	}

	// Kombobox modelle
	@SuppressWarnings("serial")
	class ComboBoxModelKategorie extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_kategorien.size();
		}

		@Override
		public Kategorie getElementAt(int index) {
			return combo_kategorien.get(index);
		}
	}

	@SuppressWarnings("serial")
	class ComboBoxModelPriorität extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_prioritäten.size();
		}

		@Override
		public Priorität getElementAt(int index) {
			return combo_prioritäten.get(index);
		}
	}

	@SuppressWarnings("serial")
	class ComboBoxModelKunde extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_kunden.size();
		}

		@Override
		public Kunde getElementAt(int index) {
			return combo_kunden.get(index);
		}
	}

}
