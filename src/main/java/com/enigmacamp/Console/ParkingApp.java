package com.enigmacamp.Console;

import com.enigmacamp.Service.ParkingSystem;

import java.util.Scanner;

public class ParkingApp {
    Scanner scanner = new Scanner(System.in);
    ParkingSystem parkingSystem = null;

    public void run() {
        while (true) {
            showMenu();
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            switch (command[0]) {
                case "create_parking_lot":
                    int size = Integer.parseInt(command[1]);
                    parkingSystem = new ParkingSystem(size);
                    System.out.println("Created a parking lot with " + size + " slots");
                    break;

                case "park":
                    if (parkingSystem != null) {
                        String regNo = command[1];
                        String color = command[2];
                        String type = command[3];
                        parkingSystem.parkVehicle(regNo, color, type);
                    }
                    break;

                case "leave":
                    if (parkingSystem != null) {
                        int slotNumber = Integer.parseInt(command[1]);
                        parkingSystem.leave(slotNumber);
                    }
                    break;

                case "status":
                    if (parkingSystem != null) {
                        parkingSystem.status();
                    }
                    break;

                case "type_of_vehicles":
                    if (parkingSystem != null) {
                        String type = command[1];
                        parkingSystem.countVehiclesByType(type);
                    }
                    break;

                case "registration_numbers_for_vehicles_with_ood_plate":
                    if (parkingSystem != null) {
                        parkingSystem.vehiclesWithOddPlate();
                    }
                    break;

                case "registration_numbers_for_vehicles_with_event_plate":
                    if (parkingSystem != null) {
                        parkingSystem.vehiclesWithEvenPlate();
                    }
                    break;

                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingSystem != null) {
                        String color = command[1];
                        parkingSystem.vehiclesWithColour(color);
                    }
                    break;

                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingSystem != null) {
                        String color = command[1];
                        parkingSystem.slotsWithColour(color);
                    }
                    break;

                case "slot_number_for_registration_number":
                    if (parkingSystem != null) {
                        String regNo = command[1];
                        parkingSystem.slotForRegistrationNumber(regNo);
                    }
                    break;

                case "exit":
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    void showMenu(){
        System.out.println();
        System.out.println("MENU");
        System.out.println("====================================");
        System.out.println("create_parking_lot");
        System.out.println("park");
        System.out.println("leave");
        System.out.println("status");
        System.out.println("type_of_vehicles");
        System.out.println("registration_numbers_for_vehicles_with_ood_plate");
        System.out.println("registration_numbers_for_vehicles_with_even_plate");
        System.out.println("slot_numbers_for_vehicles_with_colour");
        System.out.println("slot_number_for_registration_number");
        System.out.println("exit");
        System.out.println();
        System.out.print("Enter command: ");
    }
}
