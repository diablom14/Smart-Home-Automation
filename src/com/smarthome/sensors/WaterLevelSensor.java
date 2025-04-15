/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.sensors;

import com.smarthome.SmartHomeManager;

/**
 *
 * @author ROG
 */
public class WaterLevelSensor {
    public void levelCrossed(String level){
        SmartHomeManager.getInstance().updateSmartHomeManager(level);
    }
}
