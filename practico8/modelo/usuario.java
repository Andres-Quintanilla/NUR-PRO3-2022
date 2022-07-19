package practico8.modelo;

public class usuario {
    private String nombre,cuenta,password;

    public usuario(){

    }

    public usuario(String nombre,String cuenta,String password){
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
