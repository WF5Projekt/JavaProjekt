package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import models.Kunde_Table;
import models.Ticket_Table;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Button;

@SuppressWarnings("serial")
public class Main_View extends JFrame{

	private JPanel contentPane;
	private JTabbedPane tabs;
	private JPanel panelKunden;
	private JPanel panelMitarbeiter;
	private JPanel ticketdetails;

	
	//Ticket-Tab
	private JButton btn_ticketRefresh;
	
	public JTable tickets;
	private JScrollPane TicketscrollPane;
	private JPanel panel_ticketdetails;
	private JPanel panelTickets;
	private JTabbedPane tabs_ticket;
	
	private JLabel _email_m;
	private JLabel _email_k;
	private JLabel _abteilung;
	private JLabel _vorname_k;
	private JLabel _nachname_k;
	private JLabel _vorname_m;
	private JLabel _nachname_m;
	private JLabel _telefon_m;
	
	private JLabel _priorität;
	private JLabel _kategorie;
	private JLabel _level;
	private JLabel _status;
	private JLabel _erstellzeitpunkt;
	private JLabel _beschreibung;
	private JLabel _telefon_k;
	
	
	private JButton btn_ticketNew;
	
	
	
	
	
	public Main_View() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Trouble Ticket System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabs.setForeground(new Color(0, 0, 0));
		tabs.setBackground(Color.LIGHT_GRAY);
		tabs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabs.setOpaque(true);
		contentPane.add(tabs, BorderLayout.CENTER);
		
		panelTickets = new JPanel();
		tabs.addTab("Ticketdaten", null, panelTickets, null);
		panelTickets.setLayout(new GridLayout(0, 1, 0, 0));
		
		tabs_ticket = new JTabbedPane(JTabbedPane.LEFT);
		tabs_ticket.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabs_ticket.setBackground(Color.GRAY);
		panelTickets.add(tabs_ticket);
		
		ticketdetails = new JPanel();
		tabs_ticket.addTab("Alle Tickets", null, ticketdetails, null);
		ticketdetails.setLayout(new BorderLayout(0, 0));
		
		TicketscrollPane = new JScrollPane();
		ticketdetails.add(TicketscrollPane, BorderLayout.CENTER);
		
		tickets = new JTable();
		TicketscrollPane.setViewportView(tickets);
		
