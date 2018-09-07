/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos2;

import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author erandi
 */
public class Animation1 extends JApplet {
    
    private int index=0;
    //Arm coordinates
    int [] X_Right_Arm={140,150,160,150,140};
    int [] Y_Right_Arm={160,150,140,130,120};
    int [] X_Left_Arm={40,30,20,30,40};
    int [] Y_Left_Arm={160,150,140,130,120};
            
    //leg coodinates (parallel arrays)
    int [] X_Left_Leg={80,60,40,30,25};
    int [] Y_Left_Leg={330,320,310,300,290};
    int [] X_Rigth_Leg={90,110,120,130,135};
    int [] Y_Rigth_Leg={330,320,310,300,290};
    
    int ODL_X_Right_Arm=X_Right_Arm[0];
    int OLD_Y_Right_Arm=Y_Right_Arm[0];
    int ODL_X_Left_Arm= X_Left_Arm[0];
    int ODL_Y_Left_Arm=Y_Left_Arm[0];
    
    int ODL_X_Right_Leg=X_Rigth_Leg[0];
    int OLD_Y_Right_Leg=Y_Rigth_Leg[0];
    int ODL_X_Left_Leg= X_Left_Leg[0];
    int ODL_Y_Left_Leg=Y_Left_Leg[0];
    
    boolean firstTime = true;
    
    
    public void start(){
        index =0;
        firstTime=true;
    
    }
    public void paint(Graphics gr){
        if(firstTime){
            gr.drawOval(30, 30, 80, 80);
            gr.drawLine(85, 110, 85, 210);
            gr.drawLine(85, 210, 80, 330);
            gr.drawLine(85, 210, 90, 330);
            gr.drawLine(85, 140, 40, 160);
            firstTime=false;
        }
        gr.setColor(getBackground());
    
        gr.drawLine(85, 140, ODL_X_Right_Arm, OLD_Y_Right_Arm);
        gr.drawLine(85, 140, ODL_X_Left_Arm, ODL_Y_Left_Arm);
        gr.drawLine(85, 210, ODL_X_Left_Leg, ODL_Y_Left_Leg);
        gr.drawLine(85, 210, ODL_X_Right_Leg, OLD_Y_Right_Leg);
        
        
        gr.setColor(getBackground());
        
        gr.drawLine(85, 140, X_Right_Arm[index], Y_Right_Arm[index]);
        gr.drawLine(85, 140, X_Left_Arm[index], Y_Left_Arm[index]);
        gr.drawLine(85, 210, X_Left_Leg[index], Y_Left_Leg[index]);
        gr.drawLine(85, 210, X_Rigth_Leg[index], Y_Rigth_Leg[index]);
        
        
        //arms
        ODL_X_Right_Arm=X_Right_Arm[index];
        OLD_Y_Right_Arm=Y_Right_Arm[index];
        ODL_X_Left_Arm= X_Left_Arm[index];
        ODL_Y_Left_Arm=Y_Left_Arm[index];
        
        //leg
        ODL_X_Right_Leg=X_Rigth_Leg[index];
        OLD_Y_Right_Leg=Y_Rigth_Leg[index];
        ODL_X_Left_Leg= X_Left_Leg[index];
        ODL_Y_Left_Leg=Y_Left_Leg[index];

        ++index;
        
        if(index==X_Right_Arm.length){
            index=0;
        
        }
        
        try{ Thread.sleep(250);}
        catch(InterruptedException e){
            showStatus(e.toString());
        }
        repaint();
    }
    
}
