package alex.CarWashProject.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import alex.CarWashProject.model.Car;

public interface ICarWashDAO {
	
	void insert(Car car) throws SQLException;
	void delete(Car car) throws SQLException;
	void update(Car oldCar, Car newCar) throws SQLException;
	List<Car> getCarByLisencePlate (String lisencePlate) throws SQLException;
	Car getCarById (int id) throws SQLException;

	List<Car> GetAllCars() throws SQLException;
	


}



