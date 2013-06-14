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
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Main_View extends JFrame {

	private JPanel contentPane;
	private JPanel mitarbeiterView;
	private JPanel kundenView;
	private JPanel ticketView;

	private int UserLevel;

	private JButton btnAllesAktualisieren;
	private JButton btn_Einstellungen;

	private JButton btnKunden;
	private JButton btnMitarbeiter;
	private JButton btnTickets;
	// Ticket-Tab
	private JScrollPane TicketscrollPane;

	private JComboBox<String> combo_sucheTicket;
	
	private JPanel panel_ticketdetails;

	private JLabel _email_m;
	private JLabel _email_k;
	private JLabel _abteilung;
	private JLabel _name_k;
	private JLabel _nachname_m;
	private JLabel _telefon_m;
	private JLabel _level_m;

	private JLabel _priorität;
	private JLabel _kategorie;
	private JLabel _level;
	private JLabel _status;
	private JLabel _erstellzeitpunkt;
	private JLabel _beschreibung;
	private JLabel _telefon_k;

	private JButton btn_TicketRefresh;
	private JButton btn_sucheTicket;
	private JButton btn_TicketNeu;
	private JButton btn_AllTickets;
	private JButton btn_NeueTickets;
	private JButton btn_MeineTickets;
	private JButton btn_GelösteTickets;
	private JButton btn_FAQTickets;
	private JButton btn_TicketErfassen;
	private JButton btn_TicketAlsFAQ;
	private JButton btn_TicketAnKunde;
	private JButton btn_TicketBearbeiten;
	private JButton btn_AbgeschlosseneTickets;
	private JButton btn_TicketsOffen;
	private JTextField txt_sucheTicket;

	public JTable tickets;

	// Kunden-Tab
	private JPanel panel;
	private JPanel panel_KundenButtons;
	private JPanel panel_1;

	private JScrollPane KundenScrollPane;
	private JComboBox<String> combo_sucheKunde;

	private JTextField txt_sucheKunde;

	private JButton btn_sucheKunde;
	private JButton btn_kundeEdit;
	private JButton btn_kundeRefresh;

	public JTable kunden;

	// Mitarbeiter-Tab

	private JComboBox<String> combo_sucheMitarbeiter;
	private JScrollPane MitarbeiterScrollPane;
	
	private JTextField txt_sucheMitarbeiter;

	private JButton btn_mitarbeiterNew;
	private JButton btn_mitarbeiterEdit;
	private JButton btn_mitarbeiterRefresh;
	private JButton btn_sucheMitarbeiter;
	
	private JPanel panel_Fußleiste;
	private JPanel panel_2;
	public JTable mitarbeiter;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel _erreichbarkeit;
	private JLabel lblErreichbar;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panelInfoTicket2;
	private JLabel _loesung;
	private JLabel lblLsungsvorschlag;
	private JPanel panel_14;
	private JPanel panel_13;
	private JLabel lblAnzeigen;

	public Main_View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Main_View.class.getResource("/lib/png/cup.png")));
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

		btnTickets = new JButton("Tickets");
		btnTickets.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/connect.png")));
		btnTickets.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnTickets);

		btnKunden = new JButton("Kunden");
		btnKunden.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/users.png")));
		btnKunden.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnKunden);

		btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/user-male-alt-3.png")));
		btnMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(btnMitarbeiter);

		// Durchwechseln zwischen "Tickets" "Kunden" "Mitarbeiter"
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
		btnTickets.addActionListener(new ActionListener() {
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

		btn_Einstellungen = new JButton("Einstellungen");
		panel_7.add(btn_Einstellungen);
		btn_Einstellungen.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/settings.png")));
		btn_Einstellungen.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnAllesAktualisieren = new JButton("Alles Aktualisieren");
		btnAllesAktualisieren.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
		btnAllesAktualisieren.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(btnAllesAktualisieren);

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
		gbl_panel_10.columnWidths = new int[] { 0, 0 };
		gbl_panel_10.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 30, 0, 0, 0, 0 };
		gbl_panel_10.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_10.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_10.setLayout(gbl_panel_10);

		btn_TicketRefresh = new JButton("Aktualisieren");
		btn_TicketRefresh.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
		btn_TicketRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				12));
		GridBagConstraints gbc_btn_TicketRefresh = new GridBagConstraints();
		gbc_btn_TicketRefresh.anchor = GridBagConstraints.NORTH;
		gbc_btn_TicketRefresh.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketRefresh.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketRefresh.gridx = 0;
		gbc_btn_TicketRefresh.gridy = 0;
		panel_10.add(btn_TicketRefresh, gbc_btn_TicketRefresh);

		btn_TicketNeu = new JButton("Neues Ticket");
		btn_TicketNeu.setHorizontalAlignment(SwingConstants.LEFT);
		btn_TicketNeu.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/add.png")));
		btn_TicketNeu.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_TicketNeu = new GridBagConstraints();
		gbc_btn_TicketNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketNeu.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketNeu.gridx = 0;
		gbc_btn_TicketNeu.gridy = 1;
		panel_10.add(btn_TicketNeu, gbc_btn_TicketNeu);

		btn_TicketErfassen = new JButton("Ticket Erfassen");
		btn_TicketErfassen.setVisible(false);
		btn_TicketErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btn_TicketErfassen.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/arrow-1-forward.png")));
		btn_TicketErfassen.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_TicketErfassen = new GridBagConstraints();
		gbc_btn_TicketErfassen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketErfassen.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketErfassen.gridx = 0;
		gbc_btn_TicketErfassen.gridy = 2;
		panel_10.add(btn_TicketErfassen, gbc_btn_TicketErfassen);

		btn_TicketBearbeiten = new JButton("Bearbeiten");
		btn_TicketBearbeiten.setVisible(false);
		btn_TicketBearbeiten.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/edit.png")));
		btn_TicketBearbeiten.setHorizontalAlignment(SwingConstants.LEFT);
		btn_TicketBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_TicketBearbeiten = new GridBagConstraints();
		gbc_btn_TicketBearbeiten.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketBearbeiten.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketBearbeiten.gridx = 0;
		gbc_btn_TicketBearbeiten.gridy = 3;
		panel_10.add(btn_TicketBearbeiten, gbc_btn_TicketBearbeiten);

		btn_TicketAnKunde = new JButton("Antwort an Kunde");

		btn_TicketAnKunde.setVisible(false);
		btn_TicketAnKunde.setHorizontalAlignment(SwingConstants.LEFT);
		btn_TicketAnKunde.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/check.png")));
		btn_TicketAnKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_TicketAnKunde = new GridBagConstraints();
		gbc_btn_TicketAnKunde.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketAnKunde.anchor = GridBagConstraints.SOUTH;
		gbc_btn_TicketAnKunde.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketAnKunde.gridx = 0;
		gbc_btn_TicketAnKunde.gridy = 4;
		panel_10.add(btn_TicketAnKunde, gbc_btn_TicketAnKunde);

		btn_TicketAlsFAQ = new JButton("Als FAQ speichern");
		btn_TicketAlsFAQ.setVisible(false);
		btn_TicketAlsFAQ.setHorizontalAlignment(SwingConstants.LEFT);
		btn_TicketAlsFAQ.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/checkbox.png")));
		btn_TicketAlsFAQ.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_TicketAlsFAQ = new GridBagConstraints();
		gbc_btn_TicketAlsFAQ.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_TicketAlsFAQ.insets = new Insets(0, 0, 5, 0);
		gbc_btn_TicketAlsFAQ.gridx = 0;
		gbc_btn_TicketAlsFAQ.gridy = 5;
		panel_10.add(btn_TicketAlsFAQ, gbc_btn_TicketAlsFAQ);

		panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 6;
		panel_10.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblAnzeigen = new JLabel("  Anzeigen:");
		lblAnzeigen.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblAnzeigen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzeigen = new GridBagConstraints();
		gbc_lblAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAnzeigen.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnzeigen.gridx = 0;
		gbc_lblAnzeigen.gridy = 7;
		panel_10.add(lblAnzeigen, gbc_lblAnzeigen);

		btn_NeueTickets = new JButton("Neue Tickets");
		btn_NeueTickets.setHorizontalAlignment(SwingConstants.LEFT);
		btn_NeueTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/asterisk.png")));
		btn_NeueTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btn_NeueTickets = new GridBagConstraints();
		gbc_btn_NeueTickets.insets = new Insets(0, 0, 5, 0);
		gbc_btn_NeueTickets.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_NeueTickets.gridx = 0;
		gbc_btn_NeueTickets.gridy = 8;
		panel_10.add(btn_NeueTickets, gbc_btn_NeueTickets);
		
				btn_FAQTickets = new JButton("FAQ");
				btn_FAQTickets.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
									
											btn_AllTickets = new JButton("Alle Tickets");
											btn_AllTickets.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
												}
											});
													
													btn_TicketsOffen = new JButton("Offene Tickets");
													btn_TicketsOffen.setHorizontalAlignment(SwingConstants.LEFT);
													btn_TicketsOffen.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/files.png")));
													btn_TicketsOffen.setFont(new Font("Tahoma", Font.BOLD, 12));
													GridBagConstraints gbc_btn_TicketsOffen = new GridBagConstraints();
													gbc_btn_TicketsOffen.fill = GridBagConstraints.HORIZONTAL;
													gbc_btn_TicketsOffen.insets = new Insets(0, 0, 5, 0);
													gbc_btn_TicketsOffen.gridx = 0;
													gbc_btn_TicketsOffen.gridy = 9;
													panel_10.add(btn_TicketsOffen, gbc_btn_TicketsOffen);
											
													btn_MeineTickets = new JButton("Meine Tickets");
													btn_MeineTickets.setHorizontalAlignment(SwingConstants.LEFT);
													btn_MeineTickets.setIcon(new ImageIcon(Main_View.class
															.getResource("/lib/png/user-male.png")));
													btn_MeineTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
													GridBagConstraints gbc_btn_MeineTickets = new GridBagConstraints();
													gbc_btn_MeineTickets.insets = new Insets(0, 0, 5, 0);
													gbc_btn_MeineTickets.fill = GridBagConstraints.HORIZONTAL;
													gbc_btn_MeineTickets.gridx = 0;
													gbc_btn_MeineTickets.gridy = 10;
													panel_10.add(btn_MeineTickets, gbc_btn_MeineTickets);
											btn_AllTickets.setHorizontalAlignment(SwingConstants.LEFT);
											btn_AllTickets.setIcon(new ImageIcon(Main_View.class
													.getResource("/lib/png/list.png")));
											btn_AllTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
											GridBagConstraints gbc_btn_AllTickets = new GridBagConstraints();
											gbc_btn_AllTickets.insets = new Insets(0, 0, 5, 0);
											gbc_btn_AllTickets.fill = GridBagConstraints.HORIZONTAL;
											gbc_btn_AllTickets.gridx = 0;
											gbc_btn_AllTickets.gridy = 11;
											panel_10.add(btn_AllTickets, gbc_btn_AllTickets);
							
									btn_GelösteTickets = new JButton("Tickets mit L\u00F6sung");
									btn_GelösteTickets.setHorizontalAlignment(SwingConstants.LEFT);
									btn_GelösteTickets.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/arrow-1-backward.png")));
									btn_GelösteTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
									GridBagConstraints gbc_btn_GelösteTickets = new GridBagConstraints();
									gbc_btn_GelösteTickets.insets = new Insets(0, 0, 5, 0);
									gbc_btn_GelösteTickets.fill = GridBagConstraints.HORIZONTAL;
									gbc_btn_GelösteTickets.gridx = 0;
									gbc_btn_GelösteTickets.gridy = 12;
									panel_10.add(btn_GelösteTickets, gbc_btn_GelösteTickets);
					
							btn_AbgeschlosseneTickets = new JButton("Abgeschlossene Tickets");
							btn_AbgeschlosseneTickets.setIcon(new ImageIcon(Main_View.class
									.getResource("/lib/png/check.png")));
							btn_AbgeschlosseneTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
							GridBagConstraints gbc_btn_AbgeschlosseneTickets = new GridBagConstraints();
							gbc_btn_AbgeschlosseneTickets.insets = new Insets(0, 0, 5, 0);
							gbc_btn_AbgeschlosseneTickets.gridx = 0;
							gbc_btn_AbgeschlosseneTickets.gridy = 13;
							panel_10.add(btn_AbgeschlosseneTickets, gbc_btn_AbgeschlosseneTickets);
				
					btn_FAQTickets.setHorizontalAlignment(SwingConstants.LEFT);
					btn_FAQTickets.setIcon(new ImageIcon(Main_View.class
							.getResource("/lib/png/help.png")));
					btn_FAQTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
					GridBagConstraints gbc_btn_FAQTickets = new GridBagConstraints();
					gbc_btn_FAQTickets.insets = new Insets(0, 0, 5, 0);
					gbc_btn_FAQTickets.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_FAQTickets.gridx = 0;
					gbc_btn_FAQTickets.gridy = 14;
					panel_10.add(btn_FAQTickets, gbc_btn_FAQTickets);

		panel_9 = new JPanel();
		ticketView.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		TicketscrollPane = new JScrollPane();
		panel_9.add(TicketscrollPane, BorderLayout.CENTER);
		TicketscrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		TicketscrollPane.setViewportBorder(new SoftBevelBorder(
				BevelBorder.LOWERED, null, null, null, null));

		tickets = new JTable();
		tickets.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tickets.setFont(new Font("Calibri", Font.BOLD, 15));
		tickets.setFillsViewportHeight(true);
		tickets.setBackground(new Color(240, 248, 255));
		TicketscrollPane.setViewportView(tickets);
		panel_ticketdetails = new JPanel();
		panel_9.add(panel_ticketdetails, BorderLayout.SOUTH);
		panel_ticketdetails.setBackground(new Color(245, 245, 245));
		panel_ticketdetails.setBorder(null);
		panel_ticketdetails.setLayout(new BorderLayout(0, 0));

		JPanel panelInfoTicket = new JPanel();
		panelInfoTicket.setBackground(new Color(245, 245, 245));
		panelInfoTicket.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblKundendaten = new JLabel("Beschreibung:");
		lblKundendaten.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKundendaten.setHorizontalAlignment(SwingConstants.RIGHT);

		_beschreibung = new JLabel("-");
		_beschreibung.setVerticalAlignment(SwingConstants.TOP);
		_beschreibung.setHorizontalAlignment(SwingConstants.LEFT);
		panel_ticketdetails.add(panelInfoTicket, BorderLayout.CENTER);
		
		_loesung = new JLabel("-");
		_loesung.setVerticalAlignment(SwingConstants.TOP);
		_loesung.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblLsungsvorschlag = new JLabel("L\u00F6sungsvorschlag:");
		lblLsungsvorschlag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLsungsvorschlag.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panelInfoTicket = new GroupLayout(panelInfoTicket);
		gl_panelInfoTicket.setHorizontalGroup(
			gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoTicket.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfoTicket.createSequentialGroup()
							.addGap(10)
							.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
							.addComponent(_loesung, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInfoTicket.createSequentialGroup()
							.addComponent(lblKundendaten)
							.addGap(377)
							.addComponent(lblLsungsvorschlag, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelInfoTicket.setVerticalGroup(
			gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoTicket.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKundendaten)
						.addComponent(lblLsungsvorschlag))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoTicket.createParallelGroup(Alignment.LEADING)
						.addComponent(_loesung, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelInfoTicket.setLayout(gl_panelInfoTicket);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_ticketdetails.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));

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
		GroupLayout gl_panelInfoMitarbeiter = new GroupLayout(
				panelInfoMitarbeiter);
		gl_panelInfoMitarbeiter.setHorizontalGroup(
			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHelpdesk, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAbteilung, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblTelefon_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblName_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addComponent(lblEmail_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
							.addComponent(_level_m, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
								.addComponent(_abteilung, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addComponent(_email_m, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(_telefon_m, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
								.addComponent(_nachname_m, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		gl_panelInfoMitarbeiter.setVerticalGroup(
			gl_panelInfoMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoMitarbeiter.createSequentialGroup()
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_1)
						.addComponent(_nachname_m))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(_telefon_m)
						.addComponent(lblTelefon_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(_email_m)
						.addComponent(lblEmail_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbteilung)
						.addComponent(_abteilung))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHelpdesk)
						.addComponent(_level_m))
					.addGap(5))
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
					.addContainerGap()
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblErreichbar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefon, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING, false)
						.addComponent(_erreichbarkeit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(_email_k, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addComponent(_telefon_k, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(_name_k, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(212))
		);
		gl_panelInfoErsteller.setVerticalGroup(
			gl_panelInfoErsteller.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfoErsteller.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(_name_k)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(_telefon_k)
						.addComponent(lblTelefon))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(_email_k)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfoErsteller.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblErreichbar)
						.addComponent(_erreichbarkeit))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panelInfoErsteller.setLayout(gl_panelInfoErsteller);
		
		panelInfoTicket2 = new JPanel();
		panelInfoTicket2.setBorder(new TitledBorder(null, "Zusatzinfos Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panelInfoTicket2);
				
						JLabel lblKategorie = new JLabel("Kategorie");
						lblKategorie.setHorizontalAlignment(SwingConstants.RIGHT);
		
				_kategorie = new JLabel("-");
				_kategorie.setVerticalAlignment(SwingConstants.TOP);
				_kategorie.setHorizontalAlignment(SwingConstants.LEFT);
				
						JLabel lblLevek = new JLabel("Level:");
						lblLevek.setHorizontalAlignment(SwingConstants.RIGHT);
				
						_level = new JLabel("-");
						_level.setVerticalAlignment(SwingConstants.TOP);
						_level.setHorizontalAlignment(SwingConstants.LEFT);
				
						JLabel lblPrioritt = new JLabel("Priorit\u00E4t:");
						lblPrioritt.setHorizontalAlignment(SwingConstants.RIGHT);
				
						_priorität = new JLabel("-");
						_priorität.setVerticalAlignment(SwingConstants.TOP);
						_priorität.setHorizontalAlignment(SwingConstants.LEFT);
				
						JLabel lblStatus = new JLabel("Status:");
						lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
				
						_status = new JLabel("-");
						_status.setVerticalAlignment(SwingConstants.TOP);
						_status.setHorizontalAlignment(SwingConstants.LEFT);
				
						_erstellzeitpunkt = new JLabel("-");
						_erstellzeitpunkt.setVerticalAlignment(SwingConstants.TOP);
						_erstellzeitpunkt.setHorizontalAlignment(SwingConstants.LEFT);
				
						JLabel lblErstellzeitpunkt = new JLabel("Erstellzeitpunkt:");
						lblErstellzeitpunkt.setHorizontalAlignment(SwingConstants.RIGHT);
				GroupLayout gl_panelInfoTicket2 = new GroupLayout(panelInfoTicket2);
				gl_panelInfoTicket2.setHorizontalGroup(
					gl_panelInfoTicket2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfoTicket2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLevek, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addComponent(lblPrioritt)
								.addComponent(lblKategorie)
								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblErstellzeitpunkt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.LEADING)
								.addComponent(_priorität, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(_level, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(_kategorie, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(_erstellzeitpunkt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(_status, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
							.addContainerGap(76, Short.MAX_VALUE))
				);
				gl_panelInfoTicket2.setVerticalGroup(
					gl_panelInfoTicket2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelInfoTicket2.createSequentialGroup()
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.BASELINE)
								.addComponent(_erstellzeitpunkt)
								.addComponent(lblErstellzeitpunkt))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.BASELINE)
								.addComponent(_status)
								.addComponent(lblStatus))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.BASELINE)
								.addComponent(_priorität)
								.addComponent(lblPrioritt))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLevek)
								.addComponent(_level))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelInfoTicket2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKategorie)
								.addComponent(_kategorie))
							.addContainerGap())
				);
				panelInfoTicket2.setLayout(gl_panelInfoTicket2);

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
		btn_sucheTicket.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/search.png")));
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

		MitarbeiterScrollPane = new JScrollPane();
		MitarbeiterScrollPane.setViewportBorder(new SoftBevelBorder(
				BevelBorder.LOWERED, null, null, null, null));
		mitarbeiterView.add(MitarbeiterScrollPane, BorderLayout.CENTER);

		mitarbeiter = new JTable();
		mitarbeiter.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		mitarbeiter.setBackground(new Color(240, 248, 255));
		mitarbeiter.setFont(new Font("Calibri", Font.BOLD, 15));
		mitarbeiter.setFillsViewportHeight(true);
		MitarbeiterScrollPane.setViewportView(mitarbeiter);

		panel_Fußleiste = new JPanel();
		panel_Fußleiste.setBorder(new EmptyBorder(4, 1, 4, 1));
		mitarbeiterView.add(panel_Fußleiste, BorderLayout.SOUTH);
		panel_Fußleiste.setLayout(new BoxLayout(panel_Fußleiste,
				BoxLayout.X_AXIS));

		panel_2 = new JPanel();
		panel_Fußleiste.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		btn_sucheMitarbeiter = new JButton("Suchen");
		btn_sucheMitarbeiter.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/search.png")));
		btn_sucheMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(btn_sucheMitarbeiter);

		combo_sucheMitarbeiter = new JComboBox<String>();
		combo_sucheMitarbeiter.setFont(new Font("Tahoma", Font.BOLD, 12));
		combo_sucheMitarbeiter.setMaximumRowCount(10);
		combo_sucheMitarbeiter.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Name", "Abteilung", "Kontakt", "Standort",
						"Username" }));
		panel_2.add(combo_sucheMitarbeiter);

		txt_sucheMitarbeiter = new JTextField();
		txt_sucheMitarbeiter.setBackground(SystemColor.text);
		txt_sucheMitarbeiter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(txt_sucheMitarbeiter);
		txt_sucheMitarbeiter.setColumns(10);
		
		panel_14 = new JPanel();
		panel_14.setBorder(new EmptyBorder(2, 1, 0, 2));
		mitarbeiterView.add(panel_14, BorderLayout.WEST);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{0, 0};
		gbl_panel_14.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_14.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_14.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_14.setLayout(gbl_panel_14);
				
						btn_mitarbeiterRefresh = new JButton("Aktualisieren");
						GridBagConstraints gbc_btn_mitarbeiterRefresh = new GridBagConstraints();
						gbc_btn_mitarbeiterRefresh.fill = GridBagConstraints.HORIZONTAL;
						gbc_btn_mitarbeiterRefresh.insets = new Insets(0, 0, 5, 0);
						gbc_btn_mitarbeiterRefresh.gridx = 0;
						gbc_btn_mitarbeiterRefresh.gridy = 0;
						panel_14.add(btn_mitarbeiterRefresh, gbc_btn_mitarbeiterRefresh);
						btn_mitarbeiterRefresh.setHorizontalAlignment(SwingConstants.LEFT);
						btn_mitarbeiterRefresh.setIcon(new ImageIcon(Main_View.class
								.getResource("/lib/png/3D-Z-Axis-Rotation.png")));
						btn_mitarbeiterRefresh.setFont(new Font("Tahoma", Font.BOLD
								| Font.ITALIC, 12));
						
								btn_mitarbeiterNew = new JButton("Neuer Mitarbeiter");
								GridBagConstraints gbc_btn_mitarbeiterNew = new GridBagConstraints();
								gbc_btn_mitarbeiterNew.insets = new Insets(0, 0, 5, 0);
								gbc_btn_mitarbeiterNew.gridx = 0;
								gbc_btn_mitarbeiterNew.gridy = 1;
								panel_14.add(btn_mitarbeiterNew, gbc_btn_mitarbeiterNew);
								btn_mitarbeiterNew.setHorizontalAlignment(SwingConstants.LEFT);
								btn_mitarbeiterNew.setIcon(new ImageIcon(Main_View.class
										.getResource("/lib/png/add.png")));
								btn_mitarbeiterNew.setFont(new Font("Tahoma", Font.BOLD, 12));
								
								btn_mitarbeiterEdit = new JButton("Bearbeiten");
								GridBagConstraints gbc_btn_mitarbeiterEdit = new GridBagConstraints();
								gbc_btn_mitarbeiterEdit.fill = GridBagConstraints.HORIZONTAL;
								gbc_btn_mitarbeiterEdit.gridx = 0;
								gbc_btn_mitarbeiterEdit.gridy = 2;
								panel_14.add(btn_mitarbeiterEdit, gbc_btn_mitarbeiterEdit);
								btn_mitarbeiterEdit.setHorizontalAlignment(SwingConstants.LEFT);
								btn_mitarbeiterEdit.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/edit.png")));
								btn_mitarbeiterEdit.setFont(new Font("Tahoma", Font.BOLD, 12));

		kundenView = new JPanel();
		kundenView.setBackground(new Color(245, 245, 245));
		panel_5.add(kundenView, "name_463006295653787");
		kundenView.setLayout(new BorderLayout(0, 0));

		panel_13 = new JPanel();
		panel_13.setBorder(new EmptyBorder(2, 1, 0, 2));
		kundenView.add(panel_13, BorderLayout.WEST);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[] { 0, 0 };
		gbl_panel_13.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_13.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_13.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_13.setLayout(gbl_panel_13);

		btn_kundeRefresh = new JButton("Aktualisieren");
		btn_kundeRefresh.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btn_kundeRefresh = new GridBagConstraints();
		gbc_btn_kundeRefresh.insets = new Insets(0, 0, 5, 0);
		gbc_btn_kundeRefresh.gridx = 0;
		gbc_btn_kundeRefresh.gridy = 0;
		panel_13.add(btn_kundeRefresh, gbc_btn_kundeRefresh);
		btn_kundeRefresh
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btn_kundeRefresh.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/3D-Z-Axis-Rotation.png")));

		btn_kundeEdit = new JButton("Bearbeiten");
		btn_kundeEdit.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btn_kundeEdit = new GridBagConstraints();
		gbc_btn_kundeEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_kundeEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btn_kundeEdit.gridx = 0;
		gbc_btn_kundeEdit.gridy = 1;
		panel_13.add(btn_kundeEdit, gbc_btn_kundeEdit);
		btn_kundeEdit.setIcon(new ImageIcon(Main_View.class.getResource("/lib/png/edit.png")));
		btn_kundeEdit.setFont(new Font("Tahoma", Font.BOLD, 12));

		KundenScrollPane = new JScrollPane();
		KundenScrollPane.setViewportBorder(new SoftBevelBorder(
				BevelBorder.LOWERED, null, null, null, null));
		KundenScrollPane.setViewportView(kunden);

		kundenView.add(KundenScrollPane, BorderLayout.CENTER);

		kunden = new JTable();
		kunden.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
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
		btn_sucheKunde.setIcon(new ImageIcon(Main_View.class
				.getResource("/lib/png/search.png")));
		btn_sucheKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btn_sucheKunde);

		combo_sucheKunde = new JComboBox<String>();
		combo_sucheKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
		combo_sucheKunde.setMaximumRowCount(10);
		combo_sucheKunde.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Name", "Adresse", "Kontakt", "Username" }));
		panel_1.add(combo_sucheKunde);

		txt_sucheKunde = new JTextField();
		txt_sucheKunde.setBackground(SystemColor.text);
		txt_sucheKunde.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(txt_sucheKunde);
		txt_sucheKunde.setColumns(10);

		this.setLocationRelativeTo(null);
	}

	public void addListenerRefreshAll(ActionListener a) {
		btnAllesAktualisieren.addActionListener(a);
	}
	public void addListenerSettings(ActionListener a){
		this.btn_Einstellungen.addActionListener(a);
	}
	

	/*
	 * ################################### USER einstellungen
	 * ###################################
	 * 
	 * Wenn Mitarbeiter Level-1 ist, darf er Tickets erfassen/zurück an Kunden
	 * schicken Mitarbeiter Level 2 darf lediglich bearbeiten/Lösungsvorschlag
	 * machen
	 */
	public void setUserLayout(String idLevel) {
		this.UserLevel = Integer.parseInt(idLevel);

		if (UserLevel == 1) {
			this.btn_NeueTickets.setVisible(true);
			this.btn_TicketBearbeiten.setVisible(false);
			this.btn_GelösteTickets.setVisible(true);
		} else if (UserLevel == 2 || UserLevel == 3) {

			this.btn_GelösteTickets.setVisible(false);
			this.btn_NeueTickets.setVisible(false);
			this.btn_TicketBearbeiten.setVisible(false);
		}
	}

	/*
	 * ################################### 
	 * MITARBEITER TAB
	 * ################################## 
	 * # Button-Listener # Tabellen-Modell * setter 
	 * # Suchfeld 
	 * ###################################
	 */

	// ############ Modell der Tabelle Mitarbeiter wird gesetzt
	public void setModel(Mitarbeiter_Table t) {
		mitarbeiter.setModel(t);
	}

	// ############ ActionListener für Mitarbeiter-Buttons

	public void addListenerMitarbeiterRefresh(ActionListener a) {
		btn_mitarbeiterRefresh.addActionListener(a);
	}

	public void addListenerMitarbeiterNew(ActionListener a) {
		btn_mitarbeiterNew.addActionListener(a);
	}
	public void addListenerMitarbeiterEdit(ActionListener a){
		btn_mitarbeiterEdit.addActionListener(a);
	}

	public void addKeyListenerMitarbeiterSuche(KeyListener a) {
		txt_sucheMitarbeiter.addKeyListener(a);
	}

	public void addListenerMitarbeiterSuche(ActionListener a) {
		btn_sucheMitarbeiter.addActionListener(a);
	}
	

	// ########### Suchfeld: Such-Text und die Such-Spalte wird an den
	// Controller gegeben.
	public String getTextSucheMitarbeiter() {
		return this.txt_sucheMitarbeiter.getText();
	}

	public String getSpalteSucheMitarbeiter() {
		return this.combo_sucheMitarbeiter.getSelectedItem().toString();
	}

	public int getSelectedMitarbeiter() {
		return mitarbeiter.getSelectedRow();
	}

	public void setComboMitarbeiterSuche(String[] comboListe) {
		this.combo_sucheMitarbeiter.setModel(new DefaultComboBoxModel<String>(
				comboListe));
	}

	/*
	 * ################################### KUNDEN TAB
	 * ################################## # Button-Listener # Tabellen-Modell
	 * setter # Suchfeld ###################################
	 */

	// ############ Modell der Tabelle Kunde wird gesetzt
	public void setModel(Kunde_Table t) {
		kunden.setModel(t);
	}

	// ############ ActionListener für Kunden-Buttons

	public void addListenerKundeRefresh(ActionListener a) {
		btn_kundeRefresh.addActionListener(a);
	}

	public void addListenerKundeEdit(ActionListener a) {
		btn_kundeEdit.addActionListener(a);
	}

	public void addKeyListenerKundeSuche(KeyListener a) {
		txt_sucheKunde.addKeyListener(a);
	}

	public void addListenerKundeSuche(ActionListener a) {
		btn_sucheKunde.addActionListener(a);
	}

	// ########### Suchfeld: Such-Text und die Such-Spalte wird an den
	// Controller gegeben.
	public String getTextSucheKunde() {
		return this.txt_sucheKunde.getText();
	}

	public String getSpalteSucheKunde() {
		return this.combo_sucheKunde.getSelectedItem().toString();
	}

	public int getSelectedKunde() {
		return kunden.getSelectedRow();
	}

	public void setComboKundenSuche(String[] comboListe) {
		this.combo_sucheKunde.setModel(new DefaultComboBoxModel<String>(
				comboListe));
	}

	/*
	 * ################################### TICKET TAB
	 * ################################## # Button-Listener # Tabellen-Modell
	 * setter # Ticket-Info setter # Suchfeld
	 * ###################################
	 */

	// ########### Methoden um das Tabellen Modell festzulegen
	public void setModel(Ticket_Table t) {
		tickets.setModel(t);
	}

	public void setTabelle(Ticket_Table t) {
		setModel(t);
	}

	
	public void viewDetails(Boolean b){
			panel_3.setVisible(b);
		
	}
	public void viewButtonsNeue() {
		this.btn_TicketBearbeiten.setVisible(false);
		this.btn_TicketAnKunde.setVisible(false);
		this.btn_TicketAlsFAQ.setVisible(false);
		this.btn_TicketErfassen.setVisible(true);
		this.btn_TicketsOffen.setVisible(true);

		if (UserLevel == 1) {
			this.btn_TicketErfassen.setVisible(true);

		} else if (UserLevel == 2 || UserLevel == 3) {
			this.btn_TicketErfassen.setVisible(false);

		}

	}

	public void viewButtonsMeine() {
		this.btn_TicketBearbeiten.setVisible(true);
		this.btn_TicketAlsFAQ.setVisible(false);
		this.btn_TicketErfassen.setVisible(false);

		this.btn_TicketsOffen.setVisible(true);

	}


	public void viewButtonsAlle() {
		this.btn_TicketAnKunde.setVisible(false);
		this.btn_TicketAlsFAQ.setVisible(false);
		this.btn_TicketErfassen.setVisible(false);
		this.btn_TicketBearbeiten.setVisible(false);
		this.btn_TicketsOffen.setVisible(true);
	}
	public void viewButtonsFertigeTickets(){
		this.btn_TicketBearbeiten.setVisible(false);
		this.btn_TicketAnKunde.setVisible(true);
		this.btn_TicketErfassen.setVisible(false);
		this.btn_TicketAlsFAQ.setVisible(false);
		this.btn_TicketsOffen.setVisible(true);
	}

	public void viewButtonsAbgeschlossene() {

		this.btn_TicketBearbeiten.setVisible(false);
		this.btn_TicketAnKunde.setVisible(false);
		this.btn_TicketErfassen.setVisible(false);
		this.btn_TicketsOffen.setVisible(true);
		if (UserLevel == 1) {
			this.btn_TicketAlsFAQ.setVisible(true);
		} else if (UserLevel == 2 || UserLevel == 3) {
			this.btn_TicketAlsFAQ.setVisible(false);
		}
	}

	public void viewButtonsFAQ() {
		this.btn_TicketBearbeiten.setVisible(false);
		this.btn_TicketAnKunde.setVisible(false);
		this.btn_TicketErfassen.setVisible(false);
		this.btn_TicketAlsFAQ.setVisible(false);
		this.btn_TicketsOffen.setVisible(true);
		if (UserLevel == 1) {
			this.btn_TicketBearbeiten.setVisible(true);
		}
	}

	// ########### ActionListener für Ticket-Buttons
	public void addListenerTicketRefresh(ActionListener a) {
		btn_TicketRefresh.addActionListener(a);
	}

	public void addListenerTicketNew(ActionListener a) {
		btn_TicketNeu.addActionListener(a);
	}

	public void addKeyListenerTicketSuche(KeyListener a) {
		txt_sucheTicket.addKeyListener(a);
	}

	public void addListenerTicketSuche(ActionListener a) {
		btn_sucheTicket.addActionListener(a);
	}

	public void addListenerAllTickets(ActionListener a) {
		btn_AllTickets.addActionListener(a);
	}

	public void addListenerNeueTickets(ActionListener a) {
		btn_NeueTickets.addActionListener(a);
	}

	public void addListenerMeineTickets(ActionListener a) {
		btn_MeineTickets.addActionListener(a);
	}

	public void addListenerTicketFertige(ActionListener a) {
		btn_GelösteTickets.addActionListener(a);
	}

	public void addListenerFAQTickets(ActionListener a) {
		btn_FAQTickets.addActionListener(a);
	}

	public void addListenerTicketEdit(ActionListener a) {
		btn_TicketBearbeiten.addActionListener(a);
	}

	public void addListenerTicketErfassen(ActionListener a) {
		btn_TicketErfassen.addActionListener(a);
	}
	public void addListenerTicketAbgeschlossene(ActionListener a) {
		this.btn_AbgeschlosseneTickets.addActionListener(a);
	}
	public void addListenerTicketsOffen(ActionListener a){
		this.btn_TicketsOffen.addActionListener(a);
	}
	public void addListenerTicketAnKunde(ActionListener a){
		this.btn_TicketAnKunde.addActionListener(a);
	}
	public void addListenerTicketAlsFAQ(ActionListener a){
		this.btn_TicketAlsFAQ.addActionListener(a);
	}
	
	// ########### Suchfeld: Such-Text und die Such-Spalte wird an den
	// Controller gegeben.
	public String getTextSucheTicket() {
		return this.txt_sucheTicket.getText();
	}

	public String getSpalteSucheTicket() {
		return this.combo_sucheTicket.getSelectedItem().toString();
	}

	public int getSelectedTicket() {
		return tickets.getSelectedRow();
	}

	public void setComboTicketSuche(String[] comboListe) {
		this.combo_sucheTicket.setModel(new DefaultComboBoxModel<String>(
				comboListe));
	}

	// ############# Setter für die Ticketinfos
	public void setInfoBeschreibung(String s) {
		this._beschreibung.setText("<html>" + s + "</html>");
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
	public void setInfoLösung(String s){
		this._loesung.setText("<html>" + s + "</html>");
	}

	public void setInfoHelpdesk(String s) {
		this._level_m.setText(s);
	}

	public void setInfoErreichbarkeit(String s) {
		this._erreichbarkeit.setText(s);
	}
}
