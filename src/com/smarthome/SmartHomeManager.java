/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome;

import com.smarthome.rooms.Room;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ROG
 */
public class SmartHomeManager {
    private static SmartHomeManager instance;
    private Map<String, Room> rooms;
    
    private SmartHomeManager()
    {
        rooms = new HashMap<>();
    }
    
    public static SmartHomeManager getInstance()
    {
        if(instance==null)
        {
            instance = new SmartHomeManager();
        }
        return instance;
    }
    
    public void addRoom(String roomName)
    {
        Room room = new Room(roomName);
        
    }
}
