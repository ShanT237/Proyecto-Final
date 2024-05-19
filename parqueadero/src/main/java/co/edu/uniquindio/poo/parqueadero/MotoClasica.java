package co.edu.uniquindio.poo.parqueadero;

public class MotoClasica extends Moto {

    public MotoClasica(String placa, String modelo, Propietario propietario, float velocidadMaxima) {
        super(placa, modelo, propietario, velocidadMaxima);
        // TODO Auto-generated constructor stub
    }

    public String toString() {
        return "Moto Clasica " + "- Placa: " + getPlaca() + ", Modelo: " + getModelo() + ", Propietario: "
                + getPropietario().getNombre() + ", Velocidad Máxima: " + getVelocidadMaxima();
    }

}
