package Inciso1;

public class Participante {

    static final String NOMBRE_Y_APELLIDO_INVALIDO = "El nombre y El apellido No pueden estar vacios";
    static final String DNI_INVALIDO = "El DNI No puede ser menor a 1";

    private String nombre;
    private String apellido;
    private int dni;
    private int puntosGanados;


    public Participante (String nombre, String apellido, int dni){
        checkNombreYApellido(nombre, apellido);
        checkDni(dni);

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.puntosGanados = 0;
    }

    public void sumarPuntos(){
        this.puntosGanados += 10;
    }

    public int misPuntos(){
        return this.puntosGanados;
    }

    public void checkNombreYApellido(String nombre, String apellido){
        if(nombre.isBlank() || apellido.isBlank()){
            throw new RuntimeException(NOMBRE_Y_APELLIDO_INVALIDO);
        }
    }

    public void checkDni(int dni){
        if(dni < 1){throw new RuntimeException(DNI_INVALIDO);}
    }

}
