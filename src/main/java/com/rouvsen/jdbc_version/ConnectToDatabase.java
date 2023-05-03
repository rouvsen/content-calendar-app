package com.rouvsen.jdbc_version;

import java.sql.*;

public class ConnectToDatabase {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";

        try(
                Connection conn = DriverManager.getConnection(
                        jdbcURL,
                        "postgres",
                        "123");
                ){

            if (!conn.isValid(0)){
                System.out.println("Unable to connect to database");
                System.exit(0);
            }

            PreparedStatement preparedStatement = conn.prepareStatement("select * from run");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(name + ", " + email);//or something
            }


        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
