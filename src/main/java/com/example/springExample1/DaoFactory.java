package com.example.springExample1;

import com.example.springExample1.account.AccountDao;
import com.example.springExample1.message.MessageDao;
import com.example.springExample1.user.ConnectionMaker;
import com.example.springExample1.user.DConnectionMaker;
import com.example.springExample1.user.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setConectionMaker(connectionMaker());

        return userDao;
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

}
