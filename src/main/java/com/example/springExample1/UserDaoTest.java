package com.example.springExample1;

import com.example.springExample1.user.dao.UserDao;
import com.example.springExample1.user.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTest {

    private UserDao userDao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        this.userDao = context.getBean("userDao", UserDao.class);

        this.user1 = new User("david", "윤지원", "spring1");
        this.user2 = new User("kevin", "권혁", "spring2");
        this.user3 = new User("jenny", "오지연", "spring3");
    }

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        User user = new User();
        user.setId("davidyoon");
        user.setName("davidyoon");
        user.setPassword("1234");

        User user2 = new User("Kevin", "권혁", "3232");

        userDao.add(user);
        userDao.add(user2);

        assertThat(userDao.getCount(), is(2));

        User resultUser1 = userDao.get("davidyoon");
        assertThat(user.getName(), is(resultUser1.getName()));
        assertThat(user.getPassword(), is(resultUser1.getPassword()));

        User resultUser2 = userDao.get("Kevin");
        assertThat(user2.getName(), is(resultUser2.getName()));
        assertThat(user.getPassword(), is(resultUser1.getPassword()));


    }

    @Test
    public void count() throws SQLException {
        user1 = new User("david", "윤지원", "spring1");
        user2 = new User("kevin", "권혁", "spring2");
        user3 = new User("jenny", "오지연", "spring3");

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.get("unknown_id");
    }

}
