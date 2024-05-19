package co.edu.uniquindio.poo.parqueadero;

public class MotoHibrida extends Moto {

    public MotoHibrida(String placa, String modelo, Propietario propietario, float velocidadMaxima) {
        super(placa, modelo, propietario, velocidadMaxima);
        // TODO Auto-generated constructor stub
    }

    public String toString() {
        return "Moto Hibrida" + "- Placa: " + getPlaca() + ", Modelo: " + getModelo() + ", Propietario: "
                + getPropietario().getNombre() + ", Velocidad Máxima: " + getVelocidadMaxima();
    }

}
