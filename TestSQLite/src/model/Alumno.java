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
    private Integer id;
    private String nombre;
    private String apellido;
    private Double promedio;
    private String grado;
    private Integer edad;
    private String beca;
    private String fechaNacimiento;
    private byte [] alumnoImagen;

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public Alumno(){};
    public Alumno(Integer id,String nombre, String apellido, Double promedio, String grado, 
            int edad, String beca, String fechaNacimiento,byte [] alumnoImagen) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
        this.grado=grado;
        this.edad = edad;
        this.beca = beca;
        this.fechaNacimiento = fechaNacimiento;
        this.alumnoImagen = alumnoImagen;
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

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the alumnoImagen
     */
    public byte[] getAlumnoImagen() {
        return alumnoImagen;
    }

    /**
     * @param alumnoImagen the alumnoImagen to set
     */
    public void setAlumnoImagen(byte[] alumnoImagen) {
        this.alumnoImagen = alumnoImagen;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
  
    
}
