package practico5;

import java.util.Iterator;

public class lista<E> implements Iterable<E> {
    protected Nodo<E> primero;
    protected Nodo<E> ultimo;
    private int tamanoCadena;

    public lista() {
        primero = null;
        ultimo = null;
        tamanoCadena = 0;
    }

    public void insertar(E o){
        Nodo<E> nuevo = new Nodo<E>(o);
        if(primero != null){
            primero.setAnterior(nuevo);
        }
        nuevo.setSiguiente(primero);
        if (primero != null) {
            primero.setAnterior(nuevo);
        }
        primero = nuevo;
        if (ultimo == null) {
            ultimo = nuevo;
        }
        tamanoCadena++;
    }

    public void adicionar(E o){
       if (primero == null) {
           insertar(o);
           return;
       }
       Nodo<E> nuevo = new Nodo<E>(o);
       ultimo.setSiguiente(nuevo);
       nuevo.setAnterior(ultimo);
       ultimo = nuevo;
       tamanoCadena++;
    }

    public E obtener(int pos){
        if(pos == 0){
            return primero.getContenido();
        }

        int posActual = 0;
        Nodo<E> actual = primero;
        while(posActual < pos && actual != null){
            actual = actual.getSiguiente();
            posActual+= 1;
        }
        return actual.getContenido();
    }

    public int tamano(){
        return tamanoCadena;
    }

    public void eliminar(int pos){
        if (pos < 0 || pos > tamanoCadena) {
            throw new ArrayIndexOutOfBoundsException("La lista solo tiene: " + tamanoCadena + " elementos");
        }

        if (pos == 0) {
            primero = primero.getSiguiente();
            tamanoCadena--;
            return;
        }

        Nodo<E> actual = primero;
        int posActual = 0;
        while (posActual < (pos - 1)) {
            actual = actual.getSiguiente();
            posActual++;
        }

        Nodo<E> siguienteDelSiguiente = actual.getSiguiente().getSiguiente();
        actual.getSiguiente().setSiguiente(null);
        actual.setSiguiente(siguienteDelSiguiente);
        tamanoCadena--;

    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

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

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getAnterior(){
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior){
            this.anterior = anterior;
        }
    }

    public class Iterador<E> implements Iterator<E> {
        private Nodo<E> actual;

        public Iterador(Nodo<E> primero) {
            this.actual = primero;
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
