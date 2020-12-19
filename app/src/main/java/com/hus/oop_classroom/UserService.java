package com.hus.oop_classroom;

import com.google.firebase.firestore.auth.User;

/**
 * SRP – Single responsibility principle example
 * 
 * @author gpcoder
 */
class UserService {
    // Get data from database
    public User getUser() {
        return null;
    }
 
    // Check validation
    public boolean isValid() {
        return true;
    }
 
    // Show Notification
    public void showNotification() {
 
    }
 
    // Logging
    public void logging() {
        System.out.println("...");
    }
 
    // Parsing
    public User parseJson(String json) {
        return null;
    }
}