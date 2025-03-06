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
    public void displayStatus() {
        System.out.println(name + " - Status: " + (isOn ? "ON" : "OFF") + ", Speed: " + speed);
    }
}
