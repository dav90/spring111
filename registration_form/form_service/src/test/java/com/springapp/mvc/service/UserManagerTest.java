package com.springapp.mvc.service;

import com.springapp.mvc.model.Address;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;

import com.springapp.mvc.service.impl.UserManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.springapp.mvc.service.UserManagerTestUtils.getUser;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:com/springapp/mvc/resource/testApplicationContext.xml"})
//@TestExecutionListeners({
//        DependencyInjectionTestExecutionListener.class,
//})

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "../../../../../../../../form_controller/src/main/webapp/WEB-INF/applicationContext.xml",
//        "../resource/testApplicationContext.xml",
//        "../../../../../../../../form_controller/src/main/webapp/WEB-INF/hibernateContext.xml"})
//@TestExecutionListeners({
//        DependencyInjectionTestExecutionListener.class,
//})

public class UserManagerTest {


    @InjectMocks
    private IUserManager manager = new UserManager();

    @Mock
    private IUserRepository repository;


    private User user;
    private List<User> userList;

    private Address address;

    @Before
    public void init() {
        user = getUser();
        userList = UserManagerTestUtils.getUsers();
        initMocks(this);
    }

    @Test
    public void testAddUser() throws Exception {

        manager.addUser(user);
        verify(repository).addUser(user);
    }

    @Test
    public void testRemoveUser() throws Exception {
        manager.removeUser(user);
        verify(repository).removeUser(user);
    }

    @Test
    public void testFindUserByEmail() throws Exception {
        String email = anyString();
        when(repository.findUserByEmail(email)).thenReturn(user);
        User user = manager.findUserByEmail(email);
        assertNotNull(user);
        verify(repository).findUserByEmail(email);
    }

    @Test
    public void testGetAllUser() throws Exception {

        when(repository.getAllUser()).thenReturn(userList);
        manager.getAllUser();
        verify(repository).getAllUser();
    }

    @Test
    public void testChangeUser() throws Exception {
        manager.changeUser(user,address);
        verify(repository).changeUser(user, address);
    }

    @Test
    public void testIsExistingUser() throws Exception {
        when(repository.isExistingUser(user)).thenReturn(true);
        assertEquals(true, manager.isExistingUser(user));
    }
}