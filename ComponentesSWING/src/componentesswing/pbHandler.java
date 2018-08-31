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
public class pbHandler extends Thread{
    //propiedades
    private boolean life;
    private int order;
    private int prog;
    private javax.swing.JProgressBar progBar;
    
    //constructor
    public pbHandler(Object in){
      this.progBar =  (javax.swing.JProgressBar) in;
      this.life=true;
      this.prog=0;
    }
    
    public void kill(){
        this.life=false;
    
    }
    public void cmd (int in){ //setter asigna la orden
        this.setOrder(in);
    }
    public void run(){
     while(life){
         if(order==1){
             System.out.println("Hilo esta corriendo .." + this.getProg());
             this.setProg(this.getProg() + 1);
             this.progBar.setValue(this.getProg());
             try{
                 Thread.sleep(125);
             
             }catch (Exception e){
                 e.printStackTrace();
                 System.out.println("Error");
             }
         }
         if(this.getProg()==100){
             this.life=false;
             System.out.println("Hilo muerto");
         }
     
     
     }
    
    }

    /**
     * @return the prog
     */
    public int getProg() {
        return prog;
    }

    /**
     * @param prog the prog to set
     */
    public void setProg(int prog) {
        this.prog = prog;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }
}
