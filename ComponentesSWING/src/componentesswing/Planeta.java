/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesswing;

/**
 *
 * @author erand
 */
public class Planeta {
   private String  nombre;
   private String  radio;
   private String  lunas;
   private boolean gaseoso;
   
   public Planeta(String nombre,String radio,String lunas, boolean gaseoso){
       this.nombre=nombre;
       this.lunas=lunas;
       this.radio=radio;
       this.gaseoso=gaseoso;
              
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
     * @return the radio
     */
    public String getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * @return the lunas
     */
    public String getLunas() {
        return lunas;
    }

    /**
     * @param lunas the lunas to set
     */
    public void setLunas(String lunas) {
        this.lunas = lunas;
    }

    /**
     * @return the gaseoso
     */
    public boolean isGaseoso() {
        return gaseoso;
    }

    /**
     * @param gaseoso the gaseoso to set
     */
    public void setGaseoso(boolean gaseoso) {
        this.gaseoso = gaseoso;
    }
}
