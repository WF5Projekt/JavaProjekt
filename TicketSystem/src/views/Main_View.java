package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import models.Kunde_Table;
import models.Mitarbeiter_Table;
import models.Ticket_Table;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Main_View extends JFrame {


	private JPanel contentPane;
	private JPanel mitarbeiterView;
	private JPanel kundenView;
	private JPanel ticketView;

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
	private JButton btn_AllTickets;
	private JButton btn_NeueTickets;
	private JButton btn_MeineTickets;
	private JButton btn_GeschlosseneTickets;
	private JButton btn_FAQTickets;
	
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
	private JPanel panel_Fußleiste;
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
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnBearbeiten;
	private JPanel panel_12;
	private JPanel panel_13;

	public Main_View() {
		setType(Type.POPUP);
		setResizable(false);
		setBackground(new Color(245, 245, 245));

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
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBorder(UIManager.getBorder("MenuBar.border"));
		panel_4.setBackground(new Color(245, 245, 245));
		contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_6);
		
		showTickets = new JButton("Tickets");
		showTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/connect.png")));
		showTickets.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(showTickets);
		
		btnKunden = new JButton("Kunden");
		btnKunden.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/users.png")));
		btnKunden.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnKunden);
		
		btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/user-male-alt-3.png")));
		btnMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnMitarbeiter);
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketView.setVisible(false);
				mitarbeiterView.setVisible(true);
				kundenView.setVisible(false);
				validate();
			}
		});
		btnKunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketView.setVisible(false);
				mitarbeiterView.setVisible(false);
				kundenView.setVisible(true);
				validate();
			}
		});
		showTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ticketView.setVisible(true);
				mitarbeiterView.setVisible(false);
				kundenView.setVisible(false);
				validate();
			}
		});
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(245, 245, 245));
		panel_4.add(panel_8);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_4.add(panel_7);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 245, 245));
		contentPane.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new CardLayout(0, 0));
		
				ticketView = new JPanel();
				panel_5.add(ticketView, "name_581222764885545");
				ticketView.setBackground(new Color(245, 245, 245));
				ticketView.setVisible(false);
				ticketView.setLayout(new BorderLayout(0, 0));
						
						panel_10 = new JPanel();
						panel_10.setBorder(new EmptyBorder(2, 1, 0, 2));
						ticketView.add(panel_10, BorderLayout.WEST);
						GridBagLayout gbl_panel_10 = new GridBagLayout();
						gbl_panel_10.columnWidths = new int[]{0, 0};
						gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
						gbl_panel_10.columnWeights = new double[]{0.0, Double.MIN_VALUE};
						gbl_panel_10.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
						panel_10.setLayout(gbl_panel_10);
												
														btn_ticketRefresh = new JButton("Aktualisieren");
														btn_ticketRefresh.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
														btn_ticketRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
														GridBagConstraints gbc_btn_ticketRefresh = new GridBagConstraints();
														gbc_btn_ticketRefresh.anchor = GridBagConstraints.NORTH;
														gbc_btn_ticketRefresh.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_ticketRefresh.insets = new Insets(0, 0, 5, 0);
														gbc_btn_ticketRefresh.gridx = 0;
														gbc_btn_ticketRefresh.gridy = 0;
														panel_10.add(btn_ticketRefresh, gbc_btn_ticketRefresh);
														
																btn_ticketNew = new JButton("Neues Ticket");
																btn_ticketNew.setHorizontalAlignment(SwingConstants.LEFT);
																btn_ticketNew.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/add.png")));
																btn_ticketNew.setFont(new Font("Tahoma", Font.BOLD, 12));
																GridBagConstraints gbc_btn_ticketNew = new GridBagConstraints();
																gbc_btn_ticketNew.fill = GridBagConstraints.HORIZONTAL;
																gbc_btn_ticketNew.insets = new Insets(0, 0, 5, 0);
																gbc_btn_ticketNew.gridx = 0;
																gbc_btn_ticketNew.gridy = 1;
																panel_10.add(btn_ticketNew, gbc_btn_ticketNew);
														
														btnBearbeiten = new JButton("Bearbeiten");
														btnBearbeiten.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/edit.png")));
														btnBearbeiten.setHorizontalAlignment(SwingConstants.LEFT);
														btnBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btnBearbeiten = new GridBagConstraints();
														gbc_btnBearbeiten.fill = GridBagConstraints.HORIZONTAL;
														gbc_btnBearbeiten.insets = new Insets(0, 0, 5, 0);
														gbc_btnBearbeiten.gridx = 0;
														gbc_btnBearbeiten.gridy = 2;
														panel_10.add(btnBearbeiten, gbc_btnBearbeiten);
														
														panel_11 = new JPanel();
														GridBagConstraints gbc_panel_11 = new GridBagConstraints();
														gbc_panel_11.insets = new Insets(0, 0, 5, 0);
														gbc_panel_11.gridx = 0;
														gbc_panel_11.gridy = 3;
														panel_10.add(panel_11, gbc_panel_11);
														panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
														
														btn_AllTickets = new JButton("Alle Tickets");
														btn_AllTickets.setHorizontalAlignment(SwingConstants.LEFT);
														btn_AllTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/list.png")));
														btn_AllTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btn_AllTickets = new GridBagConstraints();
														gbc_btn_AllTickets.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_AllTickets.insets = new Insets(0, 0, 5, 0);
														gbc_btn_AllTickets.gridx = 0;
														gbc_btn_AllTickets.gridy = 4;
														panel_10.add(btn_AllTickets, gbc_btn_AllTickets);
														
														btn_NeueTickets = new JButton("Neue Tickets");
														btn_NeueTickets.setHorizontalAlignment(SwingConstants.LEFT);
														btn_NeueTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/connect.png")));
														btn_NeueTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btn_NeueTickets = new GridBagConstraints();
														gbc_btn_NeueTickets.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_NeueTickets.insets = new Insets(0, 0, 5, 0);
														gbc_btn_NeueTickets.gridx = 0;
														gbc_btn_NeueTickets.gridy = 5;
														panel_10.add(btn_NeueTickets, gbc_btn_NeueTickets);
														
														btn_MeineTickets = new JButton("Meine Tickets");
														btn_MeineTickets.setHorizontalAlignment(SwingConstants.LEFT);
														btn_MeineTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/user-male.png")));
														btn_MeineTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btn_MeineTickets = new GridBagConstraints();
														gbc_btn_MeineTickets.insets = new Insets(0, 0, 5, 0);
														gbc_btn_MeineTickets.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_MeineTickets.gridx = 0;
														gbc_btn_MeineTickets.gridy = 6;
														panel_10.add(btn_MeineTickets, gbc_btn_MeineTickets);
														
														btn_GeschlosseneTickets = new JButton("Gel\u00F6ste Tickets");
														btn_GeschlosseneTickets.setHorizontalAlignment(SwingConstants.LEFT);
														btn_GeschlosseneTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/check.png")));
														btn_GeschlosseneTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btn_GeschlosseneTickets = new GridBagConstraints();
														gbc_btn_GeschlosseneTickets.insets = new Insets(0, 0, 5, 0);
														gbc_btn_GeschlosseneTickets.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_GeschlosseneTickets.gridx = 0;
														gbc_btn_GeschlosseneTickets.gridy = 7;
														panel_10.add(btn_GeschlosseneTickets, gbc_btn_GeschlosseneTickets);
														
														btn_FAQTickets = new JButton("FAQ");
														btn_FAQTickets.setHorizontalAlignment(SwingConstants.LEFT);
														btn_FAQTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/help.png")));
														btn_FAQTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
														GridBagConstraints gbc_btn_FAQTickets = new GridBagConstraints();
														gbc_btn_FAQTickets.insets = new Insets(0, 0, 5, 0);
														gbc_btn_FAQTickets.fill = GridBagConstraints.HORIZONTAL;
														gbc_btn_FAQTickets.gridx = 0;
														gbc_btn_FAQTickets.gridy = 8;
														panel_10.add(btn_FAQTickets, gbc_btn_FAQTickets);
						
						panel_9 = new JPanel();
						ticketView.add(panel_9, BorderLayout.CENTER);
																						panel_9.setLayout(new BorderLayout(0, 0));
																				
																						TicketscrollPane = new JScrollPane();
																						panel_9.add(TicketscrollPane, BorderLayout.CENTER);
																						TicketscrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
																						TicketscrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
																						
																						tickets = new JTable();
																						tickets.setFont(new Font("Calibri", Font.BOLD, 15));
																						tickets.setFillsViewportHeight(true);
																						tickets.setBackground(new Color(240, 248, 255));
																						
																								panel_ticketdetails = new JPanel();
																								panel_9.add(panel_ticketdetails, BorderLayout.SOUTH);
																								panel_ticketdetails.setBackground(new Color(245, 245, 245));
																								panel_ticketdetails.setBorder(null);
																								panel_ticketdetails.setLayout(new BorderLayout(0, 0));
																								
																										JPanel panelInfoTicket = new JPanel();
																										panelInfoTicket.setBackground(new Color(245, 245, 245));
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
																																																		panel_ticketdetails.add(panelInfoTicket, BorderLayout.CENTER);
																																																		panelInfoTicket.setLayout(new MigLayout("", "[82px][395px][82px][131px]", "[14px][14px][5px][14px][7px][35px]"));
																																																		panelInfoTicket.add(lblKundendaten, "cell 0 1,alignx right,aligny top");
																																																		panelInfoTicket.add(lblErstellzeitpunkt, "cell 0 0,growx,aligny top");
																																																		panelInfoTicket.add(_erstellzeitpunkt, "cell 1 0,alignx left,aligny top");
																																																		panelInfoTicket.add(_beschreibung, "cell 1 1 1 5,grow");
																																																		panelInfoTicket.add(lblKategorie, "cell 2 5,growx,aligny top");
																																																		panelInfoTicket.add(lblStatus, "cell 2 0,growx,aligny top");
																																																		panelInfoTicket.add(lblPrioritt, "cell 2 1,alignx right,aligny top");
																																																		panelInfoTicket.add(lblLevek, "cell 2 3,growx,aligny top");
																																																		panelInfoTicket.add(_kategorie, "cell 3 5,growx,aligny top");
																																																		panelInfoTicket.add(_status, "cell 3 0,growx,aligny top");
																																																		panelInfoTicket.add(_level, "cell 3 3,growx,aligny top");
																																																		panelInfoTicket.add(_priorität, "cell 3 1,growx,aligny top");
																																																		
																																																		panel_3 = new JPanel();
																																																		panel_3.setBackground(new Color(245, 245, 245));
																																																		panel_ticketdetails.add(panel_3, BorderLayout.SOUTH);
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
																																																																		panelInfoErsteller.setAlignmentY(Component.BOTTOM_ALIGNMENT);
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
																																																																														
																																																																														
																																																																																JPanel panel_buttons = new JPanel();
																																																																																panel_buttons.setBorder(new EmptyBorder(0, 1, 0, 0));
																																																																																ticketView.add(panel_buttons, BorderLayout.SOUTH);
																																																																																panel_buttons.setLayout(new BoxLayout(panel_buttons, BoxLayout.X_AXIS));
																																																																																						
																																																																																								panel = new JPanel();
																																																																																								panel.setBorder(null);
																																																																																								FlowLayout flowLayout = (FlowLayout) panel.getLayout();
																																																																																								flowLayout.setAlignment(FlowLayout.LEFT);
																																																																																								panel_buttons.add(panel);
																																																																																										
																																																																																												btn_sucheTicket = new JButton("Suche");
																																																																																												btn_sucheTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																												btn_sucheTicket.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/search.png")));
																																																																																												panel.add(btn_sucheTicket);
																																																																																										
																																																																																												combo_sucheTicket = new JComboBox<String>();
																																																																																												combo_sucheTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																												combo_sucheTicket.setMaximumRowCount(10);
																																																																																												panel.add(combo_sucheTicket);
																																																																																												
																																																																																														txt_sucheTicket = new JTextField();
																																																																																														txt_sucheTicket.setBackground(SystemColor.text);
																																																																																														txt_sucheTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
																																																																																														panel.add(txt_sucheTicket);
																																																																																														txt_sucheTicket.setColumns(10);
																																																																																				
																																																																																						mitarbeiterView = new JPanel();
																																																																																						mitarbeiterView.setBackground(new Color(245, 245, 245));
																																																																																						panel_5.add(mitarbeiterView, "name_463006249781500");
																																																																																						mitarbeiterView.setLayout(new BorderLayout(0, 0));
																																																																																						
																																																																																						panel_12 = new JPanel();
																																																																																						panel_12.setBorder(new EmptyBorder(2, 1, 0, 2));
																																																																																						mitarbeiterView.add(panel_12, BorderLayout.WEST);
																																																																																						GridBagLayout gbl_panel_12 = new GridBagLayout();
																																																																																						gbl_panel_12.columnWidths = new int[] {0, 0, 0};
																																																																																						gbl_panel_12.rowHeights = new int[] {0, 0, 0, 10};
																																																																																						gbl_panel_12.columnWeights = new double[]{0.0, Double.MIN_VALUE};
																																																																																						gbl_panel_12.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
																																																																																						panel_12.setLayout(gbl_panel_12);
																																																																																						
																																																																																						btn_mitarbeiterRefresh = new JButton("Aktualisieren");
																																																																																						btn_mitarbeiterRefresh.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																						GridBagConstraints gbc_btn_mitarbeiterRefresh = new GridBagConstraints();
																																																																																						gbc_btn_mitarbeiterRefresh.fill = GridBagConstraints.HORIZONTAL;
																																																																																						gbc_btn_mitarbeiterRefresh.insets = new Insets(0, 0, 5, 0);
																																																																																						gbc_btn_mitarbeiterRefresh.gridx = 0;
																																																																																						gbc_btn_mitarbeiterRefresh.gridy = 0;
																																																																																						panel_12.add(btn_mitarbeiterRefresh, gbc_btn_mitarbeiterRefresh);
																																																																																						btn_mitarbeiterRefresh.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
																																																																																						btn_mitarbeiterRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
																																																																																						
																																																																																						btn_mitarbeiterNew = new JButton("Neuer Mitarbeiter");
																																																																																						btn_mitarbeiterNew.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																						GridBagConstraints gbc_btn_mitarbeiterNew = new GridBagConstraints();
																																																																																						gbc_btn_mitarbeiterNew.insets = new Insets(0, 0, 5, 0);
																																																																																						gbc_btn_mitarbeiterNew.gridx = 0;
																																																																																						gbc_btn_mitarbeiterNew.gridy = 1;
																																																																																						panel_12.add(btn_mitarbeiterNew, gbc_btn_mitarbeiterNew);
																																																																																						btn_mitarbeiterNew.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/add.png")));
																																																																																						btn_mitarbeiterNew.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																						
																																																																																						MitarbeiterScrollPane = new JScrollPane();
																																																																																						MitarbeiterScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
																																																																																						mitarbeiterView.add(MitarbeiterScrollPane, BorderLayout.CENTER);
																																																																																						
																																																																																						mitarbeiter = new JTable();
																																																																																						mitarbeiter.setBackground(new Color(240, 248, 255));
																																																																																						mitarbeiter.setFont(new Font("Calibri", Font.BOLD, 15));
																																																																																						mitarbeiter.setFillsViewportHeight(true);
																																																																																						MitarbeiterScrollPane.setViewportView(mitarbeiter);
																																																																																						
																																																																																						panel_Fußleiste = new JPanel();
																																																																																						panel_Fußleiste.setBorder(new EmptyBorder(4, 1, 4, 1));
																																																																																						mitarbeiterView.add(panel_Fußleiste, BorderLayout.SOUTH);
																																																																																						panel_Fußleiste.setLayout(new BoxLayout(panel_Fußleiste, BoxLayout.X_AXIS));
																																																																																						
																																																																																						panel_2 = new JPanel();
																																																																																						panel_Fußleiste.add(panel_2);
																																																																																						panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
																																																																																						
																																																																																						btn_sucheMitarbeiter = new JButton("Suchen");
																																																																																						btn_sucheMitarbeiter.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/search.png")));
																																																																																						btn_sucheMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																						panel_2.add(btn_sucheMitarbeiter);
																																																																																						
																																																																																						combo_sucheMitarbeiter = new JComboBox<String>();
																																																																																						combo_sucheMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																						combo_sucheMitarbeiter.setMaximumRowCount(10);
																																																																																						combo_sucheMitarbeiter.setModel(new DefaultComboBoxModel<String>(new String[] {"Name", "Abteilung", "Kontakt", "Standort", "Username"}));
																																																																																						panel_2.add(combo_sucheMitarbeiter);
																																																																																						
																																																																																						txt_sucheMitarbeiter = new JTextField();
																																																																																						txt_sucheMitarbeiter.setBackground(SystemColor.text);
																																																																																						txt_sucheMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 12));
																																																																																						panel_2.add(txt_sucheMitarbeiter);
																																																																																						txt_sucheMitarbeiter.setColumns(10);
																																																																																		
																																																																																				kundenView = new JPanel();
																																																																																				kundenView.setBackground(new Color(245, 245, 245));
																																																																																				panel_5.add(kundenView, "name_463006295653787");
																																																																																				kundenView.setLayout(new BorderLayout(0, 0));
																																																																																						
																																																																																						panel_13 = new JPanel();
																																																																																						panel_13.setBorder(new EmptyBorder(2, 1, 0, 2));
																																																																																						kundenView.add(panel_13, BorderLayout.WEST);
																																																																																						GridBagLayout gbl_panel_13 = new GridBagLayout();
																																																																																						gbl_panel_13.columnWidths = new int[]{0, 0};
																																																																																						gbl_panel_13.rowHeights = new int[]{0, 0, 0, 0, 0};
																																																																																						gbl_panel_13.columnWeights = new double[]{0.0, Double.MIN_VALUE};
																																																																																						gbl_panel_13.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
																																																																																						panel_13.setLayout(gbl_panel_13);
																																																																																								
																																																																																										btn_kundeRefresh = new JButton("Aktualisieren");
																																																																																										btn_kundeRefresh.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																										GridBagConstraints gbc_btn_kundeRefresh = new GridBagConstraints();
																																																																																										gbc_btn_kundeRefresh.insets = new Insets(0, 0, 5, 0);
																																																																																										gbc_btn_kundeRefresh.gridx = 0;
																																																																																										gbc_btn_kundeRefresh.gridy = 0;
																																																																																										panel_13.add(btn_kundeRefresh, gbc_btn_kundeRefresh);
																																																																																										btn_kundeRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
																																																																																										btn_kundeRefresh.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
																																																																																								
																																																																																										btn_kundeNew = new JButton("Neuer Kunde");
																																																																																										btn_kundeNew.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																										GridBagConstraints gbc_btn_kundeNew = new GridBagConstraints();
																																																																																										gbc_btn_kundeNew.fill = GridBagConstraints.HORIZONTAL;
																																																																																										gbc_btn_kundeNew.insets = new Insets(0, 0, 5, 0);
																																																																																										gbc_btn_kundeNew.gridx = 0;
																																																																																										gbc_btn_kundeNew.gridy = 1;
																																																																																										panel_13.add(btn_kundeNew, gbc_btn_kundeNew);
																																																																																										btn_kundeNew.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/add.png")));
																																																																																										btn_kundeNew.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																				
																																																																																						KundenScrollPane = new JScrollPane();
																																																																																						KundenScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
																																																																																						KundenScrollPane.setViewportView(kunden);
																																																																																						
																																																																																						kundenView.add(KundenScrollPane, BorderLayout.CENTER);
																																																																																						
																																																																																						kunden = new JTable();
																																																																																						kunden.setBackground(new Color(240, 248, 255));
																																																																																						kunden.setFont(new Font("Calibri", Font.BOLD, 15));
																																																																																						kunden.setFillsViewportHeight(true);
																																																																																						KundenScrollPane.setViewportView(kunden);
																																																																																						
																																																																																								panel_KundenButtons = new JPanel();
																																																																																								panel_KundenButtons.setBorder(new EmptyBorder(4, 1, 4, 1));
																																																																																								kundenView.add(panel_KundenButtons, BorderLayout.SOUTH);
																																																																																								panel_KundenButtons.setLayout(new BoxLayout(panel_KundenButtons,
																																																																																										BoxLayout.X_AXIS));
																																																																																												
																																																																																														panel_1 = new JPanel();
																																																																																														FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
																																																																																														flowLayout_1.setAlignment(FlowLayout.LEFT);
																																																																																														panel_KundenButtons.add(panel_1);
																																																																																																
																																																																																																		btn_sucheKunde = new JButton("Suchen");
																																																																																																		btn_sucheKunde.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/search.png")));
																																																																																																		btn_sucheKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																																		panel_1.add(btn_sucheKunde);
																																																																																																
																																																																																																		combo_sucheKunde = new JComboBox<String>();
																																																																																																		combo_sucheKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																																																																		combo_sucheKunde.setMaximumRowCount(10);
																																																																																																		combo_sucheKunde.setModel(new DefaultComboBoxModel<String>(new String[] {
																																																																																																				"Name", "Adresse", "Kontakt", "Username" }));
																																																																																																		panel_1.add(combo_sucheKunde);
																																																																																																		
																																																																																																				txt_sucheKunde = new JTextField();
																																																																																																				txt_sucheKunde.setBackground(SystemColor.text);
																																																																																																				txt_sucheKunde.setFont(new Font("Tahoma", Font.PLAIN, 12));
																																																																																																				panel_1.add(txt_sucheKunde);
																																																																																																				txt_sucheKunde.setColumns(10);

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
			public void setComboMitarbeiterSuche(String[] comboListe){
				this.combo_sucheMitarbeiter.setModel(new DefaultComboBoxModel<String>(comboListe));
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
		public void setComboKundenSuche(String[] comboListe){
			this.combo_sucheKunde.setModel(new DefaultComboBoxModel<String>(comboListe));
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
	
	public void setTabelle(Ticket_Table t){
		setModel(t);
		TicketscrollPane.setViewportView(tickets);
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
	
	public void addListenerAllTickets(ActionListener a){
		btn_AllTickets.addActionListener(a);
	}
	public void addListenerNeueTickets(ActionListener a){
		btn_NeueTickets.addActionListener(a);
	}
	public void addListenerMeineTickets(ActionListener a){
		btn_MeineTickets.addActionListener(a);
	}
	public void addListenerGeschlosseneTickets(ActionListener a){
		btn_GeschlosseneTickets.addActionListener(a);
	}
	public void addListenerFAQTickets(ActionListener a){
		btn_FAQTickets.addActionListener(a);
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
	public void setComboTicketSuche(String[] comboListe){
		this.combo_sucheTicket.setModel(new DefaultComboBoxModel<String>(comboListe));
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
