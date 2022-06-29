package com.tcs.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

  private static Connection connection;

  public static Connection connect() throws SQLException {
    if (connection == null) {
      String url = "jdbc:mysql://127.0.0.1:3306/blog";
      String user = "root";
      String password = "root";
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Created a new connection");
    }
    return connection;
  }

}
