package co.edu.uniquindio.poo.parqueadero;

public class Main {
    public static void main(String[] args) {
        // En esta clase se aprecia el comportamiento de los métodos

        Tarifa tarifa = new Tarifa(50, 60, 70); // Inicializando la tarifa
        Parqueadero parqueadero = new Parqueadero("Parking lot", 7, 7, tarifa);

        Propietario propietario = new Propietario("Santiago Torres", "1858738");
        Carro carro = new Carro("145", "1918", propietario);
        MotoClasica moto1 = new MotoClasica("007", "2030", propietario, 47);
        MotoHibrida moto2 = new MotoHibrida("008", "2040", propietario, 80);

        System.out.println(carro.getDetalles());
        System.out.println("\n");

        parqueadero.estacionarVehiculo(carro, 1, 1);
        parqueadero.estacionarVehiculo(moto1, 2, 1);
        parqueadero.retirarVehiculo(2, 1);

        System.out.println(parqueadero.calcularTarifa(moto1, 1));
        System.out.println(parqueadero.calcularTarifa(moto2, 1));
        System.out.println(parqueadero.calcularTarifa(carro, 1));

        System.out.println("\n");

        System.out.println(parqueadero.generarReporteMensual());
        System.out.println("\n");
        System.out.println(parqueadero.generarReporteDiario());
        System.out.println("\n");

        System.out.println(parqueadero.getPropietarioDeVehiculoEnPuesto(1, 1));
        System.out.println("\n");

        parqueadero.imprimirRegistroVehiculos();
        System.out.println("\n");

        parqueadero.imprimirRegistroIngresos();
    }
}
