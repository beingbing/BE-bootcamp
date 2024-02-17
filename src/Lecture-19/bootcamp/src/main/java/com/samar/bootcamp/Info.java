package com.samar.bootcamp;

public class Info {
    // JDBC
    //  - it serves, "Java DB Connectivity", but it is not the only thing that it does
    //  - provide us a set of super powerful APIs that makes it easy to talk to DB servers.

    /*
    *   Java-application     <===     network communication     ===>     DB server
    *
    *   JDBC provides us to do 'network-communication'
    *
    *   If JDBC do not existed then we would have needed to understand network protocol
    *   which is used to talk to DB server. Like, serialization/deserialization, fetch, etc.
    * */

    // it is not JDBC's responsibility to write queries
    // when we are working on Spring-Boot, Hibernate does that for us, it writes queries
    // we use Hibernate, which internally uses JDBC

    /*  1. Abstract out networking part. Like, establishing and killing connection.
     *  2. extensibility to connect to different DB vendors. [requires superior knowledge of LLD]
    * */

    /* To achieve extensibility -
     * java.sql comes in-built with java SDK which has a Driver interface. It has a connect()
     * which takes in DB server URL with other properties and return a connection of type
     * Connection, which is also an interface.
     *
     * So, what java did is. He issued an indirect invite to all the DB vendors, and showed them
     * that if they want that a Java application holder uses your DB, then you should write a
     * code base which implements Driver interface, so that you implement connect() and then
     * people can use your Driver implementation to connect to your DB.
     *
     * DriverManager manages Driver and is responsible for getting you a connection.
     * There is a list of Drivers that a DriverManager maintains.
    * */

    // connection pooling -
    // whenever DriverManager.getConnection() is called, it return us a new connection
    // whenever a new connection is created, a lot of things happen, like: PCP handshake, network calls,
    // resources are initialised. Hence it's a very expensive operation to create a new connection for
    // every request. That's why connection pooling exist, which is very similar to Thread Pooling.
    // JDBC doesn't provide a connection pool, but we can write our own class for connection pooling.
    // However, Apache Tomcat does that for us, it has DataSource which provides us with the connection pool.
    // we can set PoolProperties and use DataSource.getConnection() to get a connection from that pool.
}
