package alex.CarWashProject.viewcontroller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import alex.CarWashProject.dao.CarDAOImpl;
import alex.CarWashProject.dao.ICarWashDAO;
import alex.CarWashProject.model.Car;
import alex.CarWashProject.service.CarServiceImpl;
import alex.CarWashProject.service.ICarService;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmHistory extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Car> AllCars;
	private ICarWashDAO carDAO = new CarDAOImpl();
	private ICarService carService = new CarServiceImpl(carDAO);
	private JPanel contentPane;
	private JTable table1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHistory frame = new FrmHistory();
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
	public FrmHistory() {
		addWindowListener(new WindowAdapter() {
			@Override
				public void windowActivated(WindowEvent e) {
				try {
					AllCars = carService.getAll();
					if (AllCars != null)
				    {
						Object[] columnNames = {"LisencePlate", "Make", "Model", "Year","TotalPrice","Description"};
						DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
						        for (int i=0; i<AllCars.size(); i++) {
						            Object[] o = new Object[7];
						            o[0] = AllCars.get(i).getLisencePlate();
						            o[1] = AllCars.get(i).getMake();
						            o[2] = AllCars.get(i).getModel();
						            o[3] = AllCars.get(i).getYear();
						            o[4] = AllCars.get(i).getTotalPrice();
						            o[5] = AllCars.get(i).getDescription();
						          
						            
						            model.addRow(o);
						        }
						        
						        table1.setModel(model);
						        
						
						
					}
					else {
				    	JOptionPane.showMessageDialog(null, "Δεν υπάρχουν εγγραφές", "Empty Search", JOptionPane.PLAIN_MESSAGE);
					
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
		
		new JTable();
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 205);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarWashApp.mainFrame.setEnabled(true);
				CarWashApp.carsHistory.setVisible(false);
			}
		});
		btnClose.setBounds(162, 227, 89, 23);
		contentPane.add(btnClose);
	}
}
