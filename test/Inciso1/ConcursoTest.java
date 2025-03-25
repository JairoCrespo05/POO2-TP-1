package Inciso1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {


    @Test
    public void testInscribirParticipante(){

        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Concurso", LocalDate.now(), LocalDate.parse("2025-10-16"));



        var inscripcion = new Inscripcion(particpante, LocalDate.now(), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        assertTrue(concurso.EstaInscripto(particpante));

    }

    @Test
    public void testPrimerDia(){
        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Concurso", LocalDate.now(), LocalDate.parse("2025-04-28"));



        var inscripcion = new Inscripcion(particpante, LocalDate.now(), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        assertEquals(10, particpante.misPuntos());


    }

    @Test
    public void testFueraDeRango(){

        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Concurso", LocalDate.now(), LocalDate.parse("2025-03-16"));

        var inscripcion = new Inscripcion(particpante, LocalDate.parse("2025-03-12"), concurso);

//        inscripcion.inscribirAlConcurso(concurso);


        var exception = assertThrows(RuntimeException.class, () -> {
            inscripcion.inscribirAlConcurso(concurso);
        });

        assertEquals(Inscripcion.FECHA_INVALIDA, exception.getMessage());
    }


}