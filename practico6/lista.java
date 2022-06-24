package practico6;

import java.util.Iterator;

public class lista<E> implements Iterable<E>{
   protected nodo<E> raiz;
   protected int tamano;

   public lista(){
       tamano = 0;
   }

   public nodo<E> getRaiz(){
       return raiz;
   }

   public void setRaiz(nodo<E> raiz){
       this.raiz = raiz;
   }

   public int getTamano(){
       return tamano;
   }

   public void insertar(E o){
       nodo<E> nuevo = new nodo<>(o);
       nuevo.setSiguiente(raiz);
       raiz = nuevo;
       tamano++;
   }

   public void adicionar(E o){
       nodo<E> nuevo = new nodo<>(o);

       if (raiz == null){
           raiz = nuevo;
           tamano++;
           return;
       }

       nodo<E> actual = raiz;
       while (actual.getSiguiente() != null){
           actual = actual.getSiguiente();
       }

       actual.setSiguiente(nuevo);
       tamano++;
   }

   public void eliminar(int pos){
       if (pos >= tamano){
           return;
       }

       if (pos == 0){
           raiz = raiz.getSiguiente();
           tamano--;
           return;
       }

       int aux = 0;
       nodo<E> actual = raiz;
       while (actual != null && aux < (pos - 1)){
           actual = actual.getSiguiente();
           aux++;
       }

       actual.setSiguiente(actual.getSiguiente().getSiguiente());
       tamano--;
   }

   public E get(int pos){
       if (pos >= tamano){
           return null;
       }

       if (pos == 0){
           return raiz.getContenido();
       }

       int aux = 0;
       nodo<E> actual = raiz;
       while (actual != null && aux < pos){
           actual = actual.getSiguiente();
           aux++;
       }

       return actual.getContenido();
   }

   public E buscar(E id){
       for (E o:this) {
           if (o.equals(id)){
               return o;
           }
       }
       return null;
   }


    @Override
    public Iterator<E> iterator() {
        return new Iteradorlista<E>(this);
    }

     static class nodo<E>{
        private E contenido;
        private nodo<E> siguiente;

        public nodo(E o){
            contenido = o;
            siguiente = null;
        }

        public E getContenido(){
            return contenido;
        }

        public nodo<E> getSiguiente(){
            return siguiente;
        }

        public void setSiguiente(nodo<E> siguiente){
            this.siguiente = siguiente;
        }
    }

    static class Iteradorlista<E> implements Iterator<E>{
        private nodo<E> actual;
        public Iteradorlista(lista<E> lista){
            actual = lista.getRaiz();
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
