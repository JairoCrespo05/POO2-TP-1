package Inciso1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    static final String YA_INSCRIPTO = "El Participante ya esta inscripto";
    static final String NOMBRE_CONCURSO_INVALIDO = "El nombre del Concurso no es valido";
    static final String FECHAS_INVALIDAS = "Las Fechas del Concurso no son validas";

    private String nombreConcurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> inscriptos;

    public  Concurso(String nombreCurso, LocalDate fechaInicio, LocalDate fechaFin){
        checkNombreConcurso(nombreCurso);
        checkFechasValidas(fechaInicio, fechaFin);

        this.nombreConcurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos =  new ArrayList<>();
    }


    public boolean validarFechaInscripcion(Inscripcion inscripcion){

        inscripcion.laFechaEsValida(this.fechaInicio, this.fechaFin);

        return true;
    }

    public boolean esPrimerDia(LocalDate fecha){
        if (fecha.equals(this.fechaInicio)) return true;
        return false;
    }



    public void agregarParticipante(Participante participante, Inscripcion inscripcion)throws RuntimeException{
        if(EstaInscripto(participante)){
            throw new RuntimeException(YA_INSCRIPTO);
        }
        if(validarFechaInscripcion(inscripcion)){
            inscriptos.add(participante);
        }
    }

    public boolean EstaInscripto(Participante participante){
        if(inscriptos.contains(participante)) return true;
        return false;
    }

    public void checkNombreConcurso(String nombreConcurso){
        if(nombreConcurso.isBlank()){throw new RuntimeException(NOMBRE_CONCURSO_INVALIDO);}
    }

    public void checkFechasValidas(LocalDate fechaIni, LocalDate fechaFin){
        if(fechaIni == null || fechaFin == null){throw new RuntimeException(FECHAS_INVALIDAS);}
    }

}
