package co.edu.uniquindio.poo.parqueadero;

public class Propietario {
    private String nombre;
    private String id;

    public Propietario(String nombre, String id) {
        assert nombre != null && id != null;
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Propietario [Nombre: " + nombre + ", ID: " + id + "]";
    }
}
