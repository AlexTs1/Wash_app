package alex.CarWashProject.dao;

import static alex.CarWashProject.dao.dbutil.DBUtil.closeConnection;
import static alex.CarWashProject.dao.dbutil.DBUtil.openConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import alex.CarWashProject.model.Car;



public class CarDAOImpl implements ICarWashDAO{
	
	
	
	@Override
	public void insert(Car car) throws SQLException {
		String sql = "INSERT INTO VEHICLES (LisencePlate,Make,Model,Year,TotalPrice,Description) VALUES"
				+ " ('" + car.getLisencePlate() + "', '" + car.getMake() + "','" + car.getModel() + "','" + car.getYear() + "','" + car.getTotalPrice() +"','"+ car.getDescription() +"')";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		int n = pst.executeUpdate(sql);
		
		JOptionPane.showMessageDialog(null, n + " Record inserted.", "INSERT", 
				JOptionPane.PLAIN_MESSAGE);
		
		pst.close();
		closeConnection();
	}
	
	@Override
	public void delete(Car car) throws SQLException {
		String sql = "DELETE FROM VEHICLES WHERE VehiclesId = " + car.getId();
		int dialogButton;
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		
        dialogButton = JOptionPane.showConfirmDialog (null, "Είστε σίγουρος;", 
      		  "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogButton == JOptionPane.YES_OPTION){
      	  int numberOfRowsAffected = pst.executeUpdate();
      	  JOptionPane.showMessageDialog (null, numberOfRowsAffected + " rows deleted successfully", 
          		  "DELETE", JOptionPane.INFORMATION_MESSAGE);
        } else {
        	return;
        }
      	pst.close();
      	closeConnection();
	}
	
	@Override
	public void update(Car oldCar, Car newCar) throws SQLException {
		String sql = "UPDATE VEHICLES SET LisencePlate = '" + newCar.getLisencePlate() + "', " + "Make = '" + newCar.getMake() + "', " + "Model = '" + newCar.getModel() + "', " + "Year = '" + newCar.getYear()
				+ "' WHERE VehiclesId = " + oldCar.getId();
		System.out.println(sql);
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		int numberOfRowsAffected = pst.executeUpdate();
	      
	      JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", 
	    		  "UPDATE", JOptionPane.PLAIN_MESSAGE);
		  pst.close();
		  closeConnection();
	}

	@Override
	public List<Car> getCarByLisencePlate(String lisencePlate) throws SQLException {
		String sql = "SELECT VehiclesId, LisencePlate, Make, Model, Year FROM VEHICLES WHERE LisencePlate LIKE " + "'%" + lisencePlate + "%'";
		
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    List<Car> cars = new ArrayList<>();
	    
	    rs.beforeFirst();
	    while (rs.next()) {
	    	Car car = new Car();
		    	
	    	car.setId(rs.getInt("VehiclesId"));
	    	car.setLisencePlate(rs.getString("LisencePlate"));
	    	car.setMake(rs.getString("Make"));
	    	car.setModel(rs.getString("Model"));
	    	car.setYear(rs.getString("Year"));
	    	cars.add(car); 	
	    }
	    
	    closeConnection();
	    return cars;
	}
	
	@Override
	public Car getCarById(int id) throws SQLException {
		String sql = "SELECT * FROM Vehicles WHERE VehiclesId = " + id;
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    Car car = new Car();
	    if (rs.next()) {
	    	car.setId(rs.getInt("VehiclesId"));
	    	car.setLisencePlate(rs.getString("LisencePlate"));
	    	car.setMake(rs.getString("Make"));
	    	car.setModel(rs.getString("Model"));
	    	car.setYear(rs.getString("Year"));
	    	return car;
	    }
	    
	    return null;
	}	

	@Override
	public List<Car> GetAllCars() throws SQLException{
     String sql = "SELECT * FROM Vehicles ORDER BY Wash_Date";
		
	    PreparedStatement pst =  openConnection().prepareStatement(sql);
	    ResultSet rs = pst.executeQuery(sql);
	    
	    List<Car> AllCars = new ArrayList<>();
	    
	   
	    while (rs.next()) {
	    	Car car = new Car();
		    	
	    	car.setId(rs.getInt("VehiclesId"));
	    	car.setLisencePlate(rs.getString("LisencePlate"));
	    	car.setMake(rs.getString("Make"));
	    	car.setModel(rs.getString("Model"));
	    	car.setYear(rs.getString("Year"));
	    	car.setTotalPrice(rs.getString("TotalPrice"));
	    	car.setDescription(rs.getString("Description"));
	    	
	    	AllCars.add(car); 	
	    }
	    
	    closeConnection();
		return AllCars;
	}	
}
