package com.springapp.mvc.repository;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by davits on 11/16/15.
 */
public interface IContactRepository {
    void addContact(User user, Contact contact) throws DatabaseException;

    void removeContact(Contact contact);

    List<Contact> getAllContact();
}
