/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erandi
 */
public class Carga {

    public DefaultComboBoxModel cargaEdad(int min, int max) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String edades[] = null;
        for (int i = min; i < max; i++) {
            //    edades[i-min]=String.valueOf(i);
            model.addElement(String.valueOf(i));
        }
        return model;
    }

    public DefaultComboBoxModel cargaEntrada() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        //    edades[i-min]=String.valueOf(i);
        model.addElement("tamal");
        model.addElement("godita");
        model.addElement("tlatoyo");

        return model;
    }

    public DefaultComboBoxModel cargaPrincipal() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("pollo");
        model.addElement("res");
        model.addElement("pescado");

        return model;
    }

    public DefaultComboBoxModel cargaPostre(int min, int max) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("manzana");
        model.addElement("gelatina");
        model.addElement("pastel");

        return model;
    }

    public DefaultTableModel cargaTablaPlanetas() {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Nombre", "Radio", "Lunas", "Gaseoso"};

        Object[][] data = {
            {"Mercurio", 2440.0, 0, false},
            {"Venus", 6052.0, 0, false},
            {"Tierra", 6378.0, 1, false},
            {"Marte", 3397.0, 2, false},
            {"Jupiter", 71492.0, 16, true},
            {"Saturno", 60268.0, 18, true},
            {"Urano", 25559.0, 17, true},
            {"Plutón", 1137.0, 1, false}};
        //Agrega los datos al modelo
        model.setDataVector(data, columnNames);

        return model;

    }

    public DefaultTableModel cargaProductosFarmacia() {
        DefaultTableModel model = new DefaultTableModel(){
         @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };  
        //datos de la primera tabla
        String[] columnNames = {"Nombre", "Precio","generico"};
        Object[][] data = {{"panadol","0.50",true}, {"dolofan","0.80",false}, {"bismutol","1.20",true},
        {"Mejoral","1.50",false}, {"Fortex", "2.50",true}, {"Antalgina", "0.70",true}, {"Calcibon", "5.00",true}};

        //Agrega los datos al modelo
        model.setDataVector(data, columnNames);

        return model;

    }
    
    public String [] cargaNombreCol(){
           String []col= {"Nombre","Precio","Cantidad","Total"};
        return col;
    }
}
