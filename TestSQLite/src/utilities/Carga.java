/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Alumno;

/**
 *
 * @author erandi
 */
public class Carga {
 public DefaultComboBoxModel cargaEdad (int min,int max){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            String edades[]=null;
            for (int i = min; i <=max; i++) {
                //    edades[i-min]=String.valueOf(i);
                    model.addElement(String.valueOf(i));
            }
            return model;
    }
 public DefaultComboBoxModel cargaGrado (){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
              //    edades[i-min]=String.valueOf(i);
                    model.addElement("Secundaria");
                    model.addElement("Preparatoria");
                    model.addElement("Licenciatura");
                    model.addElement("Posgrado");
        
            return model;
    }
 public DefaultComboBoxModel cargaPromedio (double min,double max){
             DefaultComboBoxModel model = new DefaultComboBoxModel();
            String edades[]=null;
            for (double i = min; i<=max; i=i+0.5) {
                //    edades[i-min]=String.valueOf(i);
                    model.addElement(String.valueOf(i));
            }
            return model;

    }
    public DefaultTableModel cargaAlumnos() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class; //nombre
                    case 1:
                        return String.class;  //apellido
                    case 2:
                        return Double.class;  //promedio
                    case 3:
                        return String.class;  //grado
                    case 4:
                        return Integer.class;  //edad
                    case 6:
                        return Boolean.class;  //beca
                    case 7:
                        return String.class;  //fechaNacimiento
                    
                    default:
                        return String.class;  
                        
                        
                      
                }
            }
        };
        //datos de la primera tabla
        String[] columnNames = {"Nombre", "Apellido","Promedio","Edad","Beca","Fecha Nacimiento"};
        
        ArrayList <Alumno> listaA = new ArrayList<>();
        Conector con = new Conector();
        con.connect();
        listaA=con.buscarAlumnos();
        con.close();
        Object matriz[][]=  new Object[listaA.size()][7];
         int i=0;
        for(Alumno alumX: listaA){
         
            Object [] row = {alumX.getNombre(),alumX.getApellido(), alumX.getPromedio(),
                            alumX.getEdad(),alumX.getBeca(),alumX.getFechaNacimiento(),
                            };
            matriz[i][0]=alumX.getNombre();
            matriz[i][1]=alumX.getApellido();
            matriz[i][2]=alumX.getPromedio();
            matriz[i][3]= alumX.getEdad();
            if(alumX.getBeca().equals("true")){
                matriz[i][4]=true;
            }
            else{
                matriz[i][4]=false;
            }
            matriz[i][5]=alumX.getFechaNacimiento();
            
            
            
            i++;
        }
      //  model.setColumnIdentifiers(columnNames);
        //Object[][] data = {{"panadol", "0.50", true}, {"dolofan", "0.80", false}, {"bismutol", "1.20", true},
        //{"Mejoral", "1.50", false}, {"Fortex", "2.50", true}, {"Antalgina", "0.70", true}, {"Calcibon", "5.00", true}};

        //Agrega los datos al modelo
       model.setDataVector(matriz, columnNames);

        return model;

    }
}
