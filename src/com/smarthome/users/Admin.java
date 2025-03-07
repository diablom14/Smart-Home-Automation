/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarthome.users;

/**
 *
 * @author ROG
 */
public class Admin extends User {
    public Admin(String name)
    {
        super(name, "Admin");
    }
    
    public void changeUserRole(User user, String role)
    {
        if("Admin".equals(role) || "Normal".equals(role))
        {
           user.role = role;
           System.out.println("The role of user " + user.getName() + " changed to " + role); 
        }
        else
        {
            System.out.println("Invalid Role");
        }
    }
}
