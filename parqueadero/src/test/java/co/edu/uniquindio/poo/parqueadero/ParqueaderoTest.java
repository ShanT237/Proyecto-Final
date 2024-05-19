package co.edu.uniquindio.poo.parqueadero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class ParqueaderoTest {
    private Parqueadero parqueadero;
    private Propietario propietario1;
    private Propietario propietario2;
    private MotoClasica motoClasica;
    private MotoHibrida motoHibrida;
    private Carro carro;
    private Tarifa tarifa;

    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @BeforeEach
    void setUp() {
        tarifa = new Tarifa(50, 60, 70); // Inicializando la tarifa
        parqueadero = new Parqueadero("Parking lot", 7, 7, tarifa);

        propietario1 = new Propietario("Santiago Torres", "1858738");
        propietario2 = new Propietario("Stella Jung", "2788188");

        motoClasica = new MotoClasica("007", "BMW R", propietario1, 50);
        motoHibrida = new MotoHibrida("008", "Ultraviolette", propietario1, 90);
        carro = new Carro("145", "Chevrolet", propietario2);
    }

    @Test
    void VerificarDatos() {
        LOG.info("Iniciado test verificar datos propietario");

        assertEquals("Stella Jung", propietario2.getNombre());
        assertEquals("1858738", propietario1.getId());

        LOG.info("Finalizando test verificar datos propietario");
    }

    @Test
    void testPropietarioNull() {
        LOG.info("Iniciado test propietario null");

        assertThrows(Throwable.class, () -> new Propietario(null, null));

        LOG.info("Finalizando test propietario null");
    }

    @Test
    void vehiculoCreado() {
        LOG.info("Iniciado test vehiculo creado");

        assertEquals("007", motoClasica.getPlaca());
        assertEquals("Ultraviolette", motoHibrida.getModelo());
        assertEquals(propietario2, carro.getPropietario());

        LOG.info("Finalizando test vehiculo creado");
    }

    @Test
    void vehiculoNull() {
        LOG.info("Iniciado test vehiculo null");

        assertThrows(Throwable.class, () -> new Carro(null, null, propietario2));

        LOG.info("Finalizando test vehiculo null");
    }

    @Test
    void testEstacionarVehiculo() {
        LOG.info("Iniciado test estacionar Vehiculo");

        assertTrue(parqueadero.estacionarVehiculo(motoClasica, 1, 1));
        assertFalse(parqueadero.estacionarVehiculo(motoHibrida, 1, 1));

        LOG.info("Finalizando test estacionar Vehiculo");
    }

    @Test
    void testEstacionarVehiculoFueraDeRango() {
        LOG.info("Iniciado test estacionar Vehiculo fuera de rango");
        assertThrows(IndexOutOfBoundsException.class, () -> parqueadero.estacionarVehiculo(motoClasica, 10, 10));
        LOG.info("Finalizando test estacionar Vehiculo fuera de rango");
    }

    @Test
    void testEstacionarVehiculoNegativo() {
        LOG.info("Iniciado test estacionar Vehiculo Negativo");

        assertThrows(Throwable.class, () -> parqueadero.estacionarVehiculo(motoHibrida, -1, -1));

        LOG.info("Finalizando test estacionar Vehiculo Negativo");
    }

    @Test
    void testPuestoNoMultipleVehiculos() {
        LOG.info("Iniciado test puesto no multiple vehiculos");
        parqueadero.estacionarVehiculo(motoClasica, 0, 0);
        assertFalse(parqueadero.estacionarVehiculo(motoHibrida, 0, 0));
        LOG.info("Finalizando test puesto no multiple vehiculos");
    }

    @Test
    void testRetirarVehiculo() {
        LOG.info("Iniciado test retirar Vehiculo");

        parqueadero.estacionarVehiculo(motoClasica, 0, 0);
        parqueadero.retirarVehiculo(0, 0);
        assertTrue(parqueadero.estacionarVehiculo(motoClasica, 0, 0)); // Se vuelve a estacionar para verificar si el
                                                                       // método funcionó
        LOG.info("Finalizando test retirar Vehiculo");
    }

    @Test
    void propietarioVehiculo() {
        LOG.info("Iniciado test verificar propietario");
        parqueadero.estacionarVehiculo(carro, 1, 1);
        parqueadero.estacionarVehiculo(motoClasica, 0, 1);

        assertEquals("Propietario [Nombre: Stella Jung, ID: 2788188]",
                parqueadero.getPropietarioDeVehiculoEnPuesto(1, 1));
        assertEquals("Propietario [Nombre: Santiago Torres, ID: 1858738]",
                parqueadero.getPropietarioDeVehiculoEnPuesto(0, 1));

        LOG.info("Finalizando test verificar propietario");
    }

    @Test
    void testCalcularTarifa() {
        LOG.info("Iniciado test calcular tarifa");

        assertEquals(50, parqueadero.calcularTarifa(motoClasica, 1)); // Se ingresa la cantidad de horas, en este caso
                                                                      // 1h

        LOG.info("Finalizando test calcular tarifa");
    }

    @Test
    void testCalcularTarifaNegativa() {
        LOG.info("Iniciado test calcular tarifa negativa");

        assertThrows(Throwable.class, () -> parqueadero.calcularTarifa(motoClasica, -1)); // Se ingresa la cantidad -

        LOG.info("Finalizando test calcular tarifa negativa");
    }

    @Test
    void testPuestoOcupado() {
        LOG.info("Iniciado test puesto ocupado");
        parqueadero.estacionarVehiculo(motoClasica, 3, 3);
        assertTrue(parqueadero.isPuestoOcupado(3, 3));
        assertFalse(parqueadero.isPuestoOcupado(0, 3));

        LOG.info("Finalizando test puesto ocupado");
    }

    @Test
    void testPuestoDisponible() {
        LOG.info("Iniciado test puesto disponible");
        parqueadero.estacionarVehiculo(motoClasica, 3, 3);
        assertTrue(parqueadero.isPuestoDisponible(1, 3));
        assertFalse(parqueadero.isPuestoDisponible(3, 3));

        LOG.info("Finalizando test puesto disponible");
    }

    @Test
    void testRetirarVehiculoYEstadoDelPuesto() {
        LOG.info("Iniciado test retirar vehiculo y estado del puesto");
        parqueadero.estacionarVehiculo(carro, 0, 0);
        parqueadero.retirarVehiculo(0, 0);
        assertFalse(parqueadero.isPuestoOcupado(0, 0));
        LOG.info("Finalizando test retirar vehiculo y estado del puesto");
    }

    @Test
    void testGenerarReporteDiario() {
        tarifa = new Tarifa(85, 90, 100);
        parqueadero = new Parqueadero("Parking lot", 7, 7, tarifa);

        parqueadero.estacionarVehiculo(motoClasica, 0, 1);
        parqueadero.estacionarVehiculo(motoHibrida, 1, 2);
        parqueadero.estacionarVehiculo(carro, 2, 3);
        String reporte = parqueadero.generarReporteDiario();
        assertTrue(reporte.contains("Moto Clásica: 85.0"));
        assertTrue(reporte.contains("Moto Híbrida: 90.0")); 
        assertTrue(reporte.contains("Carro: 100.0"));
    }

    @Test
    void testGenerarReporteMensual() {
        LOG.info("Iniciado test generar reporte mensual");

        tarifa = new Tarifa(50, 60, 70);
        parqueadero = new Parqueadero("Parking lot", 7, 7, tarifa);

        parqueadero.estacionarVehiculo(motoClasica, 0, 0);
        parqueadero.estacionarVehiculo(motoHibrida, 1, 1);
        parqueadero.estacionarVehiculo(carro, 2, 2);

        String reporteMensual = parqueadero.generarReporteMensual();

        // Verificar que el reporte contiene los valores esperados
        assertTrue(reporteMensual.contains("Total: 5400.0"));

        LOG.info("Finalizando test generar reporte mensual");
    }

    @Test
    void testListaDeVehiculosRegistrados() {
        LOG.info("Iniciado test lista de vehiculos registrados");
        parqueadero.estacionarVehiculo(carro, 0, 0);
        parqueadero.estacionarVehiculo(motoClasica, 1, 1);
        assertEquals(2, parqueadero.getRegistroVehiculos().size());
        LOG.info("Finalizando test lista de vehiculos registrados");
    }
}
