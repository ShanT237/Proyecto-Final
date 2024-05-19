package co.edu.uniquindio.poo.parqueadero;

public class ReporteDiario {
    private Parqueadero parqueadero;

    public ReporteDiario(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String generar() {
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;
        double totalCarro = 0;

        for (Vehiculo v : parqueadero.getRegistroVehiculos()) {
            if (v instanceof Moto) {
                String tipoMoto = v.getClass().getSimpleName();
                if (tipoMoto.equalsIgnoreCase("MotoClasica")) {
                    totalMotoClasica += parqueadero.calcularTarifa(v, 1); // 1 hora
                } else {
                    totalMotoHibrida += parqueadero.calcularTarifa(v, 1);
                }
            } else if (v instanceof Carro) {
                totalCarro += parqueadero.calcularTarifa(v, 1);
            }
        }

        return "Reporte Diario:\n" +
                "Moto Clásica: " + totalMotoClasica + "\n" +
                "Moto Híbrida: " + totalMotoHibrida + "\n" +
                "Carro: " + totalCarro + "\n" +
                "Total: " + (totalMotoClasica + totalMotoHibrida + totalCarro);
    }
}
