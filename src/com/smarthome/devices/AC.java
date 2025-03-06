/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.devices;

/**
 *
 * @author ROG
 */
public class AC extends Device {
    private int temperature;
    private String mode;
    
    public AC(String name, int temperature, String mode) {
        super(name);
        this.temperature = temperature;
        this.mode = mode;
    }
    
    public void setTemperature(int temp) {
        if (isOn) {
            temperature = temp;
            System.out.println(name + " temperature set to " + temp + "°C");
        } else {
            System.out.println(name + " is OFF. Turn it ON to adjust temperature.");
        }
    }

    public String getMode() {
        return mode;
    }

    public int getTemperature() {
        return temperature;
    }
    
    public void setMode(String mode) {
        if (isOn) {
            this.mode = mode;
            System.out.println(name + " mode set to " + mode);
        } else {
            System.out.println(name + " is OFF. Turn it ON to change mode.");
        }
    }
    
    @Override
    public void update(Object data) {
        if (data instanceof Integer) { // Temperature sensor update
            int newTemperature = (Integer) data;
            setTemperature(newTemperature);
        }
}


    @Override
    public void displayStatus() {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Temp: " + temperature + "°C, Mode: " + mode);
    }
}
