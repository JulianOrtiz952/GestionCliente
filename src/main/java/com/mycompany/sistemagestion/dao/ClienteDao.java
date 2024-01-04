/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion.dao;

import com.mycompany.sistemagestion.models.Cliente;
import com.mycompany.sistemagestion.models.Clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ortiz
 */
public class ClienteDao {
    
    public Connection conectar(){
        String baseDeDatos = "java";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        
        Connection conexion = null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);
           
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return conexion;
    
}
    
    public void agregar(Cliente cliente){
        
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `clientes` (`id`, `nombre`, `edad`, `numero_telefonico`) VALUES (NULL, '"+ cliente.getNombre()+"', '"+cliente.getEdad()+"', '"+cliente.getNumeroTelefonico()+"');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
   public ArrayList<Cliente> listar(){
        
        
        ArrayList<Cliente> listado = new ArrayList<>();
        
        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM `clientes` ";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()){
                
                Cliente cliente = new Cliente("", 0,0);
                cliente.setId(resultado.getInt("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setEdad(resultado.getInt("edad"));
                cliente.setNumeroTelefonico(resultado.getInt("numero_telefonico"));
                listado.add(cliente);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return listado;
    
}
   
    public void eliminar(int id){
        
        try {
            Connection conexion = conectar();
            String sql = "DELETE FROM clientes WHERE `clientes`.`id` = "+id;
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public void actualizar(Cliente cliente){
        try{
            Connection conexion = conectar();
            String sql = "UPDATE `clientes` SET `nombre` = '"+cliente.getNombre()+"', `edad` = '"+cliente.getEdad()+"', `numero_telefonico` = '"+cliente.getNumeroTelefonico()+"' WHERE `clientes`.`id` = "+cliente.getId()+";"; 
            
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        }   catch (Exception ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}