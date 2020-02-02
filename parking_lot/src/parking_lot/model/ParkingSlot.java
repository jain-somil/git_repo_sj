package parking_lot.model;

public class ParkingSlot {
	
	String registrationNumber;
	String colour;
	
	public ParkingSlot(String registrationNumber, String colour) {
		super();
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [registrationNumber=" + registrationNumber + ", colour=" + colour + "]";
	}
	

}
