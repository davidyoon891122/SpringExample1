package com.example.springExample1;

import com.example.springExample1.account.AccountDao;
import com.example.springExample1.message.MessageDao;
import com.example.springExample1.user.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


import javax.sql.DataSource;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());

        return userDao;
    }

    public AccountDao accountDao() {
        return new AccountDao(dataSource());
    }

    public MessageDao messageDao() {
        return new MessageDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/example");
        dataSource.setUsername("davidyoon");
        dataSource.setPassword("Spring1234");

        return dataSource;
    }

}