package com.example.springExample1;

import com.example.springExample1.user.dao.UserDao;
import com.example.springExample1.user.domain.User;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTest {

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("davidyoon");
        user.setName("davidyoon");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User resultUser = userDao.get(user.getId());

        System.out.println(resultUser.getName());
        System.out.println(resultUser.getPassword());

        if (!user.getName().equals(resultUser.getName())) {
            System.out.println("테스트 실패 (name)");
        } else if (!user.getPassword().equals(resultUser.getPassword())) {
            System.out.println("테스트 실패 (password");
        } else {
            System.out.println("조회 테스트 성공");
        }
        assertThat(resultUser.getName(), is(user.getName()));
        assertThat(resultUser.getPassword(), is(user.getPassword()));


    }

}
