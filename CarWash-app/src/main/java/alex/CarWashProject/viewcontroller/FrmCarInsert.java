package alex.CarWashProject.viewcontroller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import alex.CarWashProject.dao.ICarWashDAO;
import alex.CarWashProject.dao.CarDAOImpl;
import alex.CarWashProject.dto.CarDTO;
import alex.CarWashProject.service.ICarService;
import alex.CarWashProject.service.CarServiceImpl;
import alex.CarWashProject.service.exceptions.CarIdAlreadyExistsException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class FrmCarInsert extends JFrame {

	private static final long serialVersionUID = 1L;

	private ICarWashDAO carDAO = new CarDAOImpl();
	private ICarService carService = new CarServiceImpl(carDAO);
	
	private JPanel contentPane;
	private JTextField txt_Make;
	private JTextField txt_Model;
	private JTextField txt_Year;
	private JLabel label;
	private JTextField txt_LisencePlate;
	private JButton btnClose;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txt_Comments;
	private JRadioButton rdbtn_InOut;
	private JRadioButton rdbtn_ker;
	private JRadioButton rdbtn_In;
	private JRadioButton rdbtn_Out;
	private JLabel lblNewLabel_7;
	private JTextField txt_price;
	private JLabel lblNewLabel_8;
	private JLabel show_val;
	int extra;
	int TotalPrice;
	int finalP = 0;
	private JTextField txt_extra;

	/**
	 * Launch the application.
	private JTextField txt_Year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCarInsert frame = new FrmCarInsert();
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
	public FrmCarInsert() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//txt_id.setText("");
				txt_LisencePlate.setText("");
				txt_Make.setText("");
				txt_Model.setText("");
				txt_Year.setText("");
				txt_price.setText("");
				txt_Comments.setText("");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( txt_LisencePlate.getText().trim().length() == 0 ) {
					lblNewLabel_3.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "LisencePlate field is required", 
							"Error", JOptionPane.WARNING_MESSAGE);
				
					
					
				}
				else if(txt_Year.getText().trim().length() > 4 ){
					JOptionPane.showMessageDialog(null, "Year field must contain 4 numbers", 
							"Error", JOptionPane.WARNING_MESSAGE);
					
				}
				
				else {
			try {
				CarDTO carDTO = new CarDTO();
				//carDTO.setId(Integer.parseInt(txt_id.getText()));
				
				carDTO.setLisencePlate(txt_LisencePlate.getText());
				carDTO.setMake(txt_Make.getText());
				carDTO.setModel(txt_Model.getText());
				
				carDTO.setYear(txt_Year.getText());
				carDTO.setTotalPrice(txt_price.getText());
				carDTO.setDescription(txt_Comments.getText());
				
				
				carService.insertCar(carDTO);		
				
			} catch (SQLException  e1) {		
				JOptionPane.showMessageDialog(null, "Error. Please try again", 
						"Error", JOptionPane.WARNING_MESSAGE);
				initFields();
			  } catch ( CarIdAlreadyExistsException e2) {
				  JOptionPane.showMessageDialog(null, "Inalid Key for Car ID, Please try again", 
						  "Error", JOptionPane.WARNING_MESSAGE);
				  initFields(); 
			  }
		
			}
			}
		});
		
		
		btnInsert.setBounds(113, 369, 86, 29);
		contentPane.add(btnInsert);
		
		txt_Make = new JTextField();
		txt_Make.setBounds(10, 52, 86, 20);
		contentPane.add(txt_Make);
		txt_Make.setColumns(10);
		
		txt_Model = new JTextField();
		txt_Model.setBounds(168, 52, 86, 20);
		contentPane.add(txt_Model);
		txt_Model.setColumns(10);
		
		label = new JLabel("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03BD\u03AD\u03BF\u03C5 \u03B1\u03C5\u03C4\u03BF\u03BA\u03B9\u03BD\u03AE\u03C4\u03BF\u03C5");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(113, 11, 196, 17);
		contentPane.add(label);
		
		txt_LisencePlate = new JTextField();
		txt_LisencePlate.setBounds(112, 96, 208, 20);
		contentPane.add(txt_LisencePlate);
		txt_LisencePlate.setColumns(10);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.mainFrame.setEnabled(true);
				CarWashApp.carInsertFrame.setVisible(false);
			}
		});
		btnClose.setBounds(220, 369, 89, 29);
		contentPane.add(btnClose);
		
		lblNewLabel = new JLabel("\u039C\u03AC\u03C1\u03BA\u03B1");
		lblNewLabel.setBounds(26, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u039C\u03BF\u03BD\u03C4\u03AD\u03BB\u03BF");
		lblNewLabel_1.setBounds(190, 36, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u0388\u03C4\u03BF\u03C2");
		lblNewLabel_2.setBounds(366, 36, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B9\u03BD\u03B1\u03BA\u03AF\u03B4\u03B1\u03C2");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_3.setBackground(Color.RED);
		lblNewLabel_3.setBounds(168, 83, 101, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u03A4\u03CD\u03C0\u03BF\u03C2 \u03C0\u03BB\u03C5\u03C3\u03AF\u03BC\u03B1\u03C4\u03BF\u03C2:");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(10, 172, 111, 14);
		contentPane.add(lblNewLabel_4);
		
		rdbtn_InOut = new JRadioButton("\u039C\u03AD\u03C3\u03B1-\u03AD\u03BE\u03C9");
		rdbtn_InOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtn_InOut.isSelected()) {
					rdbtn_In.setSelected(false);
					rdbtn_Out.setSelected(false);
					
				}
			}
		});
		rdbtn_InOut.setBounds(127, 148, 109, 23);
		contentPane.add(rdbtn_InOut);
		
		rdbtn_In = new JRadioButton("\u039C\u03CC\u03BD\u03BF \u03BC\u03AD\u03C3\u03B1");
		rdbtn_In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtn_In.isSelected()) {
					rdbtn_InOut.setSelected(false);
					rdbtn_Out.setSelected(false);
				
				}
			
				
			}
		});
		rdbtn_In.setBounds(127, 183, 109, 23);
		contentPane.add(rdbtn_In);
		
		rdbtn_ker = new JRadioButton("\u039A\u03AD\u03C1\u03C9\u03BC\u03B1");
		rdbtn_ker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(rdbtn_ker.isSelected()) {
					
					
				}
				
			}
		});
		rdbtn_ker.setBounds(253, 148, 109, 23);
		contentPane.add(rdbtn_ker);
		
		rdbtn_Out = new JRadioButton("\u039C\u03CC\u03BD\u03BF \u03AD\u03BE\u03C9");
		rdbtn_Out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtn_Out.isSelected()) {
					rdbtn_InOut.setSelected(false);
					rdbtn_In.setSelected(false);
					
					
				}
              
			}
		});
		rdbtn_Out.setBounds(253, 183, 109, 23);
		contentPane.add(rdbtn_Out);
		
		JLabel lblNewLabel_5 = new JLabel("\u0395\u03C0\u03B9\u03C0\u03BB\u03AD\u03BF\u03BD \u03C3\u03C7\u03CC\u03BB\u03B9\u03B1-\u03A0\u03B1\u03C1\u03B1\u03C4\u03B7\u03C1\u03AE\u03C3\u03B5\u03B9\u03C2");
		lblNewLabel_5.setBounds(10, 235, 155, 14);
		contentPane.add(lblNewLabel_5);
		
		txt_Comments = new JTextField();
		txt_Comments.setBounds(168, 232, 256, 20);
		contentPane.add(txt_Comments);
		txt_Comments.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u0395\u03C0\u03B9\u03C0\u03BB\u03AD\u03BF\u03BD \u03C7\u03C1\u03AD\u03C9\u03C3\u03B7");
		lblNewLabel_6.setBounds(10, 273, 106, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u03A4\u03B5\u03BB\u03B9\u03BA\u03AE \u03C4\u03B9\u03BC\u03AE");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 340, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		txt_price = new JTextField();
		
		txt_price.setBounds(112, 338, 33, 20);
		contentPane.add(txt_price);
		txt_price.setColumns(10);
		
		lblNewLabel_8 = new JLabel("\u20AC");
		lblNewLabel_8.setBounds(150, 341, 15, 14);
		contentPane.add(lblNewLabel_8);
		
		if(rdbtn_ker.isSelected() && rdbtn_Out.isSelected()) {
			
			TotalPrice = 12;
			
			
			
			}
			
	
	
	if(rdbtn_ker.isSelected() && rdbtn_InOut.isSelected()) {
		
		TotalPrice = 16;
		
		
		
		}
	String s = String.valueOf(TotalPrice);
	txt_price.setText(s);
	
	JButton btnCheck = new JButton("Check");
	btnCheck.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
            if(rdbtn_ker.isSelected() && rdbtn_Out.isSelected()) {
				
				TotalPrice = 12;						
				}

            else if(rdbtn_ker.isSelected() && rdbtn_In.isSelected()){
	            TotalPrice = 12;	
	
                 }
						
			else if(rdbtn_ker.isSelected() && rdbtn_InOut.isSelected()) {
			
			TotalPrice = 16;				
			}
			else if(rdbtn_ker.isSelected()) {
				TotalPrice = 4;	
				
			}
			else if(rdbtn_InOut.isSelected()) {
				TotalPrice = 12;	
			}
			else if(rdbtn_Out.isSelected() || rdbtn_In.isSelected()) {
				
				TotalPrice = 7;						
				}
			else {
				TotalPrice = 0;
			}
            finalP = TotalPrice;
            
            if (txt_extra.getText() == null || txt_extra.getText().trim().isEmpty() || txt_extra.getText().trim().equals("")) {
            	
            	extra = 0;
            }
            else {
            	
            	extra = Integer.parseInt(txt_extra.getText());
            	
            }
		finalP = TotalPrice +extra;
		String s = String.valueOf(finalP);
		txt_price.setText(s);	
		}
	});
	btnCheck.setBackground(Color.RED);
	btnCheck.setForeground(Color.BLACK);
	btnCheck.setBounds(165, 301, 89, 23);
	contentPane.add(btnCheck);
	
	txt_extra = new JTextField();
	txt_extra.setBounds(120, 270, 86, 20);
	contentPane.add(txt_extra);
	
	btnCheck.setBounds(165, 301, 89, 23);
	contentPane.add(btnCheck);
	
	show_val = new JLabel("");
	show_val.setForeground(Color.RED);
	show_val.setBounds(314, 71, 60, 14);
	contentPane.add(show_val);
	
	txt_Year = new JTextField();

	txt_Year.addKeyListener(new java.awt.event.KeyAdapter() {

        public void keyReleased(java.awt.event.KeyEvent evt) {
            try {
                long number = Long.parseLong(txt_Year.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Only Numbers Allowed");
                show_val.setText("Only Numbers ");
                txt_Year.setText("");
            }
            if ( txt_Year.getText().trim().length() >4) {
            	JOptionPane.showMessageDialog(rootPane, "Only 4-digits Numbers Allowed");
                show_val.setText("Only 4-digits");
            }
           
        }
        public void keyTyped(KeyEvent e) {
            if (txt_Year.getText().length() >= 4 ) // limit to 4 characters
                e.consume();
        }
  
    });
	
	
	txt_Year.setBounds(338, 52, 86, 20);
	contentPane.add(txt_Year);
	
	show_val.setBounds(339, 71, 110, 14);
	contentPane.add(show_val);
	
	contentPane.add(txt_extra);
	
	btnCheck.setBounds(165, 301, 89, 23);
	contentPane.add(btnCheck);
	}
		
	
	
	
	private void initFields() {
		txt_LisencePlate.setText("");
		txt_Make.setText("");
		txt_Model.setText("");
		txt_Year.setText("");
		
		
	}
}
