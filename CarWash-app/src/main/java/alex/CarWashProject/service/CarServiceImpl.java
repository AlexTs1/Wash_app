package alex.CarWashProject.service;

import java.sql.SQLException;
import java.util.List;
import alex.CarWashProject.dao.*;
import alex.CarWashProject.dto.CarDTO;
import alex.CarWashProject.model.Car;
import alex.CarWashProject.service.exceptions.CarIdAlreadyExistsException;
import alex.CarWashProject.service.exceptions.CarNotFoundException;


public class CarServiceImpl implements ICarService {
	
	private final ICarWashDAO carDAO;
	
	public CarServiceImpl(ICarWashDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	@Override
	public void insertCar(CarDTO carDTO) 
			throws CarIdAlreadyExistsException, SQLException {
		
		Car newCar = new Car();
		newCar.setId(carDTO.getId());
		newCar.setLisencePlate(carDTO.getLisencePlate());
		newCar.setMake(carDTO.getMake());	
		newCar.setModel(carDTO.getModel());	
		newCar.setYear(carDTO.getYear());	
		newCar.setTotalPrice(carDTO.getTotalPrice());
		newCar.setDescription(carDTO.getDescription());
		
		if ((carDAO.getCarById(newCar.getId())) == null) 
			carDAO.insert(newCar);
		else {
			throw new CarIdAlreadyExistsException(newCar);
		}
	}
	
	@Override
	public void deleteCar(CarDTO carDTO) throws CarNotFoundException, SQLException {
		Car carToDelete = new Car();
		carToDelete.setId(carDTO.getId());
		
		if ((carDAO.getCarById(carToDelete.getId())) == null) 
			throw new CarNotFoundException(carToDelete);
		carDAO.delete(carToDelete);
		
	}
	
	@Override
	public void updateCar(CarDTO oldCarDTO, CarDTO newCarDTO) throws CarNotFoundException, SQLException {
		Car carToUpdate = new Car();
		carToUpdate.setId(oldCarDTO.getId());
		
		Car newCar = new Car();
		newCar.setId(newCarDTO.getId());
		newCar.setLisencePlate(newCarDTO.getLisencePlate());
		newCar.setMake(newCarDTO.getMake());	
		newCar.setModel(newCarDTO.getModel());	
		newCar.setYear(newCarDTO.getYear());
		
		if ((carDAO.getCarById(carToUpdate.getId())) == null) 
			throw new CarNotFoundException(carToUpdate);
		carDAO.update(carToUpdate, newCar);
		
	}
	
	@Override
	public List<Car> getCarsByLisencePlate(String lisencePlate) throws SQLException {	
		return carDAO.getCarByLisencePlate(lisencePlate);
	}
	
	@Override
	public List<Car> getAll() throws SQLException {	
		return carDAO.GetAllCars();
	}
	
	
}
