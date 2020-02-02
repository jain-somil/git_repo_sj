package parking_lot.operations;

import java.util.HashMap;

import parking_lot.model.ParkingSlot;

public class ParkingOperations {
	
	public static Object[] createParkingSlots(String numSlots) {
		int noOfSlots = Integer.parseInt(numSlots);
		ParkingSlot[] slotsArray = new ParkingSlot[noOfSlots];
		HashMap<String, Integer> slotsMap = new HashMap<String, Integer>(noOfSlots);
		Object[] result = new Object[2];
		for(int i=0; i<noOfSlots; i++) {
			slotsArray[i] = null;
		}
		
		result[0] = slotsArray;
		result[1] = slotsMap;
		
		System.out.printf("Created a parking lot with %s slots", numSlots);
		return result;
	}
	
	public static Object[] parkCar(Object[] parkingLot, String registrationNumber, String colour) {
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		if(slotsArray == null) {
			parkingLot = createParkingSlots("50");
			slotsArray = (ParkingSlot[])parkingLot[0];
		}
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> slotsMap = (HashMap<String, Integer>)parkingLot[1];
		boolean carParked = false;
		for(int i=0; i<slotsArray.length; i++) {
			if(slotsArray[i] == null) {
				slotsArray[i] = new ParkingSlot(registrationNumber, colour);
				slotsMap.put(registrationNumber, (i+1));
				System.out.printf("Allocated slot number: %d", (i+1));
				carParked = true;
			}
		}
		if(!carParked)
			System.out.printf("Sorry, parking lot is full");
		
		parkingLot[0] = slotsArray;
		parkingLot[1] = slotsMap;
		
		return parkingLot;
	}
	
	public static Object[] leaveCar(Object[] parkingLot, String slotNumber) {
		int parkingSlot = Integer.parseInt(slotNumber) - 1;
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		if(slotsArray == null) {
			parkingLot = createParkingSlots("50");
			slotsArray = (ParkingSlot[])parkingLot[0];
		}
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> slotsMap = (HashMap<String, Integer>)parkingLot[1];
		
		if(parkingSlot < slotsArray.length) {
			if(slotsArray[parkingSlot].getRegistrationNumber() != null) {
				slotsMap.remove(slotsArray[parkingSlot].getRegistrationNumber());
				slotsArray[parkingSlot] = null;
				System.out.printf("Slot number %s is free", slotNumber);
			}else {
				System.out.printf("Slot number %s is free", slotNumber);
			}
			
		}else {
			System.out.printf("Sorry, invalid parking lot number. Allowed max value is %d", slotsArray.length);
		}
		
		parkingLot[0] = slotsArray;
		parkingLot[1] = slotsMap;
		
		return parkingLot;
	}

}
