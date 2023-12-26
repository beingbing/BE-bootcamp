package com.samar.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:3306/samar");
        // connection url can be found in documentation
        // localhost:<port>/<DB-name>
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from players");
        // ResultSet is based on Iterator design-pattern
        while (rs.next()) {
            System.out.println(rs.getInt("personId"));
        }

        // making another connection to second DB
        Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5433/shaikh");
        Statement stat = con2.createStatement();
        ResultSet rs2 = stat.executeQuery("select * from accounts");
        while (rs2.next()) {
            System.out.println(rs2.getInt("accId"));
        }

        // making another connection to third DB
        Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:8000/taj", "root", "samarPass");
        Statement stat3 = con3.createStatement();
        ResultSet rs3 = stat3.executeQuery("select * from profiles");
        while (rs3.next()) {
            System.out.println(rs3.getInt("id"));
        }
    }
}