		JPanel panel_buttons = new JPanel();
		ticketdetails.add(panel_buttons, BorderLayout.NORTH);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 1));
		
		btn_ticketRefresh = new JButton("Aktualisieren");
		
		panel_buttons.add(btn_ticketRefresh);
		
		btn_ticketNew = new JButton("Ticket er\u00F6ffnen");
		panel_buttons.add(btn_ticketNew);
		
		panel_ticketdetails = new JPanel();
		ticketdetails.add(panel_ticketdetails, BorderLayout.SOUTH);
		panel_ticketdetails.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel panelInfoErsteller = new JPanel();
		panelInfoErsteller.setBorder(new TitledBorder(null, "Ersteller", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelInfoTicket = new JPanel();
		panelInfoTicket.setBorder(new TitledBorder(null, "Ticketdetails", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelInfoMitarbeiter = new JPanel();
		panelInfoMitarbeiter.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Zust\u00E4ndiger Mitarbeiter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_11 = new JLabel("Email");
		JLabel label_13 = new JLabel("Name");
		JLabel label_14 = new JLabel("Telefon");
		JLabel lblAbteilung = new JLabel("Abteilung");
		

		_abteilung = new JLabel("-");
		
		
		
		_email_m = new JLabel("-");
		_email_m.setVerticalAlignment(SwingConstants.TOP);
		_email_m.setHorizontalAlignment(SwingConstants.LEFT);
		
		_vorname_m = new JLabel("-");
		_vorname_m.setVerticalAlignment(SwingConstants.TOP);
		_vorname_m.setHorizontalAlignment(SwingConstants.LEFT);
		
		_nachname_m = new JLabel("-");
		_nachname_m.setVerticalAlignment(SwingConstants.TOP);
		_nachname_m.setHorizontalAlignment(SwingConstants.LEFT);
		
		_telefon_m = new JLabel("-");
		_telefon_m.setVerticalAlignment(SwingConstants.TOP);
		_telefon_m.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		_abteilung.setVerticalAlignment(SwingConstants.TOP);
		_abteilung.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_panelInfoMitarbeiter = new GroupLayout(panelInfoMitarbeiter);
		gl_panelInfoMitarbeiter.setHorizontalGroup(
			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
							.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(29))
								.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
									.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
									.addComponent(_vorname_m, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(_nachname_m, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_panelInfoMitarbeiter.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(_email_m, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(_telefon_m, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))))
				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
					.addComponent(lblAbteilung, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_abteilung, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(46))
		);
		gl_panelInfoMitarbeiter.setVerticalGroup(
			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_13)
						.addComponent(_vorname_m)
						.addComponent(_nachname_m))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
						.addComponent(label_14)
						.addComponent(_telefon_m))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(_email_m))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAbteilung)
						.addComponent(_abteilung))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panelInfoMitarbeiter.setLayout(gl_panelInfoMitarbeiter);
		GroupLayout gl_panel_ticketdetails = new GroupLayout(panel_ticketdetails);
		gl_panel_ticketdetails.setHorizontalGroup(
			gl_panel_ticketdetails.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_ticketdetails.createSequentialGroup()
					.addComponent(panelInfoTicket, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInfoErsteller, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInfoMitarbeiter, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_ticketdetails.setVerticalGroup(
			gl_panel_ticketdetails.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelInfoErsteller, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
				.addComponent(panelInfoTicket, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
				.addComponent(panelInfoMitarbeiter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
		);
		
		JLabel lblTelefon = new JLabel("Telefon");
		
		JLabel lblName = new JLabel("Name");
		
		 _vorname_k = new JLabel("-");
		_vorname_k.setVerticalAlignment(SwingConstants.TOP);
		_vorname_k.setHorizontalAlignment(SwingConstants.LEFT);
		
		 _nachname_k = new JLabel("-");
		_nachname_k.setVerticalAlignment(SwingConstants.TOP);
		_nachname_k.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblEmail = new JLabel("Email");
		
		 _email_k = new JLabel("-");
		_email_k.setVerticalAlignment(SwingConstants.TOP);
		_email_k.setHorizontalAlignment(SwingConstants.LEFT);
		
		_telefon_k = new JLabel("-");
		_telefon_k.setVerticalAlignment(SwingConstants.TOP);
		_telefon_k.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_panelInfoErsteller = new GroupLayout(panelInfoErsteller);
		gl_panelInfoErsteller.setHorizontalGroup(
			gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoErsteller.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInfoErsteller.createSequentialGroup()
							.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelInfoErsteller.createSequentialGroup()
									.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(29))
								.addGroup(gl_panelInfoErsteller.createSequentialGroup()
									.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelInfoErsteller.createSequentialGroup()
									.addComponent(_vorname_k, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(_nachname_k, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
								.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_panelInfoErsteller.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(_email_k, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(_telefon_k, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_panelInfoErsteller.setVerticalGroup(
			gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoErsteller.createSequentialGroup()
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(_vorname_k)
						.addComponent(_nachname_k))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(_telefon_k))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(_email_k))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panelInfoErsteller.setLayout(gl_panelInfoErsteller);
		panelInfoTicket.setLayout(null);
		
		JLabel lblKundendaten = new JLabel("Beschreibung:");
		lblKundendaten.setBounds(8, 18, 68, 14);
		panelInfoTicket.add(lblKundendaten);
		
		_beschreibung = new JLabel("-");
		_beschreibung.setVerticalAlignment(SwingConstants.TOP);
		_beschreibung.setHorizontalAlignment(SwingConstants.LEFT);
		_beschreibung.setBounds(86, 18, 268, 43);
		panelInfoTicket.add(_beschreibung);
		
		 _status = new JLabel("-");
		_status.setVerticalAlignment(SwingConstants.TOP);
		_status.setHorizontalAlignment(SwingConstants.LEFT);
		_status.setBounds(86, 65, 87, 14);
		panelInfoTicket.add(_status);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(8, 65, 68, 14);
		panelInfoTicket.add(lblStatus);
		
		 _priorität = new JLabel("-");
		_priorität.setVerticalAlignment(SwingConstants.TOP);
		_priorität.setHorizontalAlignment(SwingConstants.LEFT);
		_priorität.setBounds(86, 87, 87, 14);
		panelInfoTicket.add(_priorität);
		
		JLabel lblPrioritt = new JLabel("Priorit\u00E4t");
		lblPrioritt.setBounds(8, 87, 68, 14);
		panelInfoTicket.add(lblPrioritt);
		
		 _kategorie = new JLabel("-");
		_kategorie.setVerticalAlignment(SwingConstants.TOP);
		_kategorie.setHorizontalAlignment(SwingConstants.LEFT);
		_kategorie.setBounds(86, 105, 87, 14);
		panelInfoTicket.add(_kategorie);
		
		JLabel lblKategorie = new JLabel("Kategorie");
		lblKategorie.setBounds(8, 105, 68, 14);
		panelInfoTicket.add(lblKategorie);
		
		JLabel lblErstellzeitpunkt = new JLabel("Erstellzeitpunkt");
		lblErstellzeitpunkt.setBounds(183, 87, 74, 14);
		panelInfoTicket.add(lblErstellzeitpunkt);
		
		 _erstellzeitpunkt = new JLabel("-");
		_erstellzeitpunkt.setVerticalAlignment(SwingConstants.TOP);
		_erstellzeitpunkt.setHorizontalAlignment(SwingConstants.LEFT);
		_erstellzeitpunkt.setBounds(267, 87, 87, 14);
		panelInfoTicket.add(_erstellzeitpunkt);
		
		JLabel lblLevek = new JLabel("Level");
		lblLevek.setBounds(183, 105, 74, 14);
		panelInfoTicket.add(lblLevek);
		
		 _level = new JLabel("-");
		_level.setVerticalAlignment(SwingConstants.TOP);
		_level.setHorizontalAlignment(SwingConstants.LEFT);
		_level.setBounds(267, 105, 87, 14);
		panelInfoTicket.add(_level);
		panel_ticketdetails.setLayout(gl_panel_ticketdetails);
		
		panelKunden = new JPanel();
		tabs.addTab("Kunden", null, panelKunden, null);
		
		panelMitarbeiter = new JPanel();
		tabs.addTab("Mitarbeiter", null, panelMitarbeiter, null);
		
		
		this.setLocationRelativeTo(null);
	}

	

	
	
	//Methoden um die Table-Models festzulegen
	public void setModel(Ticket_Table t)
	{
		tickets.setModel(t);
	}
	
	public void setModel(Kunde_Table t){
	//	customer.setModel(t);
	}
	
	//ActionListener für die Buttons
	public void addListenerButton_ticketRefresh(ActionListener a) {
		btn_ticketRefresh.addActionListener(a);
	}
	public void addListenerButton_ticketNew(ActionListener a){
		btn_ticketNew.addActionListener(a);
	}
	
	public int getSelectedTicket(){
		return tickets.getSelectedRow();
	}
	
	//Setter für die Ticketinfos
	public void setInfoBeschreibung(String s){
		this._beschreibung.setText(s);
	}
	public void setInfoStatus(String s){
		this._status.setText(s);
	}
	public void setInfoKategorie(String s){
		this._kategorie.setText(s);
	}
	public void setInfoPriorität(String s){
		this._priorität.setText(s);
	}
	public void setInfoLevel(String s){
		this._level.setText(s);
	}
	public void setInfoErstellzeitpunkt(String s){
		this._erstellzeitpunkt.setText(s);
	}
	public void setInfoEmail_K(String s){
		this._email_k.setText(s);
	}
	public void setInfoVorname_K(String s){
		this._vorname_k.setText(s);
	}
	public void setInfoNachname_K(String s){
		this._nachname_k.setText(s);
	}
	public void setInfoTelefon_K(String s){
		this._telefon_k.setText(s);
	}
	public void setInfoEmail_M(String s){
		this._email_m.setText(s);
	}
	public void setInfoVorname_M(String s){
		this._vorname_m.setText(s);
	}
	public void setInfoNachname_M(String s){
		this._nachname_m.setText(s);
	}
	public void setInfoTelefon_M(String s){
		this._telefon_m.setText(s);
	}
	public void setInfoAbteilung(String s){
		this._abteilung.setText(s);
	}

}
