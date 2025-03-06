/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.sensors;

import com.smarthome.devices.Device;

/**
 *
 * @author ROG
 */
public interface Sensor {
    void addObserver(Device device);
    void removeObserver(Device device);
    void notifyObservers(Object obj);
}
