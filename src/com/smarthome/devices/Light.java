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
        if (data instanceof String) {   // Time sensor update
            String event = (String) data;
            if(event.equals("MORNING")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Light is turned off in morning time.");
                }
            }
            else if(event.equals("AFTERNOON")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Light is turned off in afternoon time.");
                }
                
            }
            else if(event.equals("EVENING")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Light is turned on in evening time.");
                }
                
            }
            else if(event.equals("NIGHT")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Light is turned off in night time.");
                }
            }
            else if(event.equals("ENTRY")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Welcome, lights are turned on for you.");
                }
            }
            else if(event.equals("NOMOTION")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Room empty, turning off the light.");
                }
            }
            else{
               System.out.println("Invalid time event."); 
            }
        }
    }

    @Override
    public void displayStatus()
    {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Brightness: " + brightness);
    }
    
    @Override
    public void toggleState() {
        isOn = !isOn;
        System.out.println("Light " + name + " is now " + (isOn ? "ON" : "OFF"));
    }
    @Override
    public String saveState() {
        return "brightness=" + brightness + ";status=" + (isOn ? "on" : "off");
    }

    @Override
    public void loadState(String state) {
        String[] parts = state.split(";");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue[0].equals("brightness")) {
                this.brightness = Integer.parseInt(keyValue[1]);
            } else if (keyValue[0].equals("status")) {
                this.isOn = keyValue[1].equals("on");
            }
        }
    }
}
