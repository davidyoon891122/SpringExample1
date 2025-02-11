package com.example.springExample1.message;

import com.example.springExample1.user.ConnectionMaker;

public class MessageDao {

    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

}
