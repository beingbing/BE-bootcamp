package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class BootcampApplication implements ApplicationRunner {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(BootcampApplication.class, args);
        System.out.println("Hello Samar !!!");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application Started !!!");
		persistData();
    }

    public void persistData() {
		Connection connection = null;
        try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "foo", "bar");
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)");
            stmt.setString(1, "4");
            stmt.setString(2, "2");
            stmt.executeUpdate();
            stmt.close();

			PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO PUBLISHER (ISBN, BOOK_NAME, PUBLISHER_CODE) VALUES (?, ?, ?)");
			stmt.setString(1, "5");
			stmt.setString(2, "2");
			stmt.setString(3, "3");
			stmt.executeUpdate();
			stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
				assert connection != null;
				connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
