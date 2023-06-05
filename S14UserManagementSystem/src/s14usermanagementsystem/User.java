/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagementsystem;

import java.io.Serializable;

/**
 * Represents a user in the user management system.
 *
 * @author khuakhanhhuy
 */
public class User implements Serializable {

    private String username;
    private String password;

    /**
     * Creates a new instance of the User class.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
