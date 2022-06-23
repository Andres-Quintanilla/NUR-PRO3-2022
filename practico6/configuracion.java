package practico6;

public final class configuracion {
    private static configuracion instance;
    private String directorioBase;

    private  configuracion() {

    }

    public static configuracion getInstance(){
        if (instance == null){
            instance = new configuracion();
        }
        return instance;
    }
}
