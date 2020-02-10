package alex.CarWashProject.viewcontroller;

import java.awt.EventQueue;

public class CarWashApp {
	
	static MainWindow mainFrame;
	static FrmCarInsert carInsertFrame;
	static FrmCarUpdate carUpdateFrame;
	static FrmHistory carsHistory;
	static SearchForm carSearchFrame;
	static Version version;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {							
					mainFrame = new MainWindow();
					mainFrame.setLocationRelativeTo(null);
					mainFrame.setVisible(true);
					
					carInsertFrame = new FrmCarInsert();
					carInsertFrame.setLocationRelativeTo(null);
					carInsertFrame.setVisible(false);
					
					carUpdateFrame = new FrmCarUpdate();
					carUpdateFrame.setLocationRelativeTo(null);
					carUpdateFrame.setVisible(false);
					
					carsHistory = new FrmHistory();
					carsHistory.setLocationRelativeTo(null);
					carsHistory.setVisible(false);
					
					carSearchFrame = new SearchForm();
					carSearchFrame.setLocationRelativeTo(null);
					carSearchFrame.setVisible(false);
					
					version = new Version();
					version.setLocationRelativeTo(null);
					version.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}}


