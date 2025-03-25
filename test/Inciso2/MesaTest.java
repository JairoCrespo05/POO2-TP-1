package Inciso2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    @Test
    void CostructorMesaTest(){

        var exception = assertThrows(RuntimeException.class, () -> {
            var mesa = new Mesa(0);
        });

        assertEquals(Mesa.CANT_SILLAS_INVALIDA, exception.getMessage());
    }


    @Test
    void TarjetaVisa() {

        var cliente = new Comensal("Julian", "Alvarez");

        var visa = new Visa(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        cliente.asignarTarjeta(visa);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);

        mesa.hacerPedido(cliente, comida, 1, bebida, 1);

        assertEquals(9703, visa.miSaldoEs());
    }

    @Test
    void TarjetaMastercard() {

        var cliente = new Comensal("Julian", "Alvarez");

        var masterCard = new MasterCard(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        cliente.asignarTarjeta(masterCard);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);

        mesa.hacerPedido(cliente, comida, 1, bebida, 1);

        assertEquals(9704, masterCard.miSaldoEs());

    }

    @Test
    void TarjetaComarcaPlus() {

        var cliente = new Comensal("Julian", "Alvarez");

        var comarcaPlus = new ComarcaPlus(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        cliente.asignarTarjeta(comarcaPlus);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);

        mesa.hacerPedido(cliente, comida, 1, bebida, 1);

        assertEquals(9706, comarcaPlus.miSaldoEs());

    }

    @Test
    void TarjetaViedma() {

        var cliente = new Comensal("Julian", "Alvarez");

        var viedma = new TarjetSinDescuento(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 100);

        cliente.asignarTarjeta(viedma);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);

        mesa.hacerPedido(cliente, comida, 1, bebida, 1);

        assertEquals(9700, viedma.miSaldoEs());

    }

    @Test
    void SaldoInsuficiente() {

        var cliente = new Comensal("Julian", "Alvarez");

        var viedma = new TarjetSinDescuento(cliente, 231, LocalDate.parse("2025-04-16"));
        var mesa = new Mesa(10);
        var comida = new Alimento("Hamburguesa", 200);
        var bebida = new Alimento("Pepsi", 10000);

        cliente.asignarTarjeta(viedma);

        mesa.aniadirBebidaAMenu(bebida);
        mesa.aniadirComidaAMenu(comida);
        mesa.sentarseEnLaMesa(cliente);



        var exception = assertThrows(RuntimeException.class, ()->{
            mesa.hacerPedido(cliente, comida, 1, bebida, 1);
        });

        assertEquals(TarjetaDeCredito.SALDO_INSUFICIENTE, exception.getMessage());
    }

}