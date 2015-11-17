package com.springapp.mvc.repository;

import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.Contact;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.impl.UserRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:com/springapp/mvc/resource/testApplicationContext.xml"})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testApplicationContext.xml"})
public class UserRepositoryTest {


    private int size;
    private static List<User> userList;
    private static int listCapacity;



    @Autowired
    IUserRepository repository = new UserRepository();

    @Before
    public void getRandomInt() {
        if (userList.size() > 0) {
            Random random = new Random();
            size = random.nextInt(userList.size());
        }
    }

    @Test
    public void testAddUser() throws Exception {
        System.out.println("add test");

        repository.addUser(getCustomUser());
        assertEquals(10, userList.size());
        assertEquals(2, userList.get(0).getContact().size());
        assertEquals("name0", userList.get(0).getName());
        assertEquals("surname2", userList.get(2).getSurname());
        assertEquals("email3", userList.get(3).getEmail());
        assertEquals("password4", userList.get(4).getPassword());
        assertEquals(0, userList.get(4).getPassword().compareTo(
                userList.get(4).getConfirmPassword()));

    }

//    @Test
//    public void testRemoveUser() throws Exception {
//        System.out.println("remove user");
//        int a = userList.size();
//        userList.remove(size);
//        assertEquals(a, userList.size() + 1);
//        repository.removeUser(userList.get(0));
//        verify(repository).removeUser(userList.get(0));
//    }

    @Test
    public void testFindUserByEmail() throws Exception {
        User user = userList.get(size);
        String email = user.getEmail();
        userList.stream().filter(u -> email.equals(u.getEmail())).forEach(u ->
                assertTrue(email.equals(u.getEmail())));
        when(repository.findUserByEmail("email")).thenReturn(userList.get(0));
        repository.findUserByEmail("email");
        verify(repository).findUserByEmail("email");
    }

    @Test
    public void testGetAllUser() throws Exception {
        List<User> list = userList.stream().collect(Collectors.toCollection(LinkedList::new));
        assertEquals(list.size(), userList.size());
        repository.getAllUser();
        verify(repository).getAllUser();
    }

    @Test
//    public void testChangeUser() throws Exception {
//        User user = userList.get(size);
//        String s = "changeUser";
//        user.setEmail(s);
//        userList.add(user);
//        assertEquals(user.getEmail(), s);
//        repository.changeUser(userList.get(0));
//        verify(repository).changeUser(userList.get(0));
//    }

//    @Test
//    public void testIsExistingUser() throws Exception {
//        System.out.println("isExisting user");
//        repository.isExistingUser();
//        verify(repository).isExistingUser("email", "password");
//
//    }

    @BeforeClass
    public static void testInit() throws Exception {
        listCapacity = 5;
        userList = new LinkedList<>();
        createUsers();
        assertEquals(5, userList.size());
        assertEquals(2, userList.get(0).getContact().size());
        assertEquals("name0", userList.get(0).getName());
        assertEquals("surname2", userList.get(2).getSurname());
        assertEquals("email3", userList.get(3).getEmail());
        assertEquals("password4", userList.get(4).getPassword());
        assertEquals(0, userList.get(4).getPassword().compareTo(
                userList.get(4).getConfirmPassword()));
        System.out.println("tsestinit");
    }

    private  static User getCustomUser(){
        User user =  new User();
        user.setName("name");
        user.setSurname("surname");
        user.setEmail("email");
        user.setPassword("password");
        user.setConfirmPassword("password");
        user.setStatus(false);
            Address  address =  new Address();
            address.setCity("city");
            address.setStreet("street");
        user.setAddress(Arrays.asList(address));
            Contact contact = new Contact();
            contact.setHomeNumber("1234");
            contact.setMobileNumber("12321");
        user.setContact(Arrays.asList(contact));

        return user;
    }


    private static void createUsers() {
        for (int i = 0; i < listCapacity; i++) {
            List<Contact> contactList = new LinkedList<>();
            User user = new User();
            Address address = new Address();
            address.setStreet("street" + i);
            address.setCity("city" + i);
            for (int j = 0; j < 2; j++) {
                Contact contact = new Contact();
                contact.setHomeNumber("HomeNumber " + i + " " + j);
                contact.setMobileNumber("MobileNumber" + i + " " + j);
                contactList.add(contact);
            }

//            for (int j = 0; j < 2; j++) {
//                Address address = new Address ();
//                address.setHomeNumber("HomeNumber " + i + " " + j);
//                address.setMobileNumber("MobileNumber" + i + " " + j);
//                contactList.add(contact);
//            }
            user.setName("name" + i);
            user.setSurname("surname" + i);
            user.setEmail("email" + i);
            user.setPassword("password" + i);
            user.setConfirmPassword("password" + i);
//            user.setAddress(address);
            user.setContact(contactList);
            user.setStatus(false);
            userList.add(user);
        }

    }





}