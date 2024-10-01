package com.enigmacamp.Service;

import java.util.*;

public class ParkingSystem {
    private int totalSlots;
    private Map<Integer, Vehicle> slots;

    public ParkingSystem(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slots = new HashMap<>();
    }

    public int parkVehicle(String regNo, String color, String type) {
        for (int i = 1; i <= totalSlots; i++) {
            if (!slots.containsKey(i)) {
                slots.put(i, new Vehicle(regNo, color, type));
                System.out.println("Allocated slot number: " + i);
                return i;
            }
        }
        System.out.println("Sorry parking lot is full");
        return -1;
    }

    public void leave(int slotNumber) {
        if (slots.containsKey(slotNumber)) {
            slots.remove(slotNumber);
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }

    public void status() {
        System.out.println("Slot\tNo.\t\tType\tRegistration No\tColour");
        for (Map.Entry<Integer, Vehicle> entry : slots.entrySet()) {
            int slot = entry.getKey();
            Vehicle vehicle = entry.getValue();
            System.out.println(slot + "\t" + vehicle.getRegistrationNumber() + "\t" + vehicle.getType() + "\t" + vehicle.getColor());
        }
    }

    public void countVehiclesByType(String type) {
        long count = slots.values().stream().filter(v -> v.getType().equalsIgnoreCase(type)).count();
        System.out.println(count);
    }

    public void vehiclesWithOddPlate() {
        slots.values().stream()
                .filter(v -> isOdd(v.getRegistrationNumber()))
                .forEach(v -> System.out.print(v.getRegistrationNumber() + " "));
        System.out.println();
    }

    public void vehiclesWithEvenPlate() {
        slots.values().stream()
                .filter(v -> !isOdd(v.getRegistrationNumber()))
                .forEach(v -> System.out.print(v.getRegistrationNumber() + " "));
        System.out.println();
    }

    public void vehiclesWithColour(String color) {
        slots.values().stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color))
                .forEach(v -> System.out.print(v.getRegistrationNumber() + " "));
        System.out.println();
    }

    public void slotsWithColour(String color) {
        slots.entrySet().stream()
                .filter(e -> e.getValue().getColor().equalsIgnoreCase(color))
                .forEach(e -> System.out.print(e.getKey() + " "));
        System.out.println();
    }

    public void slotForRegistrationNumber(String regNo) {
        slots.entrySet().stream()
                .filter(e -> e.getValue().getRegistrationNumber().equalsIgnoreCase(regNo))
                .findFirst()
                .ifPresentOrElse(
                        e -> System.out.println(e.getKey()),
                        () -> System.out.println("Not found")
                );
    }

    private boolean isOdd(String regNo) {
        String[] parts = regNo.split("-");
        String number = parts[1];
        int numericPart = Integer.parseInt(number);
        return numericPart % 2 != 0;
    }

}
