package Inciso1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    void ForzarExceptionsConstructor() {
        var concurso = new Concurso("concurso1", LocalDate.now(), LocalDate.parse("2025-04-27"));
        var participante = new Participante("Juan", "Martinez", 345);

        var exception1 = assertThrows(RuntimeException.class,  () -> {
            var inscripcion = new Inscripcion(null, LocalDate.now(), concurso);
        });

        var exception2 = assertThrows(RuntimeException.class,  () -> {
            var inscripcion2 = new Inscripcion(participante, LocalDate.now(), null);
        });

        assertEquals(Inscripcion.PARTICIPANTE_INVALIDO, exception1.getMessage());
        assertEquals(Inscripcion.CONCURSO_INVALIDO, exception2.getMessage());

    }
}