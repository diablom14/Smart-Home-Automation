/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.users;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROG
 */
public class UserManager {
    private static UserManager instance;
    private List <User> users;
    private UserManager()
    {
        users = new ArrayList();
        users.add(new Admin("DefaultAdmin"));
    }
    public static UserManager getInstance()
    {
        if(instance==null)
        {
            instance = new UserManager();
        }
        return instance;
    }
    
    public void addUser(User user, User admin)
    {
        if(admin instanceof Admin)
        {
            users.add(user);
            System.out.println("User "+user.getName()+" added to the users.");
        }
        else
        {
            System.out.println("Only admins have permission to add users.");
        }
    }
    
    public User findUser(String userName)
    {
        for(User user : users)
        {
            if(userName.equals(user.getName()))
            {
                return user;
            }
        }
        
        return null;
    }
    
    public void removeUser(User admin, User userToRemove) 
    {
        if (admin instanceof Admin) 
        {
            // Check if we are removing the last admin
            long adminCount = users.stream().filter(u -> u instanceof Admin).count();
            if (userToRemove instanceof Admin && adminCount == 1) 
            {
                System.out.println("Cannot remove the last admin!");
                return;
            }
            users.remove(userToRemove);
            System.out.println(userToRemove.getName() + " removed successfully.");
        } 
        else 
        {
            System.out.println("Permission denied! Only admins can remove users.");
        }
    }

    public void listUsers()
    {
        System.out.println("Registered Users");
        for(User user : users)
        {
            System.out.println("UserName: " + user.getName()+ " Role " + user.getRole());
        }
    }
    
}
