/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.service;

import com.s198618s198583.java.dao.AdminDao;
import com.s198618s198583.java.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao dao;

    public Admin findByID(int ID) {
        return dao.findByID(ID);
    }

    public Admin findByUsernameAndPass(String Username, String Password) {
        return dao.findByUsernameAndPass(Username, Password);
    }
}