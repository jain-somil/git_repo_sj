package parking_lot.model;

public class ParkingSlot {
	
	String registrationNumber;
	String color;
	
	public ParkingSlot(String registrationNumber, String color) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [registrationNumber=" + registrationNumber + ", color=" + color + "]";
	}
	

}
