/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.rooms;


import com.smarthome.devices.Device;
import com.smarthome.sensors.Sensor;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomName;
    private List<Device> devices;
    private List<Sensor> sensors;  // Added list for sensors

    public Room(String roomName) {
        this.roomName = roomName;
        this.devices = new ArrayList<>();
        this.sensors = new ArrayList<>();  // Initialize sensor list
    }
    
    public String getName()
    {
        return this.roomName;
    }
    // Add a device to the room
    public void addDevice(Device d) {
        this.devices.add(d);
    }
    
    // Remove a device from the room by name
    public void removeDevice(String deviceName) {
        devices.removeIf(device -> device.getName() != null && device.getName().equals(deviceName));
    }
    public void saveState() {
        for (Device device : devices) {
            device.saveState();
        }
    }

    // Get the list of devices in the room
    public List<Device> getDevices() {
        return this.devices;
    }

    // Add a sensor to the room
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    // Remove a sensor from the room
    public void removeSensor(Sensor sensor) {
        this.sensors.remove(sensor);
    }

    // Get the list of sensors in the room
    public List<Sensor> getSensors() {
        return this.sensors;
    }
}
