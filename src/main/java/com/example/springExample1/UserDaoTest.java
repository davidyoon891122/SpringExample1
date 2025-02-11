package com.example.springExample1;

import com.example.springExample1.user.ConnectionMaker;
import com.example.springExample1.user.DConnectionMaker;
import com.example.springExample1.user.dao.UserDao;
import com.example.springExample1.user.domain.User;
import org.springframework.boot.SpringApplication;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(SpringExample1Application.class, args);


        UserDao userDao = new DaoFactory().userDao();;

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

    }

}
