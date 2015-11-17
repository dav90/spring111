package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IAddressRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by davits on 11/12/15.
 */
@Repository
@Transactional
public class AddressRepository extends BaseRepository implements IAddressRepository {

//        @Resource(name = "sessionFactory")



    @Override
    public void addAddress(Address address) throws DatabaseException {
//        try {
////            if (user == null) {
////                user = new User();
////            }
////            List<Address> addressList = user.getAddress();
////            if (addressList == null) {
////                addressList = new LinkedList<>();
////            }
////            addressList.add(address);
////            address.setUser(user);
//            Session session=null; /*= sessionFactory.getCurrentSession();*/
//            if (session == null) {
//                session = sessionFactory.openSession();
//            }
//            session.save(address);
//            //session.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(address);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new DatabaseException("can't add user to database");
        }


    }

    @Override
    public void removeAddress(Address address) {

    }

    @Override
    public List<Address> getAllAddress() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Address");

        // Retrieve all
        return query.list();
    }
}
