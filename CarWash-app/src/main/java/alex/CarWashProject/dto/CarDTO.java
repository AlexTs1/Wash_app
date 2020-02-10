package alex.CarWashProject.dto;

public class CarDTO {

	private int id;
	private String lisencePlate;
	private String make;
	private String model;
	private String year;
	private String totalPrice;
	
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	
	public CarDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLisencePlate() {
		return lisencePlate;
	}
	public void setLisencePlate(String lisencePlate) {
		this.lisencePlate = lisencePlate;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public CarDTO(int id, String lisencePlate, String make, String model, String year, String totalPrice, String description) {
		super();
		this.id = id;
		this.lisencePlate = lisencePlate;
		this.make = make;
		this.model = model;
		this.year = year;
		this.totalPrice = totalPrice;
		this.description = description;
	}
	
	
	
	
}
