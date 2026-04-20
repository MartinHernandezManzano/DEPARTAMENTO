
        package org.example;
import org.example.Conexion;

import java.sql.*;

public class InsercionDEPT {

    //métod para hacer los INSERT por parámetros
    public static void insertDEP(int id, String nombreDep, String nombreEmp,
                                 double salario, int depId) {
        //definimos las sentnecias SQL
        // String sqlDep = "INSERT INTO departamento (nombre) VALUES (?)"; // ya existen los departamentos en la BD
        String sqlEmp = "INSERT INTO empleado (id, nombre, salario, departamento_id) VALUES (?, ?, ?, ?)";

        //hacemos el try with resources
        try (Connection conn = Conexion.getConnection();
             //declaramos los ps
             // PreparedStatement psDep = conn.prepareStatement(sqlDep); // comentado  porque departamentos ya existen
             PreparedStatement psEmp = conn.prepareStatement(sqlEmp)
        ){
            //añadimos los bloques para los ps
            // psDep.setString(1, nombreDep);
            // psDep.executeUpdate();

            psEmp.setInt(1, id);
            psEmp.setString(2, nombreEmp);
            psEmp.setDouble(3, salario);
            psEmp.setInt(4, depId);
            psEmp.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        insertDEP(13, "Ventas",     "Sandra", 3500.0, 1);
        insertDEP(14, "Tecnología", "Marta",  4200.0, 2);
    }
}
