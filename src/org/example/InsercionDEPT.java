package org.example;
import java.sql.*;

public class InsercionDEPT {

    //métod para hacer los INSERT por parámetros
    public static void insertDEP(String nombreDep, String nombreEmp,
                                 double salario, int depId) {
        //definimos las sentnecias SQL
        String sqlDep = "INSERT INTO departamento (nombre) VALUES (?)";
        String sqlEmp = "INSERT INTO empleado (nombre, salario, departamento_id) VALUES (?, ?, ?)";

        //hacemos el try with resources
        try (Connection conn = Conexion.getConnection();
             //declaramos los ps
        PreparedStatement psDep = conn.prepareStatement(sqlDep) ;
        PreparedStatement psEmp = conn.prepareStatement(sqlEmp);
        ){
            //añadimos los bloques para los ps
            psDep.setString(1, nombreDep);
            psDep.executeUpdate();

            psEmp.setString(1, nombreEmp);
            psEmp.setDouble(2, salario);
            psEmp.setInt(3, depId);
            psEmp.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
            insertDEP("Ventas",     "Ana García",  3500.0, 1);
            insertDEP("Tecnología", "María López", 4200.0, 2);
    }
}
