package parking_lot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import parking_lot.operations.OperationsController;

public class ParkingLotApplication {

	public static void main(String[] args){
		
		Object[] parkingLot = null;
		
		String inputLine;
		
		if(args.length != 0) {
			File file = new File(args[0]);
			System.out.println("Starting the Program in File Mode..");
			try (Scanner sc = new Scanner(file)){
				while(sc.hasNextLine()) {
					inputLine = sc.nextLine();
					parkingLot = issueCommands(inputLine, parkingLot);
					if(parkingLot == null)
						break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("Starting the Program in Interactive Mode..");
			System.out.println("Please enter the commands: ");
			try(Scanner sc = new Scanner(System.in)){
				while(true) {
					inputLine = sc.nextLine();
					parkingLot = issueCommands(inputLine, parkingLot);
					if(parkingLot == null)
						break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Object[] issueCommands(String input, Object[] parkingLot) {
		String[] commands = input.split(" ");
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
		
		return parkingLot;
	}

}
