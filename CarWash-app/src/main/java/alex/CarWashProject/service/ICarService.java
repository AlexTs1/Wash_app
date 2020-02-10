package alex.CarWashProject.service;

import java.sql.SQLException;
import java.util.List;

import alex.CarWashProject.dto.CarDTO;
import alex.CarWashProject.model.Car;
import alex.CarWashProject.service.exceptions.CarIdAlreadyExistsException;
import alex.CarWashProject.service.exceptions.CarNotFoundException;

public interface ICarService {
	
	/**
	 * Inserts a {@link Car} based on the data carried by the
	 * {@link CarDTO}.
	 * 
	 * @param CarDTO 
	 * 			DTO object that contains the data.
	 * @throws CarIdAlreadyExistsException
	 * 			if any Car identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	void insertCar(CarDTO carDTO) 
			throws CarIdAlreadyExistsException, SQLException;
	
	/**
	 * Deletes a {@link Car} based on the data carried by the
	 * {@link CarDTO}.
	 * 
	 * @param CarDTO 
	 * 			DTO object that contains the data.
	 * @throws CarIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	
	void deleteCar(CarDTO carDTO)
			throws CarNotFoundException,SQLException;
	
	
	/**
	 * Updates a {@link Car} based on the data carried by the
	 * {@link CarDTO}.
	 * 
	 * @param oldCarDTO
	 * 			DTO object that contains the data -mainly the id-
	 * 			of the {@link Car} that will be updated.  
	 * @param newCarrDTO
	 * 			DTO object that contains the data of the 
	 * 			new {@link Car}.
	 * @throws CarNotFoundException
	 * 			if any Car identified by their id 
	 * 			was not found. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	void updateCar(CarDTO oldCarDTO, CarDTO newCarDTO) 
			throws CarNotFoundException,SQLException;
	
	
	
	/**
	 * Searches and gets back to the caller a list
	 * of the {@link Car} objects identified by
	 * by their LisencePlate or LisencePlate's initial letters.
	 * 
	 * @param LisencePlate
	 * 			a String object that contains the
	 * 			LisencePlate or the letters that the 
	 * 			LisencePlate contains, of the {@link Car}
	 * 			objects we are looking for. 
	 * @return
	 * 			a List that contains the results of
	 * 			the search, that is a List of {@link Car}
	 * 			objects. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
	List<Car> getCarsByLisencePlate(String lisencePlate) 
			throws SQLException;
	
	List<Car> getAll() 
			throws SQLException;

}
