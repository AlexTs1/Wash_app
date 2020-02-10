package alex.CarWashProject.service.exceptions;
import alex.CarWashProject.model.Car;

public class CarIdAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CarIdAlreadyExistsException(Car car) {
		super("Car with id = " + car.getId() + " already exist");
	}
}

