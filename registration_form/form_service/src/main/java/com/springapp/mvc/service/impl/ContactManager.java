package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IContactRepository;
import com.springapp.mvc.service.IContactManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by davits on 11/16/15.
 */
@Service
public class ContactManager implements IContactManager {

    @Autowired
    private IContactRepository contactRepository;

    @Override
    public void addContact(User user, Contact contact) throws DatabaseException {
        contactRepository.addContact(user, contact);
    }

    @Override
    public void removeContact(Contact contact) {
        contactRepository.removeContact(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.getAllContact();
    }
}
