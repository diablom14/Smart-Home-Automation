/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.utils;

import com.smarthome.SmartHomeManager;
import com.smarthome.devices.AC;
import com.smarthome.devices.Device;
import com.smarthome.devices.Fan;
import com.smarthome.devices.Light;
import com.smarthome.rooms.Room;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ROG
 */
public class FileManager {

    public static void saveData(List<Room> rooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("smart_home_state.txt"))) {
            for (Room room : rooms) {
                writer.write("Room: " + room.getName() + "\n");
                for (Device device : room.getDevices()) {
                    writer.write("Device: " + device.getName() + " | State: " + device.saveState() + "\n");
                }
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void loadData(List<Room> rooms) {
        try (BufferedReader reader = new BufferedReader(new FileReader("smart_home_state.txt"))) {
            String line;
            Room currentRoom = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Room:")) {
                    String roomName = line.split(":")[1].trim();
                    currentRoom = new Room(roomName); // Create a new room
                    rooms.add(currentRoom);
                } else if (line.startsWith("Device:")) {
                    String[] deviceInfo = line.split("\\|")[1].split("State:");
                    String deviceName = deviceInfo[0].trim();
                    String state = deviceInfo[1].trim();
                    // Assume that you know what kind of device it is (AC, Fan, Light)
                    // Create appropriate device based on name or other logic
                    Device device = null;
                    if (deviceName.contains("AC")) {
                        device = new AC(deviceName, 20, "Cool"); // Example: Load with default values
                    } else if (deviceName.contains("Fan")) {
                        device = new Fan(deviceName, 50); // Example: Load with default values
                    } else if (deviceName.contains("Light")) {
                        device = new Light(deviceName); // Example: Load with default values
                    }

                    if (device != null) {
                        device.loadState(state);
                        currentRoom.addDevice(device);
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
