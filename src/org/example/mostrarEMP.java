package org.example;
import java.sql.*;
public class mostrarEMP {
    //metod para mostrar los empleados de un depto
    public static void mostrarEMP(String nombreDep){
        //la consulta
        String sql = "SELECT e.nombre AS empleado, e.salario, d.nombre AS departamento " +
                "FROM empleado e " +
                "INNER JOIN departamento d ON e.departamento_id = d.id " +
                "WHERE d.nombre = ?";

        //el try anidado

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //rellenamos la consulta
            ps.setString(1, nombreDep);


            try (ResultSet rs = ps.executeQuery()) {

                //una vez ejecutado recorremos el resultset
                while (rs.next()) {
                    System.out.println(rs.getString("empleado") + " | " +
                            rs.getDouble("salario")  + " | " +
                            rs.getString("departamento"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }



    }

    //lo llamamos en el main
    public static void main(String[] args){
        mostrarEMP("Tecnología");
    }
}
