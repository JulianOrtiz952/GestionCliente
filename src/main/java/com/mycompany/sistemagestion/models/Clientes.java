/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion.models;

import com.mycompany.sistemagestion.dao.ClienteDao;
import java.util.ArrayList;

/**
 *
 * @author ortiz
 */
public class Clientes {
    
    private String nombre;
    ClienteDao clienteDao = new ClienteDao();
    
    public ArrayList <Cliente> clientes = new ArrayList<Cliente>();
    public Clientes(){
        
        clientes = clienteDao.listar();
    }
    
    public ArrayList agregar(String nombre, int edad, int numeroTelefonico){
        Cliente cliente = new Cliente(nombre, edad, numeroTelefonico);
        clientes.add(cliente);
        return clientes;
    }
    
    public boolean eliminar(Cliente cliente){
        boolean eliminado=false;
        for(int i=0; i<clientes.size(); i++){
            if(cliente.equals(clientes.get(i))){
                clientes.remove(i);
                eliminado=true;
            }
        }
        return eliminado;
    }
    
    
}
