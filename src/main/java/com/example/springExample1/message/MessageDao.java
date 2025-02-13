package com.example.springExample1.message;

import javax.sql.DataSource;

public class MessageDao {

    private DataSource dataSource;

    public MessageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
