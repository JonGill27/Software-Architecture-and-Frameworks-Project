/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "Username")
    private String Username;

    @Column(name = "Password")
    private String Password;

    public void hashPass() {

        String hashedPass = null;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA1");

            md.update(Password.getBytes());

            byte[] bytePass = md.digest();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytePass.length; i++) {
                sb.append(Byte.toString(bytePass[i]));
            }

            hashedPass = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithm!: " + e.getLocalizedMessage());
        }

        setPassword(hashedPass);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
