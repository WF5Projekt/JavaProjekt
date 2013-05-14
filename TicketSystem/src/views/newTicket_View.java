package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Window.Type;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Component;

public class newTicket_View extends JFrame {
	private JTextField _Beschreibung;

	/**
	 * Create the panel.
	 */
	public newTicket_View() {
		setBounds(new Rectangle(0, 0, 400, 200));
		setResizable(false);
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setTitle("Neues Ticket");
		
        // Center Window

        setLocationRelativeTo(null);
        
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		
		_Beschreibung = new JTextField();
		_Beschreibung.setHorizontalAlignment(SwingConstants.LEFT);
		_Beschreibung.setAlignmentY(Component.TOP_ALIGNMENT);
		_Beschreibung.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kategorie");
		
		JComboBox comboKategorie = new JComboBox();
		comboKategorie.setToolTipText("Kategorie");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Kategorie");
		
		JLabel lblPrioritt = new JLabel("Priorit\u00E4t");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setAutoCreateGaps(true);
		gl_panel.setHonorsVisibility(false);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblBeschreibung))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(_Beschreibung, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboKategorie, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
							.addComponent(lblPrioritt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(84))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblBeschreibung))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(_Beschreibung, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(comboKategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(50))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrioritt))
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		JButton btn_Eröffnen = new JButton("Ticket er\u00F6ffnen");
		panel_4.add(btn_Eröffnen);
		
		JButton btn_Abbruch = new JButton("Abbrechen");
		panel_4.add(btn_Abbruch);

	}
}
