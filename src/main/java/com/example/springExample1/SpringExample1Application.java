package com.example.springExample1;

import com.example.springExample1.user.dao.UserDao;
import com.example.springExample1.user.domain.User;
import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

@SpringBootApplication
public class SpringExample1Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(SpringExample1Application.class, args);

		JUnitCore.main("com.example.springExample1.UserDaoTest");

	}

}
