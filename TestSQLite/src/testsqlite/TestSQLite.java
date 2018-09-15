/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsqlite;

import java.util.ArrayList;
import java.util.Iterator;
import model.Alumno;
import utilities.Conector;

/**
 *
 * @author erandi
 */
public class TestSQLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      //  alumno.save();
       // save();
     //   consultDatos();
     //   consultScore(10);
     //   updateAlumno(10,"era",7.5);
      //  deleteAlumno("era");
      updatePicture("Atxy2k","/home/erandi/Documents/SWING/TestSQLite/src/image/farmacy2.png");
        consultDatos();
      
    }
    

  public static void consultDatos(){
        Conector con = new Conector();
        con.connect();
        ArrayList<Alumno> resul = new ArrayList<>();
        resul=con.buscarAlumnos();
        Iterator it = resul.iterator();
		while (it.hasNext()) {
                        Alumno alum= new Alumno();
                        alum=(Alumno)it.next();
			System.out.println(alum.getNombre() +" " + alum.getApellido());
		}
        con.close();
    }

  public static void consultScore(double score){
       Conector con = new Conector();
        con.connect();
        ArrayList<Alumno> resul = new ArrayList<>();
        resul=con.buscaXPromedioAlumnos(score);
        Iterator it = resul.iterator();
		while (it.hasNext()) {
                        Alumno alum= new Alumno();
                        alum=(Alumno)it.next();
			System.out.println(alum.getNombre() +" " + alum.getApellido());
		}
        con.close();
  }
  
  
  public static void updateAlumno(int edad, String nombre, double score){
       Conector con = new Conector();
        con.connect();
       boolean result=false;
        result=con.actualizaPromedioAlumno(edad,nombre,score);
        if (result){
            System.out.println("Actualizado");
        }else{
            System.out.println("No se pudo actualizar");
        }
        con.close();
  }
  
    public static void deleteAlumno(String nombre){
       Conector con = new Conector();
        con.connect();
       boolean result=false;
        result=con.borrarAlumno(nombre);
        if (result){
            System.out.println("Actualizado");
        }else{
            System.out.println("No se pudo actualizar");
        }
        con.close();
  }
    
    public static void  updatePicture(String name,String fileName){
         Conector con = new Conector();
        con.connect();
       con.updatePicture(name,fileName);
        System.out.println("se actualizo la imagen");
        con.close();
        
    
    }
}
