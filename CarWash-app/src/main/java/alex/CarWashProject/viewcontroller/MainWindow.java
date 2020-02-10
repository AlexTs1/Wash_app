package alex.CarWashProject.viewcontroller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alex.CarWashProject.viewcontroller.CarWashApp;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CarWash Application");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(131, 11, 164, 26);
		contentPane.add(lblNewLabel);
		
		JButton btn_newInsert = new JButton("\u039D\u03AD\u03B1 \u03BA\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		btn_newInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        		CarWashApp.mainFrame.setEnabled(false);
				CarWashApp.carInsertFrame.setVisible(true);	
			}
		});
		btn_newInsert.setBounds(142, 116, 140, 23);
		contentPane.add(btn_newInsert);
		
		JButton btn_history = new JButton("\u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC");
		btn_history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.mainFrame.setEnabled(false);
				CarWashApp.carsHistory.setVisible(true);	
			}
		});
		btn_history.setBounds(168, 211, 89, 23);
		contentPane.add(btn_history);
		
		JButton btn_search = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.mainFrame.setEnabled(false);
				CarWashApp.carSearchFrame.setVisible(true);	
			}
		});
		btn_search.setBounds(155, 162, 114, 23);
		contentPane.add(btn_search);
	}
}
