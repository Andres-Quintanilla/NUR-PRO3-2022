package practico6.modelo;

import practico6.identificador;

public class documentos implements identificador {
    private String nombreNuevoArchivo;
    private String tipoDelArchivo;
    private int tamanoDelArchivo;
    private String nombreOriginalDelArchivo;
    protected String id;

    @Override
    public String getId() {
        return id;
    }

    public documentos(String id, String nombreNuevoArchivo, String tipoDelArchivo, int tamanoDelArchivo, String nombreOriginalDelArchivo){
        this.id = id;
        this.nombreNuevoArchivo = nombreNuevoArchivo;
        this.tipoDelArchivo = tipoDelArchivo;
        this.tamanoDelArchivo = tamanoDelArchivo;
        this.nombreOriginalDelArchivo = nombreOriginalDelArchivo;
    }

    public String getNombreNuevoArchivo() {
        return nombreNuevoArchivo;
    }

    public void setNombreNuevoArchivo(String nombreNuevoArchivo) {
        this.nombreNuevoArchivo = nombreNuevoArchivo;
    }

    public String getTipoDelArchivo() {
        return tipoDelArchivo;
    }

    public void setTipoDelArchivo(String tipoDelArchivo) {
        this.tipoDelArchivo = tipoDelArchivo;
    }

    public int getTamanoDelArchivo() {
        return tamanoDelArchivo;
    }

    public void setTamanoDelArchivo(int tamanoDelArchivo) {
        this.tamanoDelArchivo = tamanoDelArchivo;
    }

    public String getNombreOriginalDelArchivo() {
        return nombreOriginalDelArchivo;
    }

    public void setNombreOriginalDelArchivo(String nombreOriginalDelArchivo) {
        this.nombreOriginalDelArchivo = nombreOriginalDelArchivo;
    }
}
