package co.edu.uniquindio.poo.parqueadero;

public class Puesto {
    private int i;
    private int j;
    private boolean ocupado;
    private Vehiculo vehiculo;

    public Puesto(int i, int j) {
        assert i >= 0 && j >= 0;
        this.i = i;
        this.j = j;
        this.ocupado = false;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.ocupado = (vehiculo != null);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
