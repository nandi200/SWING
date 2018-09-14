/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import utilities.Conector;

/**
 *
 * @author erandi
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private String edoCivil;
    private double promedio;
    
    public Alumno(){
    }
    public Alumno(String nombre, String apellido, int edad, String edoCivil, double promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.edoCivil = edoCivil;
        this.promedio = promedio;
    }
 
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the edoCivil
     */
    public String getEdoCivil() {
        return edoCivil;
    }

    /**
     * @param edoCivil the edoCivil to set
     */
    public void setEdoCivil(String edoCivil) {
        this.edoCivil = edoCivil;
    }

    /**
     * @return the promedio
     */
    public double getPromedio() {
        return promedio;
    }

    /**
     * @param promedio the promedio to set
     */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    
}
