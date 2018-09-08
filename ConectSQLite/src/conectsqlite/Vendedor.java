/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectsqlite;

/**
 *
 * @author erand
 */
public class Vendedor {
    String nombre;
    Double edad;
    String plaza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public Vendedor(String nombre, Double edad, String plaza) {
        this.nombre = nombre;
        this.edad = edad;
        this.plaza = plaza;
    }
}
