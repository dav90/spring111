package com.springapp.mvc.repository;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by davits on 11/12/15.
 */
public interface IAddressRepository {
    void addAddress(Address address) throws DatabaseException;

    void removeAddress(Address address);

    List<Address> getAllAddress();

}
