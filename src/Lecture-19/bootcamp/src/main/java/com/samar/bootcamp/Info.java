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
}
