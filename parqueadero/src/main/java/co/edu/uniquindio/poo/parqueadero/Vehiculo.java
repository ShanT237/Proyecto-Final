package co.edu.uniquindio.poo.parqueadero;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario propietario;
    private Puesto puesto;

    public Vehiculo(String placa, String modelo, Propietario propietario) {
        assert placa != null && modelo != null && propietario != null;
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDetalles() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Propietario: " + propietario.getNombre();
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
}
