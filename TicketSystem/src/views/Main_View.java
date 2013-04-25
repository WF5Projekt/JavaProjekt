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

@SuppressWarnings("serial")
public class Main_View extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabs;
	private JPanel panel_top;
	

	public Main_View() {
		
		try {
			UIManager.setLookAndFeel(
			    UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("Trouble Ticket System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabs.setForeground(new Color(0, 0, 0));
		tabs.setBackground(Color.LIGHT_GRAY);
		tabs.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabs.setOpaque(true);
		contentPane.add(tabs, BorderLayout.CENTER);
		
		
		JPanel page_end = new JPanel();
		page_end.setBackground(Color.LIGHT_GRAY);
		contentPane.add(page_end, BorderLayout.SOUTH);
		page_end.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_top = new JPanel();
		panel_top.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel_top.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_top, BorderLayout.NORTH);
		this.setLocationRelativeTo(null);
	}
	
	public void setTab(Tab_View tab){
		this.tabs.addTab(tab.getTitel(), tab.getTab());
	}

}
