package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import models.Ticket;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class newTicket_View extends JFrame {
	
	private JButton btn_Abbruch;
	private JButton btn_Eröffnen;
	
	public JTextArea _beschreibung;
	public JComboBox<String> kat;
	public JComboBox<String> prio;
	public JComboBox<String> kunde;
	
	private JPanel panel_1;

	public newTicket_View() {
		setBounds(new Rectangle(0, 0, 515, 315));
		setResizable(false);
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setTitle("Neues Ticket");
		
        // Center Window

        setLocationRelativeTo(null);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Kunde:");
		
		
		kunde = new JComboBox<String>();
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
		panel_1.add(lblNewLabel_1);
		panel_1.add(kunde);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		
		JLabel lblNewLabel = new JLabel("Kategorie");
		
		
		kat = new JComboBox<String>();
		kat.setToolTipText("Kategorie");
		
		prio = new JComboBox<String>();
		prio.setToolTipText("Kategorie");
		
		JLabel lblPrioritt = new JLabel("Priorit\u00E4t");
		
		_beschreibung = new JTextArea();
		_beschreibung.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		_beschreibung.setBackground(SystemColor.menu);
		_beschreibung.setRows(11);
		
		
		_beschreibung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		_beschreibung.setRows(11);
		_beschreibung.setLineWrap(true);
		_beschreibung.setWrapStyleWord(true);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBeschreibung)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(kat, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(lblPrioritt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(prio, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(97))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addComponent(_beschreibung)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeschreibung)
						.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(kat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(prio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrioritt))
					.addGap(190))
		);
		gl_panel.setAutoCreateGaps(true);
		gl_panel.setHonorsVisibility(false);
		panel.setLayout(gl_panel);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		btn_Eröffnen = new JButton("Ticket er\u00F6ffnen");
	
		panel_4.add(btn_Eröffnen);
		
		btn_Abbruch = new JButton("Abbrechen");
		btn_Abbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_4.add(btn_Abbruch);

	}
	
	
	public void addListenerButton(ActionListener a){
		btn_Eröffnen.addActionListener(a);
	}
}
