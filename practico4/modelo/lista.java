package practico4.modelo;

import java.util.Iterator;

public class lista<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected int cantidad;

    public lista(){
        this.raiz = null;
        cantidad = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
    }

    public void eliminar(int pos) {

        if (pos < 0 || pos > cantidad) {
            throw new ArrayIndexOutOfBoundsException("La lista solo tiene " + cantidad);
        }

        if (pos == 0){
            raiz = raiz.getSiguiente();
            cantidad--;
            return;
        }

        Nodo<E> actual = raiz;
        int posActual = 0;
        while(posActual < (pos-1)) {
            posActual++;
            actual = actual.getSiguiente();
        }

        Nodo<E> siguienteDelSiguiente = actual.getSiguiente().getSiguiente();
        actual.getSiguiente().setSiguiente(null);
        actual.setSiguiente(siguienteDelSiguiente);
        cantidad--;
    }

    static class Nodo<E>{
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return "Nodo{" + contenido +'}';
        }
    }

    static class IteradorLista<E> implements Iterator<E> {

        private Nodo<E> actual;
        public IteradorLista(Nodo<E> r) {
            actual = r;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E o = actual.getContenido();
            actual = actual.getSiguiente();
            return o;
        }
    }
}
