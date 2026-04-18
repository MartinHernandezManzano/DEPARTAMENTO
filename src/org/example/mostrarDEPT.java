package org.example;

import org.example.Conexion;

import java.sql.*;


public class mostrarDEPT {
    //creamos un metod para ejecutar el select
    public static void mostrarDEPT(){
        //ponemos la consulta
        String sql = "SELECT e.nombre AS empleado, e.salario, d.nombre AS departamento " +
                "FROM empleado e " +
                "INNER JOIN departamento d ON e.departamento_id = d.id";
        //hacemos el try y recorremos el resultset
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            //recorremos
            while (rs.next()) {
                System.out.println(rs.getString("empleado") + " | " +
                        rs.getDouble("salario")  + " | " +
                        rs.getString("departamento"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarDEPT();
    }
}
