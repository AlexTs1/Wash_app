package alex.CarWashProject.service.exceptions;
import alex.CarWashProject.model.Car;

public class CarNotFoundException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public CarNotFoundException(Car car) {
		super("Car with id = " + car.getId() + " already exist");
	}
	
}
