/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;


public class Menu {
    public int entrada;
    public int principal;
    public int postre;
    
    public Menu (int entrada, int principal, int postre){
        this.entrada=entrada;
        this.principal=principal;
        this.postre=postre;
    
    }
    
    public double calculaCalorias(){
            double ent,prin,pos,resultado =0;
            ent=calculaCaloriasEntrada();
            prin=calculaCaloriasPrincipal();
            pos=calculaCaloriasPostre();
            resultado=ent+pos+prin;
            
        return resultado;    
    }
    
    public double calculaCaloriasEntrada (){
        double caloriasEntrada=0.0;
        switch(entrada){
            case 0: 
                          caloriasEntrada=500;
                          break;
            case 1: 
                          caloriasEntrada=100;
                          break;
            case 2: 
                          caloriasEntrada=600;
                          break;
        }
        return caloriasEntrada;
    }
    public double calculaCaloriasPostre (){
     double caloriasPostre=0.0;
        switch(postre){
            case 0: 
                          caloriasPostre=300; //flan
                          break;
            case 1: 
                          caloriasPostre=50; //manzana
                          break;
            case 2: 
                          caloriasPostre=900; //pastel
                          break;
        }
        return caloriasPostre;
    
    }
    public double calculaCaloriasPrincipal (){
         double caloriasPrincipal=0.0;
        switch(principal){
            case 0: 
                          caloriasPrincipal=80; //filete de res
                          break;
            case 1: 
                          caloriasPrincipal=500; //pollo
                          break;
            case 2: 
                          caloriasPrincipal=1200; //cabrito
                          break;
        }
        return caloriasPrincipal;
    
    }
}
