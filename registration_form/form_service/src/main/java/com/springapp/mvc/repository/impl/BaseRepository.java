package com.springapp.mvc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by davits on 11/16/15.
 */
public abstract class BaseRepository {

    @Autowired
    public SessionFactory sessionFactory;

}
