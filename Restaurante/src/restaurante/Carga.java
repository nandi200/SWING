/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author erandi
 */
public class Carga {
    public DefaultComboBoxModel cargaEdad (int min,int max){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            String edades[]=null;
            for (int i = min; i <max; i++) {
                //    edades[i-min]=String.valueOf(i);
                    model.addElement(String.valueOf(i));
            }
            return model;
    }
 public DefaultComboBoxModel cargaEntrada (){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
              //    edades[i-min]=String.valueOf(i);
                    model.addElement("tamal");
                    model.addElement("godita");
                    model.addElement("tlatoyo");
        
            return model;
    }
  public DefaultComboBoxModel cargaPrincipal (){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
                   model.addElement("pollo");
                   model.addElement("res");
                   model.addElement("pescado");
           
            return model;
    }
   public DefaultComboBoxModel cargaPostre (){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
               model.addElement("manzana");
               model.addElement("gelatina");
               model.addElement("pastel");
          
            return model;
    }
    
}
