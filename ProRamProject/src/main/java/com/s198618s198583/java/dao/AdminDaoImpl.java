/*
    Jon Gillingsrud, s198618
    Christoffer Fredriksen, s198583
*/

package com.s198618s198583.java.dao;

import com.s198618s198583.java.models.Admin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDaoImpl extends AbstractDao<Integer, Admin> implements AdminDao {


    public Admin findByID(int ID) {
        return getByKey(ID);
    }

    public Admin findByUsernameAndPass(String Username, String Password) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("Username", Username));
        criteria.add(Restrictions.eq("Password", Password));
        return (Admin) criteria.uniqueResult();
    }
}