/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome;

import com.smarthome.devices.Device;
import com.smarthome.rooms.Room;
import com.smarthome.users.Admin;
import com.smarthome.users.NormalUser;
import com.smarthome.users.User;
import com.smarthome.users.UserManager;

/**
 *
 * @author ROG
 */
public class SmartHomeSystem {
    private UserManager userManager;
    private SmartHomeManager smartHomeManager;
    
    public SmartHomeSystem() {
        // Initialize the UserManager and SmartHomeManager
        userManager = UserManager.getInstance();
        smartHomeManager = SmartHomeManager.getInstance();
        
        // Optionally, initialize a default admin user
        userManager.addUser(new Admin("DefaultAdmin"), userManager.findUser("DefaultAdmin"));
    }

    // Function to add a new user (admin or normal)
    public void addUser(User user, User admin) {
        userManager.addUser(user, admin);
    }
    
    // Function to list all users
    public void listUsers() {
        userManager.listUsers();
    }

    // Function to find a user by name
    public User findUser(String userName) {
        return userManager.findUser(userName);
    }

    // Function to remove a user (admin can remove)
    public void removeUser(User admin, User userToRemove) {
        userManager.removeUser(admin, userToRemove);
    }

    // Function to add a room to the system
    public void addRoom(String roomName) {
        smartHomeManager.addRoom(roomName);
    }

    // Function to add a device to a specific room
    public void addDeviceToRoom(String roomName, Device device) {
        Room room = smartHomeManager.getRoom(roomName);
        if (room != null) {
            room.addDevice(device);
            System.out.println("Device " + device.getName() + " added to " + roomName);
        } else {
            System.out.println("Room " + roomName + " not found.");
        }
    }

    // Function to control a device's state (on/off/toggle)
    public void controlDevice(String userName, String roomName, String deviceName, String action) {
        User user = userManager.findUser(userName);
        
        if (user != null) {
            if (user instanceof Admin || user instanceof NormalUser) {
                ((NormalUser) user).controlDevice(roomName, deviceName, action);
            } else {
                System.out.println("User not found.");
            }
        }
    }
    
    // Function to display the current state of the system (optional for debugging)
    public void showSystemStatus() {
        System.out.println("Smart Home System Status: ");
        smartHomeManager.listRooms();
        userManager.listUsers();
    }
}
