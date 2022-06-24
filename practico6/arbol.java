package practico6;

import practico6.lista;

public class arbol<E>{
    private nodo<E> raiz;

    public arbol(){
        raiz = null;
    }

    public void insertar(E o, String id, String idPadre){
        nodo<E> nuevo = new nodo<>(o,id);

        if (raiz == null && idPadre == null){
            raiz = nuevo;
            return;
        }
        nodo<E> aux = buscar(idPadre);
        aux.getHijos().adicionar(nuevo);
    }

    public nodo<E> buscar(String id){
        return raiz.encontrar(id);
    }

    public static class nodo<E>{
        private String id;
        private E contenido;
        private lista<nodo<E>> hijos;

        public nodo(E o, String id){
            this.hijos = new lista<nodo<E>>();
            this.contenido = o;
            this.id = id;
        }

        public E getContenido(){
            return contenido;
        }

        public void setContenido(E contenido){
            this.contenido = contenido;
        }

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }

        public void setHijos(lista<nodo<E>> hijos){
            this.hijos = hijos;
        }

        public lista<nodo<E>> getHijos(){
            return hijos;
        }

        public nodo<E> encontrar(String id){
            if (this.id.equalsIgnoreCase(id)){
                return this;
            }

            for (nodo<E> hijo:hijos) {
                nodo<E> encontrado = hijo.encontrar(id);
                if (encontrado != null){
                    return encontrado;
                }
            }
            return null;
        }

        public void setPadre(nodo<E> padre){
            if (padre == null){
                return;
            }

            for (nodo<E> hijo:padre.hijos) {
                if (hijo.equals(this)){
                    return;
                }
            }
            padre.getHijos().adicionar(this);
        }
    }
}
