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
    private Double promedio;
    private int edad;
    private String beca;

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }
    private String fechaNacimiento;

    public Alumno(){};
    public Alumno(String nombre, String apellido, Double promedio, int edad, String beca, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
        this.edad = edad;
        this.beca = beca;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
  
    
}
