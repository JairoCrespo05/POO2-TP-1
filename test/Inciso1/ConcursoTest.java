package Inciso1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {


    @Test
    public void testInscribirParticipante(){

        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Inciso1.Concurso", LocalDate.now(), LocalDate.parse("2025-03-16"));



        var inscripcion = new Inscripcion(particpante, LocalDate.now(), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        assertTrue(concurso.EstaInscripto(particpante));



    }

    @Test
    public void testPrimerDia(){
        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Inciso1.Concurso", LocalDate.now(), LocalDate.parse("2025-03-16"));



        var inscripcion = new Inscripcion(particpante, LocalDate.now(), concurso);

        inscripcion.inscribirAlConcurso(concurso);

        assertTrue(particpante.misPuntos() == 10);


    }

    @Test
    public void testFueraDeRango(){

        var particpante = new Participante("juan", "alvarez", 45);

        var concurso = new Concurso("Gran Inciso1.Concurso", LocalDate.now(), LocalDate.parse("2025-03-16"));

        var inscripcion = new Inscripcion(particpante, LocalDate.parse("2025-03-12"), concurso);

//        inscripcion.inscribirAlConcurso(concurso);


        assertThrows(RuntimeException.class, () -> {
            inscripcion.inscribirAlConcurso(concurso);
        });
    }

//    @Test
//    void validarFechaInscripcion() {
//
//    }
//
//    @Test
//    void esPrimerDia() {
//
//    }
//
//    @Test
//    void agregarParticipante() {
//
//    }
//
//    @Test
//    void estaInscripto() {
//
//    }
}