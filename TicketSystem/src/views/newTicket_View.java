package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import org.jdesktop.swingx.autocomplete.*;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class newTicket_View extends JFrame {
	
	private JButton btn_Abbruch;
	private JButton btn_Eröffnen;
	
	public JTextArea _beschreibung;
	public JComboBox<String> kat;
	public JComboBox<String> prio;
	public JComboBox<String> kunde;

	public newTicket_View() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(newTicket_View.class.getResource("/lib/png/add.png")));
		setUndecorated(true);
		setResizable(false);
		setAutoRequestFocus(false);
		setType(Type.POPUP);
		setTitle("Neues Ticket");
		
        // Center Window

        setLocationRelativeTo(null);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.border"));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		
		kat = new JComboBox<String>();
		kat.setToolTipText("Kategorie");
		AutoCompleteDecorator.decorate(kat);
	
		prio = new JComboBox<String>();
		prio.setToolTipText("Priorität");
		AutoCompleteDecorator.decorate(prio);
		
		_beschreibung = new JTextArea();
		_beschreibung.setColumns(10);
		_beschreibung.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		_beschreibung.setBackground(SystemColor.text);
		_beschreibung.setRows(11);
		
		
		_beschreibung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		_beschreibung.setRows(11);
		_beschreibung.setLineWrap(true);
		_beschreibung.setWrapStyleWord(true);
		
		
		kunde = new JComboBox<String>();
		kunde.setToolTipText("Kunde");
		AutoCompleteDecorator.decorate(kunde);
		
		JLabel lblKunde = new JLabel("Kunde:");
		lblKunde.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblPrioritt = new JLabel("Priorit\u00E4t:");
		lblPrioritt.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblKategorie = new JLabel("Kategorie:");
		lblKategorie.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(_beschreibung, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
						.addComponent(lblKunde, Alignment.LEADING)
						.addComponent(kunde, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBeschreibung, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblKategorie, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(kat, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
							.addComponent(lblPrioritt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(prio, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblKunde)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(kunde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(lblBeschreibung, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_beschreibung, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(prio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKategorie, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(kat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrioritt, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		gl_panel.setAutoCreateGaps(true);
		gl_panel.setHonorsVisibility(false);
		panel.setLayout(gl_panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(UIManager.getBorder("InternalFrame.border"));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		btn_Eröffnen = new JButton("Ticket er\u00F6ffnen");
		btn_Eröffnen.setIcon(new ImageIcon(newTicket_View.class.getResource("/lib/png/save.png")));
	
		panel_4.add(btn_Eröffnen);
		
		btn_Abbruch = new JButton("Abbrechen");
		btn_Abbruch.setIcon(new ImageIcon(newTicket_View.class.getResource("/lib/png/cancel.png")));
		btn_Abbruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_4.add(btn_Abbruch);
		
		pack();
		this.setLocationRelativeTo(null);

	}
	
	
	public void addListenerButton(ActionListener a){
		btn_Eröffnen.addActionListener(a);
	}
}
