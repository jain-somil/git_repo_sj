package parking_lot.operations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import parking_lot.model.ParkingSlot;

public class DisplayOperations {
	
	public static Object[] getStatus(Object[] parkingLot) {
		if(parkingLot == null) {
			parkingLot = ParkingOperations.createParkingSlots("50");
		}
		
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		
		System.out.printf("%s\t%s\t%s\n", "Slot No.", "Registration No", "Colour");
		for(int i=0; i<slotsArray.length; i++) {
			if(slotsArray[i] != null)
				System.out.printf("%d\t%s\n", (i+1), slotsArray[i].toString());
		}
		
		return parkingLot;
	}
	
	public static Object[] getRegistrationNumberWithColour(Object[] parkingLot, String colour) {
		if(parkingLot == null) {
			parkingLot = ParkingOperations.createParkingSlots("50");
		}
		
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		
		List<String> filtered = Arrays.stream(slotsArray)
				.filter(pS -> pS != null &&
					pS.getColour().equals(colour))
				.map(pS -> pS.getRegistrationNumber())
				.collect(Collectors.toList());
				
				System.out.println(filtered);
		
		return parkingLot;
	}
	
	public static Object[] getParkingSlotWithColour(Object[] parkingLot, String colour) {
		if(parkingLot == null) {
			parkingLot = ParkingOperations.createParkingSlots("50");
		}
		
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		
		List<Integer> filteredIndex = IntStream.range(0, slotsArray.length)
				.filter(i -> slotsArray[i] != null && slotsArray[i].getColour().equals("White"))
				.mapToObj(i -> i+1)
				.collect(Collectors.toList());
		
		System.out.println(filteredIndex);
		
		return parkingLot;
	}
	
	public static Object[] getParkingSlotWithRegistrationNumber(Object[] parkingLot, String registrationNumber) {
		if(parkingLot == null) {
			parkingLot = ParkingOperations.createParkingSlots("50");
		}
		
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> slotsMap = (HashMap<String, Integer>) parkingLot[1];
		if(slotsMap.containsKey(registrationNumber))
			System.out.println(slotsMap.get(registrationNumber));
		else {
			System.out.println("Not Found");
		}
		
		return parkingLot;
	}

}
