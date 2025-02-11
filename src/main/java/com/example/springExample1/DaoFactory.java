package com.example.springExample1;

import com.example.springExample1.account.AccountDao;
import com.example.springExample1.message.MessageDao;
import com.example.springExample1.user.ConnectionMaker;
import com.example.springExample1.user.DConnectionMaker;
import com.example.springExample1.user.dao.UserDao;

public class DaoFactory {

    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

}
