/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.users;

import com.smarthome.SmartHomeManager;
import com.smarthome.devices.Device;

/**
 *
 * @author ROG
 */
public class Admin extends User {
    public Admin(String name)
    {
        super(name, "Admin");
    }
    
    public void changeUserRole(User user, String role)
    {
        if("Admin".equals(role) || "Normal".equals(role))
        {
           user.role = role;
           System.out.println("The role of user " + user.getName() + " changed to " + role); 
        }
        else
        {
            System.out.println("Invalid Role");
        }
    }
    public void addRoom(String roomName) {
        SmartHomeManager.getInstance().addRoom(roomName);
        System.out.println("Room added: " + roomName);
    }

    public void removeRoom(String roomName) {
        SmartHomeManager.getInstance().removeRoom(roomName);
        System.out.println("Room removed: " + roomName);
    }

    public void addDeviceToRoom(String roomName, Device device) {
        SmartHomeManager.getInstance().addDeviceToRoom(roomName, device);
        System.out.println("Device added to " + roomName + ": " + device.getName());
    }

    public void removeDeviceFromRoom(String roomName, String deviceName) {
        SmartHomeManager.getInstance().removeDeviceFromRoom(roomName, deviceName);
        System.out.println("Device removed from " + roomName + ": " + deviceName);
    }
}
