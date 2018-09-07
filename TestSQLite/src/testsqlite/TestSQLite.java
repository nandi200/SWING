/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

/**
 *
 * @author erandi
 */
public class TestSQLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Atxy2k", "SerProgramador.es",2,"hi",2.4);
 alumno.save();
 alumno.consultDatos();
 
    }
    
}
