package co.edu.uniquindio.poo.parqueadero;

public class Carro extends Vehiculo {
    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario);
    }

    public String toString() {
        return "Carro - Placa: " + getPlaca() + ", Modelo: " + getModelo() + ", Propietario: "
                + getPropietario().getNombre();
    }
}
