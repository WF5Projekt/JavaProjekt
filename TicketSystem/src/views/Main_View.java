package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main_View extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public Main_View() {
		setTitle("Troublero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setExtendedState(MAXIMIZED_BOTH);

		this.setLocationRelativeTo(null);
	}

}
