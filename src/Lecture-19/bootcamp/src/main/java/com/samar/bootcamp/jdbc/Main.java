package com.samar.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        /**
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
        */
    }

    private static void connectUsingDriverManager(String url, String userName, String password, String tableName, String colName) throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, userName, password);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("select * from " + tableName);
            while (rs.next()) {
            // if a ResultSet contains 1M rows, then not all rows are transferred to application
            // server from DB server.
            // As Result-Set is being loaded, on DB server, a particular small amount of rows will be
            // forwarded to application server, on which .next() of rs will run and as soon as we
            // run out of rows on application server, a network call will be made internally to
            // get the next batch of rows.
                System.out.println(rs.getString(colName));
            }
            rs.close();
            stm.close();
            // it is important to close() to prevent memory leak
            // Q.   when a non-pointed object is automatically cleared by garbage collector, then
            //      what's the use of manually close().
            // A.   1. Garbage collector doesn't run instantly. It runs after some periodic interval,
            //      and, that interval can be large as well. So, to instantly scrap these humongous
            //      object once they are not needed, we do .close().

            // A quick way to do is to scrap Connection Object and all the Objects born out of it
            // will be destroyed instantly.

            //      2. Another reason is, when a query is fired on DB server, some resources are
            //      created by DB server as well, like cursor and local objects. Once, you close
            //      the connection, all those object memory is freed as well.
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    private static void connectToDBExampleForHavingDiffResSetsWithSameCon1(String url, String userName, String password, String tableName, String colName, String val1, String val2) throws SQLException {
        Connection c = DriverManager.getConnection(url, userName, password);
        Statement stm = c.createStatement();
//        System.out.println(c.getAutoCommit());
        ResultSet res1 = stm.executeQuery("select * from " + tableName + " where " + colName + " = " + val1);
        ResultSet res2 = stm.executeQuery("select * from " + tableName + " where " + colName + " = " + val2);
        while (res1.next()) {
            System.out.println(res1.getString(colName));
        }
        while (res2.next()) {
            System.out.println(res2.getString(colName));
        }
        /*
         * The above statement will yield: This 'ResultSet' is closed.
         * because,
         * with one Statement you can have only one ResultSet which it is pointing to.
         * It can not point to any other ResultSet. but, here we tried to create 2 RS
         * using 1 Statement.
         *
         * but, below code will work -
         * ResultSet res1 = stm.executeQuery("select * from " + tableName + " where " + colName + " = " + val1);
         * while (res1.next()) {
         *  System.out.println(res1.getString(colName));
         * }
         * ResultSet res2 = stm.executeQuery("select * from " + tableName + " where " + colName + " = " + val2);
         * while (res2.next()) {
         *  System.out.println(res2.getString(colName));
         * }
         *
         * see below 👇 working code
         * */
        c.close();
    }

    // the below code will work fine
    private static void connectToDBExampleForHavingDiffResSetsWithSameCon2(String url, String userName, String password, String tableName, String colName, String val1, String val2) throws SQLException {
        Connection c = DriverManager.getConnection(url, userName, password);
        Statement stm1 = c.createStatement();
        Statement stm2 = c.createStatement();
        System.out.println(c.getAutoCommit());
        ResultSet res1 = stm1.executeQuery("select * from " + tableName + " where " + colName + " = " + val1);
        ResultSet res2 = stm2.executeQuery("select * from " + tableName + " where " + colName + " = " + val2);
        while (res1.next()) {
            System.out.println(res1.getString(colName));
        }
        while (res2.next()) {
            System.out.println(res2.getString(colName));
        }
        c.close();
    }

    private static void connectDBExampleWithScrollableResultSet(String url, String userName, String password, String tableName, String colName, String val1) throws SQLException {
        Connection c = DriverManager.getConnection(url, userName, password);
        Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // INSENSITIVE suffix is used to make sure if data in DB is changed after execution of query
        // then it will not affect our ResultSet which is maintained using cursor at DB server.
        // conversely, SENSITIVE will keep our ResultSet maintained at DB server end also updated to any change made.
        // ----
        // CONCUR_UPDATABLE constant gives us capability to update data fetched in ResultSet (which will reflect on DB as well)
        // converely, CONCUR_READ_ONLY constant keeps the ResultSet immutable
        // although, update query is preferred because every update will execute a query over network on DB server
        // ----
        // alternatively, we have CachedRowSet, which will keep all updates in memory and then at once
        // when you instruct it to update, all the changes will be updated in one go.
        ResultSet rs = stm.executeQuery("select * from " + tableName + " where " + colName + " = " + val1);
        rs.last(); // Mind it => It's not after row, it's "AT LAST ROW!!"
        System.out.println(rs.getString(colName));
        while (rs.previous()) {
            System.out.println(rs.getString(colName));
        }
        c.close();
    }
    /*
     * just like next(), previous() will move the cursor to previous row.
     *
     * When a call to previous() returns false, the cursor is position before the first row.
     *
     * Any invocation of a ResultSet method which requires a current row will result in a SQLException being thrown.
     *
     * while (res1.next()) {
     *     System.out.println(res1.getString(colName));
     * }
     * while (res1.previous()) {
     *     System.out.println(res1.getString(colName));
     * }
     * The above code will throw: Operation requires a scrollable ResultSet, but this ResultSet is FORWARD_ONLY.
     * So, by default, ResultSet is TYPE_FORWARD_ONLY. i.e., we can only go down in one direction.
     * If you want to go up, you need to configure that using TYPE_SCROLL_*
     * It is because along with ResultSet maintained at our end, one is maintained at DB server end as well to which
     * we need to ask to keep ability of going up as well, which we need to do at the time of executing query statement to DB.
     *
     */
}
