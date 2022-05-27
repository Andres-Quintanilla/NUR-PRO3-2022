package practico4;

import java.util.Iterator;

public class lista<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected int tamanoCadena;

    public lista(){
        this.raiz = null;
        tamanoCadena = 1;
    }

    public void adicionar(E o){
        Nodo<E> nuevo = new Nodo<>(o);

        if(raiz == null){
            raiz = nuevo;
            tamanoCadena++;
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
        tamanoCadena++;
    }

    public void eliminar(int pos){
        if (pos < 0){
            throw new ArrayIndexOutOfBoundsException("La lista solo tiene: " + tamanoCadena);
        }

        if(pos == 0){
            raiz = raiz.getSiguiente();
            tamanoCadena--;
            return;
        }

        Nodo<E> actual = raiz;
        int posActual = 0;
        while (posActual < (pos - 1)){
            posActual++;
            actual = actual.getSiguiente();
        }

        Nodo<E> siguienteDelSiguiente = actual.getSiguiente().getSiguiente();
        actual.getSiguiente().setSiguiente(null);
        actual.setSiguiente(siguienteDelSiguiente);
        tamanoCadena--;
    }

    public int tamano(){
        return this.tamanoCadena;
    }
    public E obtener(int pos) {
        if (pos == 0)
            return raiz.getContenido();

        int posActual = 0;
        Nodo<E> actual = raiz;
        while(posActual < pos && actual != null) {
            actual = actual.getSiguiente();
            posActual += 1;
        }

        return actual.getContenido();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
    }

    static class Nodo<E>{
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E contenido){
            this.contenido = contenido;
            this.siguiente = null;
        }

        public E getContenido(){
            return contenido;
        }

        public Nodo<E> getSiguiente(){
            return siguiente;
        }

        public void  setSiguiente(Nodo<E> siguiente){
            this.siguiente = siguiente;
        }
    }

    static class  IteradorLista<E> implements Iterator<E>{
        private Nodo<E> actual;

        public IteradorLista(Nodo<E> r){
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

