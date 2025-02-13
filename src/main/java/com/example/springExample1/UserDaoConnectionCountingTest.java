package com.example.springExample1;

import com.example.springExample1.user.dao.UserDao;
import com.example.springExample1.user.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("davidyoon");
        user.setName("davidyoon");
        user.setPassword("1234");

        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User resultUser = userDao.get("davidyoon");
        System.out.println(resultUser.getName());
        System.out.println(resultUser.getPassword());

        System.out.println(resultUser.getId() + " 조회 성공");

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection count: " + ccm.getCounter());
    }

}
