/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome;

import com.smarthome.devices.Device;
import com.smarthome.rooms.Room;
import com.smarthome.sensors.Sensor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ROG
 */
public class SmartHomeManager {
    private static SmartHomeManager instance;
    private Map<String, Room> rooms;
    private List<Sensor> globalSensors;
    
    private SmartHomeManager() {
        rooms = new HashMap<>();
        globalSensors = new ArrayList<>();
    }
    
    public static SmartHomeManager getInstance() {
        if (instance == null) {
            instance = new SmartHomeManager();
        }
        return instance;
    }
    
    public void addRoom(String roomName) {
        Room room = new Room(roomName);
        rooms.put(roomName, room);
    }
    public Room getRoom(String roomName) {
        return rooms.get(roomName);
    }

    public void removeRoom(String roomName) {
        Room room = rooms.get(roomName);
        if (room == null) {
            System.out.println("There is no such room");
            return;
        }
        rooms.remove(roomName);
    }
    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available in the system.");
        } else {
            System.out.println("List of rooms:");
            for (String roomName : rooms.keySet()) {
                System.out.println("Room Name: " + roomName);
            }
        }
    }
    public void addDeviceToRoom(String roomName, Device device) {
        Room room = rooms.get(roomName);
        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }
        room.addDevice(device);
    }
    
    public void removeDeviceFromRoom(String roomName, String deviceName) {
        Room room = rooms.get(roomName);
        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }

        room.removeDevice(deviceName);
        
        // Remove room if no devices are left
        if (room.getDevices().isEmpty()) {
            rooms.remove(roomName);
            System.out.println("Room " + roomName + " removed as no devices are left.");
        }
    }
    
    public void addSensorToRoom(String roomName, Sensor sensor) {
        Room room = rooms.get(roomName);
        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }
        room.addSensor(sensor);
    }
    
    public void removeSensorFromRoom(String roomName, Sensor sensor) {
        Room room = rooms.get(roomName);
        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }
        room.removeSensor(sensor);
    }
    
    public void addGlobalSensor(Sensor sensor) {
        globalSensors.add(sensor);
    }
    
    public void removeGlobalSensor(Sensor sensor) {
        globalSensors.remove(sensor);
    }
    
    public void updateSmartHomeManager(Object obj) {
        if(obj instanceof String){
            String event = (String) obj;
            if(event.equals("UPPERLIMIT")){
                System.out.println("Water has reached the upper limit of the tank. Switch off the motor. Pani ki tanki bhar gayi h kripya motor bandh kare.");
            }
            else if(event.equals("LOWERLIMIT")){
                System.out.println("Water has reached the lower limit of the tank. Switch on the motor.");
            }
        }
    }
    
    public void saveState() {
        for (Room room : rooms.values()) {
            room.saveState();
        }
    }

    public void loadState() {
        // Load state logic (stub)
        System.out.println("Loading room and device states...");
    }
}

