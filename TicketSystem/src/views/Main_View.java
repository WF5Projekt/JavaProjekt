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
import models.Mitarbeiter_Table;
import models.Ticket_Table;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Main_View extends JFrame {


	private JPanel contentPane;
	private JTabbedPane ticketView;
	private JPanel mitarbeiterView;
	private JPanel kundenView;

	//Ticket-Tab
	private JScrollPane TicketscrollPane;
	
	private JPanel panel_ticketdetails;

	private JLabel _email_m;
	private JLabel _email_k;
	private JLabel _abteilung;
	private JLabel _name_k;
	private JLabel _nachname_m;
	private JLabel _telefon_m;
	private JLabel _account_m;
	private JLabel _level_m;

	private JLabel _priorität;
	private JLabel _kategorie;
	private JLabel _level;
	private JLabel _status;
	private JLabel _erstellzeitpunkt;
	private JLabel _beschreibung;
	private JLabel _telefon_k;

	private JButton btn_ticketRefresh;
	private JButton btn_sucheTicket;
	private JButton btn_ticketNew;
	
	private JComboBox<String> combo_sucheTicket;
	private JTextField txt_sucheTicket;
	
	public JTable tickets;
	
	//Kunden-Tab
	private JPanel panel;
	private JPanel panel_KundenButtons;
	private JPanel panel_1;
	
	private JScrollPane KundenScrollPane;
	private JComboBox<String> combo_sucheKunde;

	private JTextField txt_sucheKunde;
	
	private JButton btn_sucheKunde;
	private JButton btn_kundeNew;
	private JButton btn_kundeRefresh;
	
	public JTable kunden;
	
	//Mitarbeiter-Tab
	private JPanel panel_MitarbeiterButtons;
	private JPanel panel_2;
	private JButton btn_mitarbeiterRefresh;
	private JButton btn_mitarbeiterNew;
	private JButton btn_sucheMitarbeiter;
	private JTextField txt_sucheMitarbeiter;
	private JComboBox<String> combo_sucheMitarbeiter;
	private JScrollPane MitarbeiterScrollPane;
	public JTable mitarbeiter;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton showTickets;
	private JButton btnKunden;
	private JButton btnMitarbeiter;
	private JPanel panel_5;
	private JLabel _erreichbarkeit;
	private JLabel lblErreichbar;

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
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBorder(UIManager.getBorder("MenuBar.border"));
		contentPane.add(panel_4, BorderLayout.NORTH);
		
		showTickets = new JButton("Tickets");
		showTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ticketView.setVisible(true);
				mitarbeiterView.setVisible(false);
				kundenView.setVisible(false);
				validate();
			}
		});
		panel_4.setLayout(new MigLayout("", "[65px][69px][][][][19px][85px][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[23px]"));
		panel_4.add(showTickets, "cell 0 0,alignx left,aligny top");
		
		btnKunden = new JButton("Kunden");
		btnKunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketView.setVisible(false);
				mitarbeiterView.setVisible(false);
				kundenView.setVisible(true);
				validate();
			}
		});
		panel_4.add(btnKunden, "cell 1 0,alignx left,aligny top");
		
		btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketView.setVisible(false);
				mitarbeiterView.setVisible(true);
				kundenView.setVisible(false);
				validate();
			}
		});
		panel_4.add(btnMitarbeiter, "cell 2 0,alignx left,aligny top");
		
		panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new CardLayout(0, 0));

		ticketView = new JTabbedPane(JTabbedPane.TOP);
		panel_5.add(ticketView, "name_463006202964198");
		ticketView.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		ticketView.setForeground(new Color(0, 0, 0));
		ticketView.setBackground(Color.LIGHT_GRAY);
		ticketView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ticketView.setOpaque(true);
		
				JPanel ticketdetails = new JPanel();
				ticketdetails.setVisible(false);
				ticketView.addTab("Alle Tickets", null, ticketdetails, null);
				ticketView.setEnabledAt(0, true);
				ticketdetails.setLayout(new BorderLayout(0, 0));
				
				
						JPanel panel_buttons = new JPanel();
						panel_buttons.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						ticketdetails.add(panel_buttons, BorderLayout.SOUTH);
						panel_buttons.setLayout(new BoxLayout(panel_buttons, BoxLayout.X_AXIS));
						
								btn_ticketRefresh = new JButton("Aktualisieren");
								
										panel_buttons.add(btn_ticketRefresh);
										
												btn_ticketNew = new JButton("Ticket er\u00F6ffnen");
												panel_buttons.add(btn_ticketNew);
												
														panel = new JPanel();
														FlowLayout flowLayout = (FlowLayout) panel.getLayout();
														flowLayout.setAlignment(FlowLayout.RIGHT);
														panel_buttons.add(panel);
														
																txt_sucheTicket = new JTextField();
																panel.add(txt_sucheTicket);
																txt_sucheTicket.setColumns(10);
																
																		combo_sucheTicket = new JComboBox<String>();
																		panel.add(combo_sucheTicket);
																		combo_sucheTicket.setModel(new DefaultComboBoxModel<String>(new String[] {
																				"Status", "Priorit\u00E4t", "Kategorie", "Level", "Kundenname",
																				"Mitarbeiter", "Ticket Beschreibung" }));
																		
																				btn_sucheTicket = new JButton("Suche");
																				panel.add(btn_sucheTicket);
																				
																						TicketscrollPane = new JScrollPane();
																						ticketdetails.add(TicketscrollPane, BorderLayout.NORTH);
																						
																						tickets = new JTable();
																						TicketscrollPane.setViewportView(tickets);
																						
																								panel_ticketdetails = new JPanel();
																								ticketdetails.add(panel_ticketdetails, BorderLayout.CENTER);
																								panel_ticketdetails.setBorder(new TitledBorder(UIManager
																										.getBorder("TitledBorder.border"), "", TitledBorder.LEFT,
																										TitledBorder.TOP, null, null));
																								panel_ticketdetails.setLayout(new GridLayout(0, 1, 0, 0));
																								
																										JPanel panelInfoTicket = new JPanel();
																										panelInfoTicket.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ticketdetails", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																										
																												JLabel lblKundendaten = new JLabel("Beschreibung:");
																												lblKundendaten.setHorizontalAlignment(SwingConstants.RIGHT);
																												
																														_beschreibung = new JLabel("-");
																														_beschreibung.setVerticalAlignment(SwingConstants.TOP);
																														_beschreibung.setHorizontalAlignment(SwingConstants.LEFT);
																														
																																_status = new JLabel("-");
																																_status.setVerticalAlignment(SwingConstants.TOP);
																																_status.setHorizontalAlignment(SwingConstants.LEFT);
																																
																																		JLabel lblStatus = new JLabel("Status:");
																																		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
																																		
																																				_priorität = new JLabel("-");
																																				_priorität.setVerticalAlignment(SwingConstants.TOP);
																																				_priorität.setHorizontalAlignment(SwingConstants.LEFT);
																																				
																																						JLabel lblPrioritt = new JLabel("Priorit\u00E4t:");
																																						lblPrioritt.setHorizontalAlignment(SwingConstants.RIGHT);
																																						
																																								_kategorie = new JLabel("-");
																																								_kategorie.setVerticalAlignment(SwingConstants.TOP);
																																								_kategorie.setHorizontalAlignment(SwingConstants.LEFT);
																																								
																																										JLabel lblKategorie = new JLabel("Kategorie");
																																										lblKategorie.setHorizontalAlignment(SwingConstants.RIGHT);
																																										
																																												JLabel lblErstellzeitpunkt = new JLabel("Erstellzeitpunkt:");
																																												lblErstellzeitpunkt.setHorizontalAlignment(SwingConstants.RIGHT);
																																												
																																														_erstellzeitpunkt = new JLabel("-");
																																														_erstellzeitpunkt.setVerticalAlignment(SwingConstants.TOP);
																																														_erstellzeitpunkt.setHorizontalAlignment(SwingConstants.LEFT);
																																														
																																																JLabel lblLevek = new JLabel("Level:");
																																																lblLevek.setHorizontalAlignment(SwingConstants.RIGHT);
																																																
																																																		_level = new JLabel("-");
																																																		_level.setVerticalAlignment(SwingConstants.TOP);
																																																		_level.setHorizontalAlignment(SwingConstants.LEFT);
																																																		panel_ticketdetails.add(panelInfoTicket);
																																																		GroupLayout gl_panelInfoTicket = new GroupLayout(panelInfoTicket);
																																																		gl_panelInfoTicket.setHorizontalGroup(
																																																			gl_panelInfoTicket.createParallelGroup(Alignment.TRAILING)
																																																				.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																					.addContainerGap()
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.TRAILING)
																																																						.addComponent(lblKundendaten)
																																																						.addComponent(lblErstellzeitpunkt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
																																																					.addGap(18)
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																						.addComponent(_erstellzeitpunkt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
																																																						.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																						.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																							.addGap(10)
																																																							.addComponent(lblKategorie, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
																																																						.addComponent(lblStatus, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
																																																						.addComponent(lblPrioritt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
																																																						.addComponent(lblLevek, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																						.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																							.addComponent(_kategorie, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
																																																							.addContainerGap())
																																																						.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																							.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																								.addComponent(_status, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
																																																								.addContainerGap())
																																																							.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																								.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																									.addComponent(_level, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
																																																									.addContainerGap())
																																																								.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																									.addComponent(_priorität, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
																																																									.addGap(501))))))
																																																		);
																																																		gl_panelInfoTicket.setVerticalGroup(
																																																			gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
																																																				.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.BASELINE)
																																																						.addComponent(lblStatus)
																																																						.addComponent(lblErstellzeitpunkt)
																																																						.addComponent(_erstellzeitpunkt)
																																																						.addComponent(_status))
																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.BASELINE)
																																																						.addComponent(lblKundendaten)
																																																						.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
																																																						.addGroup(gl_panelInfoTicket.createSequentialGroup()
																																																							.addComponent(lblPrioritt)
																																																							.addGap(5)
																																																							.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.BASELINE)
																																																								.addComponent(lblLevek)
																																																								.addComponent(_level))
																																																							.addGap(7)
																																																							.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.BASELINE)
																																																								.addComponent(lblKategorie)
																																																								.addComponent(_kategorie)))
																																																						.addComponent(_priorität))
																																																					.addGap(103))
																																																		);
																																																		panelInfoTicket.setLayout(gl_panelInfoTicket);
																																																		
																																																		panel_3 = new JPanel();
																																																		panel_ticketdetails.add(panel_3);
																																																		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
																																																		
																																																				JPanel panelInfoMitarbeiter = new JPanel();
																																																				panel_3.add(panelInfoMitarbeiter);
																																																				panelInfoMitarbeiter.setBorder(new TitledBorder(UIManager
																																																						.getBorder("TitledBorder.border"),
																																																						"Zust\u00E4ndiger Mitarbeiter", TitledBorder.LEADING,
																																																						TitledBorder.TOP, null, null));
																																																				
																																																						JLabel lblEmail_1 = new JLabel("Email:");
																																																						lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
																																																						JLabel lblName_1 = new JLabel("Name:");
																																																						lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
																																																						JLabel lblTelefon_1 = new JLabel("Telefon:");
																																																						lblTelefon_1.setHorizontalAlignment(SwingConstants.RIGHT);
																																																						JLabel lblAbteilung = new JLabel("Abteilung:");
																																																						lblAbteilung.setHorizontalAlignment(SwingConstants.RIGHT);
																																																						
																																																								_abteilung = new JLabel("-");
																																																								
																																																										_email_m = new JLabel("-");
																																																										_email_m.setVerticalAlignment(SwingConstants.TOP);
																																																										_email_m.setHorizontalAlignment(SwingConstants.LEFT);
																																																												
																																																														_nachname_m = new JLabel("-");
																																																														_nachname_m.setVerticalAlignment(SwingConstants.TOP);
																																																														_nachname_m.setHorizontalAlignment(SwingConstants.LEFT);
																																																														
																																																																_telefon_m = new JLabel("-");
																																																																_telefon_m.setVerticalAlignment(SwingConstants.TOP);
																																																																_telefon_m.setHorizontalAlignment(SwingConstants.LEFT);
																																																																
																																																																		_abteilung.setVerticalAlignment(SwingConstants.TOP);
																																																																		_abteilung.setHorizontalAlignment(SwingConstants.LEFT);
																																																																		
																																																																		JLabel lblHelpdesk = new JLabel("HelpDesk:");
																																																																		lblHelpdesk.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																		
																																																																		_level_m = new JLabel("-");
																																																																		_level_m.setVerticalAlignment(SwingConstants.TOP);
																																																																		_level_m.setHorizontalAlignment(SwingConstants.LEFT);
																																																																		
																																																																		JLabel lblUsername = new JLabel("Username:");
																																																																		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																		
																																																																		_account_m = new JLabel("-");
																																																																		_account_m.setVerticalAlignment(SwingConstants.TOP);
																																																																		_account_m.setHorizontalAlignment(SwingConstants.LEFT);
																																																																		GroupLayout gl_panelInfoMitarbeiter = new GroupLayout(
																																																																				panelInfoMitarbeiter);
																																																																		gl_panelInfoMitarbeiter.setHorizontalGroup(
																																																																			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																					.addGap(19)
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING)
																																																																						.addComponent(lblName_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
																																																																						.addComponent(lblTelefon_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																						.addComponent(lblEmail_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
																																																																					.addGap(6)
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING, false)
																																																																						.addComponent(_email_m, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																																						.addComponent(_telefon_m, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																																						.addComponent(_nachname_m, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
																																																																					.addGap(18)
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																						.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																							.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																								.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																									.addComponent(lblAbteilung, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																									.addGap(18)
																																																																									.addComponent(_abteilung, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
																																																																									.addGap(13))
																																																																								.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																									.addComponent(lblHelpdesk, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																									.addGap(18)
																																																																									.addComponent(_level_m, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
																																																																									.addPreferredGap(ComponentPlacement.RELATED)))
																																																																							.addGap(7))
																																																																						.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																							.addGap(18)
																																																																							.addComponent(_account_m, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
																																																																							.addContainerGap())))
																																																																		);
																																																																		gl_panelInfoMitarbeiter.setVerticalGroup(
																																																																			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
																																																																					.addContainerGap()
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING)
																																																																						.addComponent(lblName_1)
																																																																						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
																																																																							.addComponent(_nachname_m)
																																																																							.addComponent(lblAbteilung)
																																																																							.addComponent(_abteilung)))
																																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
																																																																							.addComponent(_telefon_m)
																																																																							.addComponent(lblTelefon_1))
																																																																						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
																																																																							.addComponent(_level_m)
																																																																							.addComponent(lblHelpdesk)))
																																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																																					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
																																																																						.addComponent(lblUsername)
																																																																						.addComponent(_account_m)
																																																																						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
																																																																							.addComponent(_email_m)
																																																																							.addComponent(lblEmail_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
																																																																		);
																																																																		panelInfoMitarbeiter.setLayout(gl_panelInfoMitarbeiter);
																																																																		
																																																																				JPanel panelInfoErsteller = new JPanel();
																																																																				panel_3.add(panelInfoErsteller);
																																																																				panelInfoErsteller.setBorder(new TitledBorder(null, "Ersteller",
																																																																						TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																																				
																																																																						JLabel lblTelefon = new JLabel("Telefon:");
																																																																						lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																						
																																																																								JLabel lblName = new JLabel("Name:");
																																																																								lblName.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																										
																																																																												_name_k = new JLabel("-");
																																																																												_name_k.setVerticalAlignment(SwingConstants.TOP);
																																																																												_name_k.setHorizontalAlignment(SwingConstants.LEFT);
																																																																												
																																																																														JLabel lblEmail = new JLabel("Email:");
																																																																														lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																														
																																																																																_email_k = new JLabel("-");
																																																																																_email_k.setVerticalAlignment(SwingConstants.TOP);
																																																																																_email_k.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																
																																																																																		_telefon_k = new JLabel("-");
																																																																																		_telefon_k.setVerticalAlignment(SwingConstants.TOP);
																																																																																		_telefon_k.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																		
																																																																																		_erreichbarkeit = new JLabel("-");
																																																																																		_erreichbarkeit.setVerticalAlignment(SwingConstants.TOP);
																																																																																		_erreichbarkeit.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																		
																																																																																		lblErreichbar = new JLabel("Erreichbar:");
																																																																																		lblErreichbar.setHorizontalAlignment(SwingConstants.RIGHT);
																																																																																		GroupLayout gl_panelInfoErsteller = new GroupLayout(panelInfoErsteller);
																																																																																		gl_panelInfoErsteller.setHorizontalGroup(
																																																																																			gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
																																																																																				.addGroup(gl_panelInfoErsteller.createSequentialGroup()
																																																																																					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
																																																																																					.addPreferredGap(ComponentPlacement.UNRELATED)
																																																																																					.addComponent(_name_k, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
																																																																																					.addGap(18)
																																																																																					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.TRAILING)
																																																																																						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																																						.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
																																																																																						.addComponent(lblErreichbar, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
																																																																																					.addPreferredGap(ComponentPlacement.UNRELATED)
																																																																																					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING, false)
																																																																																						.addComponent(_email_k, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																																																																						.addComponent(_telefon_k, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
																																																																																						.addComponent(_erreichbarkeit, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
																																																																																					.addContainerGap(104, Short.MAX_VALUE))
																																																																																		);
																																																																																		gl_panelInfoErsteller.setVerticalGroup(
																																																																																			gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
																																																																																				.addGroup(gl_panelInfoErsteller.createSequentialGroup()
																																																																																					.addContainerGap()
																																																																																					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
																																																																																						.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
																																																																																							.addComponent(lblTelefon)
																																																																																							.addComponent(_telefon_k))
																																																																																						.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.TRAILING)
																																																																																							.addComponent(_name_k)
																																																																																							.addComponent(lblName)))
																																																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																																																					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
																																																																																						.addComponent(_email_k)
																																																																																						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																																																																																					.addPreferredGap(ComponentPlacement.RELATED)
																																																																																					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
																																																																																						.addComponent(_erreichbarkeit)
																																																																																						.addComponent(lblErreichbar))
																																																																																					.addContainerGap(34, Short.MAX_VALUE))
																																																																																		);
																																																																																		panelInfoErsteller.setLayout(gl_panelInfoErsteller);
																																																																																				
																																																																																						mitarbeiterView = new JPanel();
																																																																																						panel_5.add(mitarbeiterView, "name_463006249781500");
																																																																																						mitarbeiterView.setLayout(new BorderLayout(0, 0));
																																																																																						
																																																																																						panel_MitarbeiterButtons = new JPanel();
																																																																																						panel_MitarbeiterButtons.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																																																						mitarbeiterView.add(panel_MitarbeiterButtons, BorderLayout.NORTH);
																																																																																						panel_MitarbeiterButtons.setLayout(new BoxLayout(panel_MitarbeiterButtons, BoxLayout.X_AXIS));
																																																																																						
																																																																																						btn_mitarbeiterRefresh = new JButton("Aktualisieren");
																																																																																						panel_MitarbeiterButtons.add(btn_mitarbeiterRefresh);
																																																																																						
																																																																																						btn_mitarbeiterNew = new JButton("Neuer Mitarbeiter");
																																																																																						panel_MitarbeiterButtons.add(btn_mitarbeiterNew);
																																																																																						
																																																																																						panel_2 = new JPanel();
																																																																																						panel_MitarbeiterButtons.add(panel_2);
																																																																																						panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
																																																																																						
																																																																																						txt_sucheMitarbeiter = new JTextField();
																																																																																						panel_2.add(txt_sucheMitarbeiter);
																																																																																						txt_sucheMitarbeiter.setColumns(10);
																																																																																						
																																																																																						combo_sucheMitarbeiter = new JComboBox<String>();
																																																																																						combo_sucheMitarbeiter.setModel(new DefaultComboBoxModel<String>(new String[] {"Name", "Abteilung", "Kontakt", "Standort", "Username"}));
																																																																																						panel_2.add(combo_sucheMitarbeiter);
																																																																																						
																																																																																						btn_sucheMitarbeiter = new JButton("Suchen");
																																																																																						panel_2.add(btn_sucheMitarbeiter);
																																																																																						
																																																																																						MitarbeiterScrollPane = new JScrollPane();
																																																																																						mitarbeiterView.add(MitarbeiterScrollPane, BorderLayout.CENTER);
																																																																																						
																																																																																						mitarbeiter = new JTable();
																																																																																						MitarbeiterScrollPane.setViewportView(mitarbeiter);
																																																																																		
																																																																																				kundenView = new JPanel();
																																																																																				panel_5.add(kundenView, "name_463006295653787");
																																																																																				kundenView.setLayout(new BorderLayout(0, 0));
																																																																																				
																																																																																						KundenScrollPane = new JScrollPane();
																																																																																						KundenScrollPane.setViewportView(kunden);
																																																																																						
																																																																																						kundenView.add(KundenScrollPane, BorderLayout.CENTER);
																																																																																						
																																																																																						kunden = new JTable();
																																																																																						KundenScrollPane.setViewportView(kunden);
																																																																																						
																																																																																								panel_KundenButtons = new JPanel();
																																																																																								panel_KundenButtons.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																																																								kundenView.add(panel_KundenButtons, BorderLayout.NORTH);
																																																																																								panel_KundenButtons.setLayout(new BoxLayout(panel_KundenButtons,
																																																																																										BoxLayout.X_AXIS));
																																																																																								
																																																																																										btn_kundeRefresh = new JButton("Aktualisieren");
																																																																																										panel_KundenButtons.add(btn_kundeRefresh);
																																																																																										
																																																																																												btn_kundeNew = new JButton("Neuer Kunde");
																																																																																												panel_KundenButtons.add(btn_kundeNew);
																																																																																												
																																																																																														panel_1 = new JPanel();
																																																																																														FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
																																																																																														flowLayout_1.setAlignment(FlowLayout.RIGHT);
																																																																																														panel_KundenButtons.add(panel_1);
																																																																																														
																																																																																																txt_sucheKunde = new JTextField();
																																																																																																panel_1.add(txt_sucheKunde);
																																																																																																txt_sucheKunde.setColumns(10);
																																																																																																
																																																																																																		combo_sucheKunde = new JComboBox<String>();
																																																																																																		combo_sucheKunde.setModel(new DefaultComboBoxModel<String>(new String[] {
																																																																																																				"Name", "Adresse", "Kontakt", "Username" }));
																																																																																																		panel_1.add(combo_sucheKunde);
																																																																																																		
																																																																																																				btn_sucheKunde = new JButton("Suchen");
																																																																																																				panel_1.add(btn_sucheKunde);

		this.setLocationRelativeTo(null);
	}


	/*
	 * ###################################
	 * MITARBEITER TAB
	 * ################################## 
	 * # Button-Listener 
	 * # Tabellen-Modell setter 
	 * # Suchfeld
	 * ###################################
	 */
	
	//############ Modell der Tabelle Mitarbeiter wird gesetzt
	public void setModel(Mitarbeiter_Table t){
		mitarbeiter.setModel(t);
	}
	
	//############ ActionListener für Mitarbeiter-Buttons

		public void addListenerMitarbeiterRefresh(ActionListener a){
			btn_mitarbeiterRefresh.addActionListener(a);
		}
		public void addListenerMitarbeiterNew(ActionListener a){
			btn_mitarbeiterNew.addActionListener(a);
		}
		public void addKeyListenerMitarbeiterSuche(KeyListener a){
			txt_sucheMitarbeiter.addKeyListener(a);
		}
		public void addListenerMitarbeiterSuche(ActionListener a){
			btn_sucheMitarbeiter.addActionListener(a);
		}
		
		
		//########### Suchfeld: Such-Text und die Such-Spalte wird an den Controller gegeben.
			public String getTextSucheMitarbeiter() {
				return this.txt_sucheMitarbeiter.getText();
			}
			public String getSpalteSucheMitarbeiter() {
				return this.combo_sucheMitarbeiter.getSelectedItem().toString();
			}
			public int getSelectedMitarbeiter() {
				return mitarbeiter.getSelectedRow();
			}
		

	
	/*
	 * ###################################
	 * KUNDEN TAB
	 * ################################## 
	 * # Button-Listener 
	 * # Tabellen-Modell setter 
	 * # Suchfeld
	 * ###################################
	 */

	//############ Modell der Tabelle Kunde wird gesetzt
	public void setModel(Kunde_Table t) {
		kunden.setModel(t);
	}
	
	//############ ActionListener für Kunden-Buttons

	public void addListenerKundeRefresh(ActionListener a){
		btn_kundeRefresh.addActionListener(a);
	}
	public void addListenerKundeNew(ActionListener a){
		btn_kundeNew.addActionListener(a);
	}
	public void addKeyListenerKundeSuche(KeyListener a){
		txt_sucheKunde.addKeyListener(a);
	}
	public void addListenerKundeSuche(ActionListener a){
		btn_sucheKunde.addActionListener(a);
	}
	
	
	//########### Suchfeld: Such-Text und die Such-Spalte wird an den Controller gegeben.
		public String getTextSucheKunde() {
			return this.txt_sucheKunde.getText();
		}
		public String getSpalteSucheKunde() {
			return this.combo_sucheKunde.getSelectedItem().toString();
		}
		public int getSelectedKunde() {
			return kunden.getSelectedRow();
		}
	
	
	/*
	 * ###################################
	 * TICKET TAB
	 * ################################## 
	 * # Button-Listener 
	 * # Tabellen-Modell setter 
	 * # Ticket-Info setter 
	 * # Suchfeld
	 * ###################################
	 */
		
	//########### Methoden um das Tabellen Modell festzulegen
	public void setModel(Ticket_Table t) {
		tickets.setModel(t);
	}


	//########### ActionListener für Ticket-Buttons
	public void addListenerTicketRefresh(ActionListener a) {
		btn_ticketRefresh.addActionListener(a);
	}

	public void addListenerTicketNew(ActionListener a) {
		btn_ticketNew.addActionListener(a);
	}

	public void addKeyListenerTicketSuche(KeyListener a) {
		txt_sucheTicket.addKeyListener(a);
	}

	public void addListenerTicketSuche(ActionListener a) {
		btn_sucheTicket.addActionListener(a);
	}
	

	//########### Suchfeld: Such-Text und die Such-Spalte wird an den Controller gegeben.
	public String getTextSucheTicket() {
		return this.txt_sucheTicket.getText();
	}
	public String getSpalteSucheTicket() {
		return this.combo_sucheTicket.getSelectedItem().toString();
	}
	public int getSelectedTicket() {
		return tickets.getSelectedRow();
	}

	
	//############# Setter für die Ticketinfos
	public void setInfoBeschreibung(String s) {
		this._beschreibung.setText(s);
	}

	public void setInfoStatus(String s) {
		this._status.setText(s);
	}

	public void setInfoKategorie(String s) {
		this._kategorie.setText(s);
	}

	public void setInfoPriorität(String s) {
		this._priorität.setText(s);
	}

	public void setInfoLevel(String s) {
		this._level.setText(s);
	}

	public void setInfoErstellzeitpunkt(String s) {
		this._erstellzeitpunkt.setText(s);
	}

	public void setInfoEmail_K(String s) {
		this._email_k.setText(s);
	}

	public void setInfoName_K(String s) {
		this._name_k.setText(s);
	}

	public void setInfoTelefon_K(String s) {
		this._telefon_k.setText(s);
	}

	public void setInfoEmail_M(String s) {
		this._email_m.setText(s);
	}

	public void setInfoName_M(String s) {
		this._nachname_m.setText(s);
	}

	public void setInfoTelefon_M(String s) {
		this._telefon_m.setText(s);
	}

	public void setInfoAbteilung(String s) {
		this._abteilung.setText(s);
	}
	public void setInfoAccount_M(String s){
		this._account_m.setText(s);
	}
	public void setInfoHelpdesk(String s){
		this._level_m.setText(s);
	}
	public void setInfoErreichbarkeit(String s){
		this._erreichbarkeit.setText(s);
	}
}
