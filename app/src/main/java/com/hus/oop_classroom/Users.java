package com.hus.oop_classroom;

public class Users {
    private String email;
    private String type;
    private String username;
    private String password;

    public Users() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Users(String email, String type, String username, String password) {
        this.email = email;
        this.type = type;
        this.username= username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
