/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.users;

import com.smarthome.SmartHomeManager;
import com.smarthome.devices.Device;
import com.smarthome.rooms.Room;

/**
 *
 * @author ROG
 */
public class NormalUser extends User{
    public NormalUser(String name)
    {
        super(name, "Normal");
    }
    public void controlDevice(String roomName, String deviceName, String action) {
        SmartHomeManager manager = SmartHomeManager.getInstance();
        Room room = manager.getRoom(roomName);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        for (Device device : room.getDevices()) {
            if (device.getName().equalsIgnoreCase(deviceName)) {
                switch (action.toLowerCase()) {
                    case "on" -> device.turnOn();
                    case "off" -> device.turnOff();
                    case "toggle" -> device.toggleState();
                    default -> System.out.println("Unknown action. Use on/off/toggle.");
                }
                return;
            }
        }

        System.out.println("Device not found in the specified room.");
    }
    
}
