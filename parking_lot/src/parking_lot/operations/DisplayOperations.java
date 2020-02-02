package parking_lot.operations;

import parking_lot.model.ParkingSlot;

public class DisplayOperations {
	
	public static Object[] getStatus(Object[] parkingLot) {
		ParkingSlot[] slotsArray = (ParkingSlot[])parkingLot[0];
		if(slotsArray == null) {
			parkingLot = ParkingOperations.createParkingSlots("50");
			slotsArray = (ParkingSlot[])parkingLot[0];
		}
		
		System.out.printf("%s/t%s/t%s", "Slot No.", "Registration No", "Colour");
		for(int i=0; i<slotsArray.length; i++) {
			if(slotsArray[i] != null)
				System.out.printf("%d/t%s", (i+1), slotsArray[i].toString());
		}
		
		return parkingLot;
	}

}
