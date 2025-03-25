package Inciso2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorDeMenuTest {

    @Test
    void AlimentosNoEncontrados(){
        var menu = new GestorDeMenu();
        var comida = new Alimento("Pancho", 230);
        var bebida = new Alimento("Baggio", 143);

        var exception1 = assertThrows(RuntimeException.class, () -> {
          menu.elegirDelMenuBebidas(bebida, 1);
        });

        var exception2 = assertThrows(RuntimeException.class, () -> {
            menu.elegirDelMenuComidas(comida, 1);
        });

        assertEquals(GestorDeMenu.BEBIDA_NO_ENCONTRADA, exception1.getMessage());
        assertEquals(GestorDeMenu.COMIDA_NO_ENCONTRADA, exception2.getMessage());
    }

    @Test
    void AlimentosExceptions() {

        var exception1 = assertThrows(RuntimeException.class, () -> {
            var comida = new Alimento("", 234);
        });

        var exception2 = assertThrows(RuntimeException.class, () -> {
            var comida = new Alimento("Papas", 0);
        });

        assertEquals(Alimento.NOMBRE_VACIO, exception1.getMessage());
        assertEquals(Alimento.PRECIO_INVALIDO, exception2.getMessage());
    }

}