/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.dao;

import com.s198618s198583.java.models.Admin;

public interface AdminDao {

    Admin findByID(int ID);
    Admin findByUsernameAndPass(String Username, String Password);
}