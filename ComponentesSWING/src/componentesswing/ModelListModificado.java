/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesswing;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author erandi
 */
public class ModelListModificado extends AbstractListModel {

    private ArrayList<Alumno> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        Alumno p = lista.get(index);
        return p.getNombre();
    }

    public void addAlumno(Alumno p) {
        lista.add(p);
        //notifica al Jlis que un elemento ha sido modificado
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }

    public void eliminarAlumno(int index0) {
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize() + 1);

    }

    public Alumno getAlumno(int index) {
        return lista.get(index);
    }

}
