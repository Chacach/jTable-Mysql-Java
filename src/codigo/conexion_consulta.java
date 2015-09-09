/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author alexander
 */
public class conexion_consulta {
    static Connection conexion=null;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadometa;
    public static void conectar(){
        String ruta="jdbc:mysql://localhost/Prueba";
        String user="root";
        String pass="182411";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }
    public static ArrayList<Object[]> llenar_tabla(){
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        String q = "SELECT * FROM Datos";
        try {
            resultado=sentencia.executeQuery(q);
            resultadometa= resultado.getMetaData();
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                Object[] filas = new Object[resultadometa.getColumnCount()];
                for(int i = 0;i<resultadometa.getColumnCount();i++){
                    filas[i]= resultado.getObject(i+1);
                }
                datos.add(filas);
            }
        } catch (Exception e) {
        }
        return datos;
    
    }
 public static ArrayList<Object[]> buscar_tabla(String Nombre){
        ArrayList<Object[]> datos = new ArrayList<Object[]>();
        String q = "SELECT * FROM Datos" + " WHERE Nombre='"+Nombre+"'";
        try {
            resultado=sentencia.executeQuery(q);
            resultadometa= resultado.getMetaData();
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                Object[] filas = new Object[resultadometa.getColumnCount()];
                for(int i = 0;i<resultadometa.getColumnCount();i++){
                    filas[i]= resultado.getObject(i+1);
                }
                datos.add(filas);
            }
        } catch (Exception e) {
        }
        return datos;
    
    }
}
