package com.springapp.mvc.repository.impl;

import com.springapp.mvc.exception.DatabaseException;
import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


@Repository
@Transactional
public class UserRepository extends BaseRepository implements IUserRepository {

//    @Resource(name = "sessionFactory")

//    @PostConstruct
//    public void sss(){
//        Session session = sessionFactory.getCurrentSession();
//
//
//    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PostConstruct
    public void session(){

        Session session= sessionFactory.openSession();
    }

    @Override
    public void addUser(User user) throws DatabaseException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new DatabaseException("can't add user to database");
        }
    }


    @Override
    public void removeUser(User user) {

    }

    @Override
    public User findUserByEmail(String email) {
        String hql = "from User u where u.email= :email";
        User user = null;
        List results = null;
        try {
//            result = (List) sessionFactory.getCurrentSession().createQuery(hql).setParameter("email",user.getEmail());
            Session session = this.sessionFactory.openSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            results = query.list();

            user = (User)results.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM User");

        // Retrieve all
        return  query.list();
    }

    @Override
    public void changeUser(User user, Address address){

            Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Address> addressList = user.getAddress();
            if (addressList == null) {
                addressList = new LinkedList<>();
            }
            addressList.add(address);
            address.setUser(user);

            session.merge(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExistingUser(User user){
        String hql = "from User u where u.email= :email";
        List results = null;
        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", user.getEmail());
            results = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results != null;
    }


    @Override
    public boolean isExistingPassword(String password){
            return password != null;

    }

}
