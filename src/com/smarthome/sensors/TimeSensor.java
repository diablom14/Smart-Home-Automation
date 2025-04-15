/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.sensors;
import com.smarthome.devices.Device;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROG
 */
public class TimeSensor implements Sensor {
    List<Device> observers;
    TimeSensor(){
        this.observers = new ArrayList();
    }
    
    @Override
    public void addObserver(Device device) {
        observers.add(device);
    }

    @Override
    public void removeObserver(Device device) {
        observers.remove(device);
    }

    @Override
    public void notifyObservers(Object obj) {
        for(Device device: observers){
            device.update(obj);
        }
    }
    
    public void setTimeEvent(String timeEvent){
        notifyObservers(timeEvent);
    }
    
}
