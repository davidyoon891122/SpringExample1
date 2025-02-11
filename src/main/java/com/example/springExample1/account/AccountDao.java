package com.example.springExample1.account;

import com.example.springExample1.user.ConnectionMaker;

public class AccountDao {

    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
