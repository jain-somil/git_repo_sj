package parking_lot.operations;

public class OperationsController {
	
	public static Object[] performOperation(Object[] parkingLot, String operation, String...args) {
		
		switch(operation) {
			case "create_parking_lot": return ParkingOperations.createParkingSlots(args[0]);
			case "park": return ParkingOperations.parkCar(parkingLot, args[0], args[1]);
			case "leave": return ParkingOperations.leaveCar(parkingLot, args[0]);
			case "status": return DisplayOperations.getStatus(parkingLot);
			case "registration_numbers_for_cars_with_colour":
			case "slot_numbers_for_cars_with_colour":
			case "slot_number_for_registration_number":
			default: System.out.println("Not a valid operation");
		}
		
		
		return parkingLot;
		
	}
	
	

}
