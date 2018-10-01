package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

  private static Connection cnx = null;

  public static Connection getConexion() {
    try {
      if (cnx == null) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        Class.forName("com.mysql.jdbc.Driver");
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/ventas", "root", "");
      }
      return cnx;
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException("Error al crear la conexion!", e);
    }
  }

  static class ShutdownHook extends Thread {

    @Override
    public void run() {
      try {
        Connection con = Conexion.getConexion();
        System.out.println("Conexión cerrada!");
        con.close();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
