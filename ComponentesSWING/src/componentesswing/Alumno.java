/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesswing;

/**
 *
 * @author erandi
 */
public class Alumno {
 private String Nombre;
 private String Apellido;
 private Integer edad;

    /**
     * @return the Nombre
     */
   public Alumno(){}
   public Alumno(String nombre,String apellido, Integer edad){
   
     this.Nombre=nombre;
     this.Apellido=apellido;
     this.edad=edad;
   }
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
