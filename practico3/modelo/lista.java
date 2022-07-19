package practico3.modelo;

import java.util.Iterator;

public class lista<E> implements Iterable<E> {
    protected lista.Nodo<E> raiz;
    protected int tamanoCadena;

    public lista(){
        this.raiz = null;
        tamanoCadena = 0;
    }

    public void adicionar(E o){
        lista.Nodo<E> nuevo = new lista.Nodo<>(o);

        if(raiz == null){
            raiz = nuevo;
            tamanoCadena++;
            return;
        }

        lista.Nodo<E> actual = raiz;
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

        lista.Nodo<E> actual = raiz;
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
        lista.Nodo<E> actual = raiz;
        while(posActual < pos && actual != null) {
            actual = actual.getSiguiente();
            posActual += 1;
        }

        return actual.getContenido();
    }

    @Override
    public Iterator<E> iterator() {
        return new lista.IteradorLista<>(raiz);
    }

    public static class Nodo<E>{
        private E contenido;
        private lista.Nodo<E> siguiente;

        public Nodo(E contenido){
            this.contenido = contenido;
            this.siguiente = null;
        }

        public E getContenido(){
            return contenido;
        }

        public lista.Nodo<E> getSiguiente(){
            return siguiente;
        }

        public void  setSiguiente(lista.Nodo<E> siguiente){
            this.siguiente = siguiente;
        }
    }

    static class  IteradorLista<E> implements Iterator<E> {
        private lista.Nodo<E> actual;

        public IteradorLista(lista.Nodo<E> r){
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
