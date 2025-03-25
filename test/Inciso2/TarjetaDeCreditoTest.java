package Inciso2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaDeCreditoTest {

    @Test
    void TdeCreditoConstructorTest(){

        var titular = new Comensal("Julio","Fernandez");

        var exception1 =assertThrows(RuntimeException.class, () -> {
            var tarjeta = new Visa(null, 1234, LocalDate.parse("2025-05-2"));
        });

        var exception2 =assertThrows(RuntimeException.class, () -> {
            var tarjeta = new Visa(titular, 0, LocalDate.parse("2025-05-2"));
        });

        var exception3 =assertThrows(RuntimeException.class, () -> {
            var tarjeta = new Visa(titular, 1234, LocalDate.parse("2025-05-2"));
        });

        assertEquals(TarjetaDeCredito.TITULAR_NULO, exception1.getMessage());
        assertEquals(TarjetaDeCredito.NUMERO_TARJETA_INVALIDO, exception2.getMessage());
        assertEquals(TarjetaDeCredito.TARJETA_VENCIDA, exception3.getMessage());
    }



}