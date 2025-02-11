package com.example.springExample1;

import com.example.springExample1.account.AccountDao;
import com.example.springExample1.message.MessageDao;
import com.example.springExample1.user.ConnectionMaker;
import com.example.springExample1.user.DConnectionMaker;
import com.example.springExample1.user.dao.UserDao;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new UserDao(connectionMaker);
    }

    public AccountDao accountDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new AccountDao(connectionMaker);
    }

    public MessageDao messageDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new MessageDao(connectionMaker);
    }

}
