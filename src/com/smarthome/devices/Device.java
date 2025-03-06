/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.devices;

/**
 *
 * @author ROG
 */
abstract public class Device {
    protected String name;
    protected boolean isOn;
    
    public Device(String name)
    {
        this.name = name;
        isOn = false;
    }
    
    public void turnOn()
    {
        if(isOn)
        {
            System.out.println(name+ " is already on.");
        }
        else
        {
            this.isOn = true;
            System.out.println(name+ " is switched on.");
        }
    }
    
    public void turnOff()
    {
        if(!isOn)
        {
            System.out.println(name+ " is already off.");
        }
        else
        {
            this.isOn = false;
            System.out.println(name+ " is switched off.");
        }
    }
    
    public boolean getStatus()
    {
        return isOn;
    }
    
    abstract public void displayStatus();
    abstract public void update(Object obj);
}
