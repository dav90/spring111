package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IContactRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davits on 11/16/15.
 */
@Repository
@Transactional
public class ContactRepository extends BaseRepository implements IContactRepository {

    @Override
    public void addContact(User user, Contact contact) throws DatabaseException {
        try {
            if (user == null) {
                user = new User();
            }
            List<Contact> contactList = user.getContact();
            if (contactList == null) {
                contactList = new LinkedList<>();
            }
            contactList.add(contact);
            contact.setUser(user);
            Session session = sessionFactory.getCurrentSession();
            if (session == null) {
                session = sessionFactory.openSession();
            }
            session.save(contact);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(Contact contact) {

    }

    @Override
    public List<Contact> getAllContact() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Contact");

        // Retrieve all
        return query.list();
    }
}
