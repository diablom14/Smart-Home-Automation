/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.devices;

/**
 *
 * @author ROG
 */
public class Fan extends Device {
    private int speed;
    
    public Fan(String name, int speed) {
        super(name);
        this.speed = speed;
    }
    
    public void setSpeed(int level) {
        if (isOn) {
            speed = level;
            System.out.println(name + " speed set to " + level);
        } else {
            System.out.println(name + " is OFF. Turn it ON to adjust speed.");
        }
    }

    public int getSpeed() {
        return speed;
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
            String timeEvent = (String) data;
            if(timeEvent.equals("MORNING")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Fan is turned on in morning time.");
                }
            }
            else if(timeEvent.equals("AFTERNOON")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Fan is turned on in afternoon time.");
                }
                
            }
            else if(timeEvent.equals("EVENING")) {
                if(!isOn){
                    isOn = true;
                    System.out.println("Fan is turned on in evening time.");
                }
                
            }
            else if(timeEvent.equals("NIGHT")) {
                if(isOn){
                    isOn = false;
                    System.out.println("Fan is turned on in night time.");
                }
            }
            else{
               System.out.println("Invalid time event."); 
            }
        }
    }

    @Override
    public void displayStatus() {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Speed: " + speed);
    }
}
