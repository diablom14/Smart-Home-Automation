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
        if (data instanceof String) {   // Time sensor or Motion sensor update
            String event = (String) data;
            if(event.equals("MORNING")) {
                if(isOn){
                    isOn = false;
                    System.out.println("AC turned off in morning time.");
                }
            }
            else if(event.equals("AFTERNOON")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("AC is turned on in afternoon time.");
                }
                
            }
            else if(event.equals("EVENING")) {
                if(isOn){
                    isOn = false;
                    System.out.println("AC is turned off in evening time.");
                }
                
            }
            else if(event.equals("NIGHT")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("AC is turned on in night time.");
                }
            }
            else if(event.equals("ENTRY")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Welcome, AC turned on for you.");
                }
            }
            else if(event.equals("NOMOTION")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Room empty, turning off the AC.");
                }
            }
            else{
               System.out.println("Invalid time event."); 
            }
        }
}


    @Override
    public void displayStatus() {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Temp: " + temperature + "°C, Mode: " + mode);
    }
    
    @Override
    public void toggleState() {
        isOn = !isOn;
        System.out.println("AC " + name + " is now " + (isOn ? "ON" : "OFF"));
    }
   @Override
    public String saveState() {
        return "temperature=" + temperature + ";status=" + (isOn ? "on" : "off");
    }

    @Override
    public void loadState(String state) {
        String[] parts = state.split(";");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue[0].equals("temperature")) {
                this.temperature = Integer.parseInt(keyValue[1]);
            } else if (keyValue[0].equals("status")) {
                this.isOn = keyValue[1].equals("on");
            }
        }
    }
}
