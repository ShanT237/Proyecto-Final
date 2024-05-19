package co.edu.uniquindio.poo.parqueadero;

public class Tarifa {
    private double tarifaMotoClasica;
    private double tarifaMotoHibrida;
    private double tarifaCarro;

    public Tarifa(double tarifaMotoClasica, double tarifaMotoHibrida, double tarifaCarro) {
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifaCarro = tarifaCarro;
    }

    public double getTarifaMotoClasica() {
        return tarifaMotoClasica;
    }

    public void setTarifaMotoClasica(double tarifaMotoClasica) {
        this.tarifaMotoClasica = tarifaMotoClasica;
    }

    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    public void setTarifaMotoHibrida(double tarifaMotoHibrida) {
        this.tarifaMotoHibrida = tarifaMotoHibrida;
    }

    public double getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(double tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }
}
