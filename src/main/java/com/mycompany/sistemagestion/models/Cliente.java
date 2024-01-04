/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion.models;

/**
 *
 * @author ortiz
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private int edad;
    private int numeroTelefonico;
    
    public Cliente(String nombre, int edad, int numeroTelefonico){
        this.nombre=nombre;
        this.edad=edad;
        this.numeroTelefonico=numeroTelefonico;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
        
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public int getNumeroTelefonico(){
        return this.numeroTelefonico;
    }
    
    public int setId(int id){
        this.id=id;
        return this.id;
    }
    
    public String setNombre(String nombre){
        this.nombre=nombre;
        return this.nombre;
    }
    
    public int setEdad(int edad){
        this.edad=edad;
        return this.edad;
    }
    
    public int setNumeroTelefonico(int numeroTelefonico){
        this.numeroTelefonico=numeroTelefonico;
        return this.numeroTelefonico;
    }
    
}
