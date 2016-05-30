/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.service;

import com.s198618s198583.java.models.Admin;

public interface AdminService {

    Admin findByID(int ID);

    Admin findByUsernameAndPass(String Username, String Password);
}