package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Main_View extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabs;
	
	/**
	 * Create the frame.
	 */
	public Main_View() {
		setTitle("Trouble Ticket System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1529, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabs, BorderLayout.NORTH);
		
		
        
        pack();
		
		setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
	}
	
	public void setTab(Tab_View tab){
		this.tabs.addTab(tab.getTitel(), tab.getTab());
	}

}
