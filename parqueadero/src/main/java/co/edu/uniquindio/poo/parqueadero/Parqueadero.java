package co.edu.uniquindio.poo.parqueadero;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private String nombre;
    private Puesto[][] puestos;
    private Tarifa tarifa;
    private List<Vehiculo> registroVehiculos;
    private List<String> registroIngresos;

    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifa) {
        assert nombre != null;
        this.nombre = nombre;
        this.puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.puestos[i][j] = new Puesto(i, j);
            }
        }
        this.tarifa = tarifa;
        this.registroVehiculos = new ArrayList<>();
        this.registroIngresos = new ArrayList<>();
    }

    public boolean estacionarVehiculo(Vehiculo vehiculo, int i, int j) {
        if (puestos[i][j].getOcupado() || vehiculo.getPuesto() != null) {
            return false;
        }
        puestos[i][j].setOcupado(true);
        puestos[i][j].setVehiculo(vehiculo);
        vehiculo.setPuesto(puestos[i][j]);

        registroVehiculos.add(vehiculo);
        registroIngresos
                .add("Vehículo: " + vehiculo.getDetalles() + " estacionado en el puesto (" + i + ", " + j + ")");
        return true;
    }

    public void retirarVehiculo(int i, int j) {
        Puesto puesto = puestos[i][j];
        if (puesto.getOcupado()) {
            Vehiculo vehiculo = puesto.getVehiculo();
            puesto.setOcupado(false);
            puesto.setVehiculo(null);
            vehiculo.setPuesto(null);
        }
    }

    public boolean isPuestoOcupado(int i, int j) {
        return puestos[i][j].getOcupado();
    }

    public boolean isPuestoDisponible(int i, int j) {
        return !puestos[i][j].getOcupado();
    }

    public String getPropietarioDeVehiculoEnPuesto(int i, int j) {
        Puesto puesto = puestos[i][j];
        if (puesto.getOcupado()) {
            Vehiculo vehiculo = puesto.getVehiculo();
            if (vehiculo != null) {
                Propietario propietario = vehiculo.getPropietario();
                if (propietario != null) {
                    return propietario.toString();
                }
            }
        }
        System.out.println("El puesto está vacío");
        return "El puesto está vacío";
    }

    public double calcularTarifa(Vehiculo vehiculo, int horas) {
        assert horas >= 0;
        double tarifa = 0;
        if (vehiculo instanceof Moto) {
            String tipoMoto = vehiculo.getClass().getSimpleName();
            if (tipoMoto.equalsIgnoreCase("MotoClasica")) {
                tarifa = this.tarifa.getTarifaMotoClasica();
            } else {
                tarifa = this.tarifa.getTarifaMotoHibrida();
            }
        } else if (vehiculo instanceof Carro) {
            tarifa = this.tarifa.getTarifaCarro();
        }
        return tarifa * horas;
    }

    public String generarReporteDiario() {
        ReporteDiario reporteDiario = new ReporteDiario(this);
        return reporteDiario.generar();
    }

    public String generarReporteMensual() {
        ReporteMensual reporteMensual = new ReporteMensual(this);
        return reporteMensual.generar();
    }

    public void imprimirRegistroVehiculos() {
        System.out.println("Registro de Vehículos:");
        for (Vehiculo vehiculo : registroVehiculos) {
            System.out.println(vehiculo);
        }
    }

    public void imprimirRegistroIngresos() {
        System.out.println("Registro de Ingresos:");
        for (String ingreso : registroIngresos) {
            System.out.println(ingreso);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getRegistroVehiculos() {
        return registroVehiculos;
    }

    public void setRegistroVehiculos(List<Vehiculo> registroVehiculos) {
        this.registroVehiculos = registroVehiculos;
    }

    public List<String> getRegistroIngresos() {
        return registroIngresos;
    }

    public void setRegistroIngresos(List<String> registroIngresos) {
        this.registroIngresos = registroIngresos;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}