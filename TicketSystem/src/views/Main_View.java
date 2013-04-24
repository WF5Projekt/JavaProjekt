package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class Main_View extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabs;
	private JPanel panel_left;
	private JPanel panel_top;
	private JButton btnNew;
	
	/**
	 * Create the frame.
	 */
	public Main_View() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Trouble Ticket System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1529, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(tabs, BorderLayout.CENTER);
		
		JPanel page_end = new JPanel();
		contentPane.add(page_end, BorderLayout.SOUTH);
		page_end.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_left = new JPanel();
		contentPane.add(panel_left, BorderLayout.WEST);
		
		btnNew = new JButton("New button");
		btnNew.setBorder(null);
		panel_left.add(btnNew);
		
		panel_top = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_top.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_top, BorderLayout.NORTH);
		
		
        
        pack();
		
		setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
	}
	
	public void setTab(Tab_View tab){
		this.tabs.addTab(tab.getTitel(), tab.getTab());
	}

}
