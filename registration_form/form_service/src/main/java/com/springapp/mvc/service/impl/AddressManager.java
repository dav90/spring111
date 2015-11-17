package com.springapp.mvc.service.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IAddressRepository;
import com.springapp.mvc.service.IAddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by davits on 11/12/15.
 */
@Service
public class AddressManager implements IAddressManager {

    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public void addAddress(Address address) throws DatabaseException {
        addressRepository.addAddress(address);
    }

    @Override
    public void removeAddress(Address address) {
        addressRepository.removeAddress(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.getAllAddress();
    }
}
