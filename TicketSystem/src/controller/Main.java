package controller;

import java.awt.EventQueue;





public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Controller LoginController = new Login_Controller();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
