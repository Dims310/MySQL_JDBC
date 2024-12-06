package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  private Connection con;

  public Connection getConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_toserba", "root", "");

      System.out.println("Successfuly connected.");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage()); // tidak boleh melakukan stacktrace/loging pada production
    }

    return con;
  }
}
