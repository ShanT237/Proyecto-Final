package co.edu.uniquindio.poo.parqueadero;

public class Moto extends Vehiculo {
    private float velocidadMaxima;

    public Moto(String placa, String modelo, Propietario propietario, float velocidadMaxima) {

        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
    }

    public float getVelocidadMaxima() {
        return velocidadMaxima;
    }

}
