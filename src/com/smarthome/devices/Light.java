/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.devices;

/**
 *
 * @author ROG
 */
public class Light extends Device {
    
    private int brightness;
    public Light(String name)
    {
        super(name);
        this.brightness = 50;
    }
    
    public void setBrightness(int level) {
        if (isOn) {
            brightness = level;
            System.out.println(name + " brightness set to " + level);
        } else {
            System.out.println(name + " is OFF. Turn it ON to adjust brightness.");
        }
    }

    public int getBrightness() {
        return brightness;
    }
    
    @Override
    public void update(Object data) {
        if (data instanceof Boolean) { // Motion sensor update
            boolean motionDetected = (Boolean) data;
            if (!motionDetected) {
                turnOff();
            }
        }
    }

    @Override
    public void displayStatus()
    {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Brightness: " + brightness);
    }
}
