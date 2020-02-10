package alex.CarWashProject.viewcontroller;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SearchForm extends JFrame {

	static String searchLisencePlateVar;
	JPanel contentPane;
	JTextField searchLisence;
	JButton bntSearch;
	JButton bntClose;

	
	public SearchForm() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 414, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_lisence = new JLabel("\u0391\u03C1.  \u03A0\u03B9\u03BD\u03B1\u03BA\u03AF\u03B4\u03B1\u03C2");
		lbl_lisence.setForeground(new Color(165, 42, 42));
		lbl_lisence.setBackground(new Color(165, 42, 42));
		lbl_lisence.setFont(new Font("Dialog", Font.PLAIN, 21));
		lbl_lisence.setBounds(126, 24, 138, 28);
		panel.add(lbl_lisence);
		
		searchLisence = new JTextField();
		searchLisence.setBounds(126, 63, 138, 20);
		panel.add(searchLisence);
		searchLisence.setColumns(10);
		
		JButton btnSearch = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm.searchLisencePlateVar = searchLisence.getText();
				CarWashApp.carSearchFrame.setEnabled(false);
				CarWashApp.carUpdateFrame.setVisible(true);
			}
		});
		btnSearch.setBounds(136, 104, 111, 23);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(new Color(210, 105, 30));
		panel_1.setBounds(10, 162, 414, 69);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsert = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.carInsertFrame.setVisible(true);
				CarWashApp.carSearchFrame.setEnabled(false);
			}
		});
		btnInsert.setBounds(144, 11, 104, 47);
		panel_1.add(btnInsert);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CarWashApp.mainFrame.setEnabled(true);
			    CarWashApp.carSearchFrame.setVisible(false);
			}
		});
		btnClose.setBounds(335, 238, 89, 23);
		contentPane.add(btnClose);
	}
	public String getCarLisencePlate() {
		return searchLisencePlateVar;
	}
	
	public void setCarLisencePlate(String searchEpwnymo) {
		this.searchLisencePlateVar = searchLisencePlateVar;
	}
}
