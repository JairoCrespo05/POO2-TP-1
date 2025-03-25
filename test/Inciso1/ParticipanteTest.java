package Inciso1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipanteTest {

    @Test
    public void ConstructorExceptionsTest(){

        var exception1 = assertThrows(RuntimeException.class, () -> {
            var participante = new Participante("", "morales", 543);
        });

        var exception2 = assertThrows(RuntimeException.class, () -> {
            var participante = new Participante("juan", "", 543);
        });

        assertEquals(Participante.NOMBRE_Y_APELLIDO_INVALIDO, exception1.getMessage());
        assertEquals(Participante.NOMBRE_Y_APELLIDO_INVALIDO, exception2.getMessage());
    }



}