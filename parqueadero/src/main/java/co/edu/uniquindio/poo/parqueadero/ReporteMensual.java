package co.edu.uniquindio.poo.parqueadero;

public class ReporteMensual {
    private Parqueadero parqueadero;

    public ReporteMensual(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String generar() {
        double total = 0;

        for (Vehiculo v : parqueadero.getRegistroVehiculos()) {
            total += parqueadero.calcularTarifa(v, 30); // 30 dias
        }

        return "Reporte Mensual:\nTotal: " + total;
    }
}
