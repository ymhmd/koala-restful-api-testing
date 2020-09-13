package com.koala.apitesting.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCManager {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    public JDBCManager(String dbUrl, String dbUsername, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    public void executeQuery(String query) throws Exception {
        Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = con.createStatement();
        statement.executeQuery(query);
    }
}
