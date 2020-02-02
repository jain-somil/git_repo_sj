package parking_lot;

import java.util.Scanner;

import parking_lot.operations.OperationsController;

public class ParkingLotApplication {

	public static void main(String[] args) {
		
		Object[] parkingLot = null;
		
		System.out.println("Starting the Program in Interactive Mode..");
		System.out.println("Please enter the commands: ");
		Scanner sc = new Scanner(System.in);
		String inputLine;
		while(true) {
			inputLine = sc.nextLine();
			String[] commands = inputLine.split(" ");
			switch(commands.length) {
			case 1: parkingLot = OperationsController.performOperation(parkingLot, commands[0]);
					break;
			case 2: parkingLot = OperationsController.performOperation(parkingLot, commands[0], commands[1]);
					break;
			case 3: parkingLot = OperationsController.performOperation(parkingLot, commands[0], commands[1], commands[2]);
					break;
			default: System.out.println("Invalid Input");
					break;
			
			}
			if(parkingLot == null)
				break;
		}
		sc.close();

	}

}
