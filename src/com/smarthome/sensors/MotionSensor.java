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
public class MotionSensor implements Sensor {
    private List <Device> observers;
    public MotionSensor()
    {
        this.observers = new ArrayList();
    }
    
    public void addObserver(Device d)
    {
        observers.add(d);
    }
    public void removeObserver(Device d)
    {
        observers.remove(d);
    }
    public void notifyObservers(Object obj)
    {
        for(Device device : observers)
        {
            device.update(obj);
        }
    }
    public void motionDetected(String motion){
        notifyObservers(motion);
    }
}
