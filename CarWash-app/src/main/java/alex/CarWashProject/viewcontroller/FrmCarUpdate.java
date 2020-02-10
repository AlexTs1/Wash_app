package alex.CarWashProject.viewcontroller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alex.CarWashProject.dao.CarDAOImpl;
import alex.CarWashProject.dao.ICarWashDAO;
import alex.CarWashProject.dto.CarDTO;
import alex.CarWashProject.model.Car;
import alex.CarWashProject.service.CarServiceImpl;
import alex.CarWashProject.service.ICarService;
import alex.CarWashProject.service.exceptions.CarNotFoundException;
import alex.CarWashProject.viewcontroller.CarWashApp;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmCarUpdate extends JFrame {

	/**
	 * 
	 */
	private List<Car> cars;
	private int listPosition, listSize;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_LisencePlate;
	private JTextField txt_Make;
	private JTextField txt_Model;
	private JTextField txt_Year;
	private JButton btn_delete;
	private JButton btnUpdate;
	private JButton btnClose;
	private JButton btnFirst;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnLast;
	
	PreparedStatement pst;
	ResultSet rs;
	private ICarWashDAO carDAO = new CarDAOImpl();
	private ICarService carService = new CarServiceImpl(carDAO);

	private CarDTO oldCarDTO = new CarDTO();
	private CarDTO newCarDTO = new CarDTO();
	private JTextField txt_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCarUpdate frame = new FrmCarUpdate();
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
	public FrmCarUpdate() {
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowActivated(WindowEvent e) {
				try{
					cars =  carService.getCarsByLisencePlate(CarWashApp.carSearchFrame.getCarLisencePlate());
					
					
					if (cars != null)
				    {
						listPosition = 0;
						listSize = cars.size();
						
						
				        
				        txt_id.setText(String.format("%s", cars.get(0).getId()));
						txt_LisencePlate.setText(cars.get(0).getLisencePlate());
						txt_Make.setText(cars.get(0).getMake());
						txt_Model.setText(cars.get(0).getModel());
						txt_Year.setText(String.format("%s",cars.get(0).getYear()));
				        
				    } else {
				    	JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές", "Empty Search", JOptionPane.PLAIN_MESSAGE);
				    	CarWashApp.carSearchFrame.setEnabled(true);
				    	CarWashApp.carUpdateFrame.setVisible(false);
				    }
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
				
				});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_LisencePlate = new JLabel("\u03A0\u03B9\u03BD\u03B1\u03BA\u03AF\u03B4\u03B1");
		lbl_LisencePlate.setBounds(10, 48, 46, 14);
		contentPane.add(lbl_LisencePlate);
		
		JLabel lbl_Make = new JLabel("\u039C\u03AC\u03C1\u03BA\u03B1");
		lbl_Make.setBounds(10, 79, 46, 14);
		contentPane.add(lbl_Make);
		
		JLabel lbl_Model = new JLabel("\u039C\u03BF\u03BD\u03C4\u03AD\u03BB\u03BF");
		lbl_Model.setBounds(10, 110, 46, 14);
		contentPane.add(lbl_Model);
		
		JLabel lbl_Year = new JLabel("\u0388\u03C4\u03BF\u03C2");
		lbl_Year.setBounds(10, 135, 46, 14);
		contentPane.add(lbl_Year);
		
		txt_LisencePlate = new JTextField();
		txt_LisencePlate.setBounds(86, 45, 86, 20);
		contentPane.add(txt_LisencePlate);
		txt_LisencePlate.setColumns(10);
		
		txt_Make = new JTextField();
		txt_Make.setBounds(86, 76, 86, 20);
		contentPane.add(txt_Make);
		txt_Make.setColumns(10);
		
		txt_Model = new JTextField();
		txt_Model.setBounds(86, 107, 86, 20);
		contentPane.add(txt_Model);
		txt_Model.setColumns(10);
		
		txt_Year = new JTextField();
		txt_Year.setBounds(86, 132, 86, 20);
		contentPane.add(txt_Year);
		txt_Year.setColumns(10);
		

		txt_id = new JTextField();
		txt_id.setBounds(23, 14, 86, 20);
		txt_id.setVisible(false);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7 \u039F\u03C7\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(122, 11, 165, 23);
		contentPane.add(lblNewLabel);
		
		btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CarDTO carToDelete = new CarDTO();
					carToDelete.setId(Integer.parseInt(txt_id.getText()));
					carService.deleteCar(carToDelete);	
				}
				catch (SQLException e6){
					e6.printStackTrace();
				} catch (CarNotFoundException e1) {	
					e1.printStackTrace();
				}
			}
		});
		btn_delete.setBounds(10, 227, 89, 23);
		contentPane.add(btn_delete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					oldCarDTO.setId(Integer.parseInt(txt_id.getText()));
				      
				    newCarDTO.setId(Integer.parseInt(txt_id.getText()));
				    newCarDTO.setLisencePlate(txt_LisencePlate.getText());
				    newCarDTO.setMake(txt_Make.getText());
				    newCarDTO.setModel(txt_Model.getText());
				    newCarDTO.setYear(txt_Year.getText());
				      
				    carService.updateCar(oldCarDTO, newCarDTO);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} catch (CarNotFoundException e1) {
					System.out.println(e1.getMessage());
				}	
				
			}
		});
		btnUpdate.setBounds(184, 227, 89, 23);
		contentPane.add(btnUpdate);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.carSearchFrame.setEnabled(true);
				CarWashApp.carUpdateFrame.setVisible(false);
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPane.add(btnClose);
		
		btnFirst = new JButton("");
		Image btnF = new ImageIcon(this.getClass().getResource("/First record.png")).getImage();
		btnFirst.setIcon(new ImageIcon(btnF));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_id.setText(String.format("%s", cars.get(0).getId()));
				txt_LisencePlate.setText(String.format("%s", cars.get(0).getLisencePlate()));
				txt_Make.setText(cars.get(0).getMake());
				txt_Model.setText(cars.get(0).getModel());
				txt_Year.setText(String.format("%s",cars.get(0).getYear()));
				
			}
		});
		btnFirst.setBounds(62, 179, 52, 23);
		contentPane.add(btnFirst);
		
		btnPrev = new JButton("");
		Image btnP = new ImageIcon(this.getClass().getResource("/Previous_record.png")).getImage();
		btnPrev.setIcon(new ImageIcon(btnP));
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPosition >= 1) {
					listPosition--;
					txt_id.setText(String.format("%s", cars.get(listPosition).getId()));
					txt_LisencePlate.setText(String.format("%s", cars.get(listPosition).getLisencePlate()));
					txt_Make.setText(cars.get(listPosition).getMake());
					txt_Model.setText(cars.get(listPosition).getModel());
					txt_Year.setText(String.format("%s", cars.get(listPosition).getYear()));
				}
			}
		});
		btnPrev.setBounds(122, 179, 52, 23);
		contentPane.add(btnPrev);
		
		btnNext = new JButton("");
		Image btnN = new ImageIcon(this.getClass().getResource("/Next_track.png")).getImage();
		btnNext.setIcon(new ImageIcon(btnN));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPosition <= cars.size() - 2) {
					listPosition++;
					txt_id.setText(String.format("%s", cars.get(listPosition).getId()));
					txt_LisencePlate.setText(String.format("%s", cars.get(listPosition).getLisencePlate()));
					txt_Make.setText(cars.get(listPosition).getMake());
					txt_Model.setText(cars.get(listPosition).getModel());
					txt_Year.setText(String.format("%s", cars.get(listPosition).getYear()));
				}
			}
		});
		btnNext.setBounds(184, 179, 52, 23);
		contentPane.add(btnNext);
		
		btnLast = new JButton("");
		Image btnL = new ImageIcon(this.getClass().getResource("/Last_Record.png")).getImage();
		btnLast.setIcon(new ImageIcon(btnL));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listPosition = listSize - 1;
				txt_id.setText(String.format("%s", cars.get(listPosition).getId()));
				txt_LisencePlate.setText(String.format("%s", cars.get(listPosition).getLisencePlate()));
				txt_Make.setText(cars.get(listPosition).getMake());
				txt_Model.setText(cars.get(listPosition).getModel());
				txt_Year.setText(String.format("%s", cars.get(listPosition).getYear()));
			}
		});
		btnLast.setBounds(246, 179, 52, 23);
		contentPane.add(btnLast);
		
	}

}
