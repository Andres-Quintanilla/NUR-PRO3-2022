package practico5.modelo;

import practico5.lista;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeshacerYHacer extends lista<Imagen> implements PropertyChangeListener{
    Nodo<Imagen> actual;

    public DeshacerYHacer(){
        actual = null;
    }

    public void agregarCambio(Imagen img){
       if (primero == null){
           insertar(img);
           actual = primero;
           return;
       }

       if(actual.getSiguiente() != null){
           actual.getSiguiente().setAnterior(null);
           actual.setSiguiente(null);
            ultimo = actual;
       }

       this.adicionar(img);
       actual = ultimo;
    }

    public void deshacer(){
        if (actual != null && actual.getAnterior() != null){
            actual = actual.getAnterior();
        }
    }

    public void rehacer(){
        if (actual != null && actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
    }

    public Imagen clonarActual(){
        return actual.getContenido().clonar();
    }
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }
}
