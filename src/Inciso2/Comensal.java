package Inciso2;

public class Comensal {

    static final String NOMBRE_Y_APELLIDO_INVALIDO = "El nombre y El apellido No pueden estar vacios";
    private String nombre;
    private String apellido;
    private TarjetaDeCredito tarjetaDeCredito;

    public Comensal(String nombre, String apellido){

        checkApellidoYNombre(nombre, apellido);

        this.nombre = nombre;
        this.apellido = apellido;

    }

    public void asignarTarjeta(TarjetaDeCredito tarjeta){this.tarjetaDeCredito = tarjeta;}


    public void pedirLaCuenta(float precioBebidas, float precioComidas){

        float montoAPagar = this.tarjetaDeCredito.aplicarDescuento(precioBebidas, precioComidas);
        this.tarjetaDeCredito.pagar(montoAPagar);
        //Pago con Propina
        //this.tarjetaDeCredito.pagarMasPropina(montoAPagar, Propina.BAJA);
    }

    public boolean checkApellidoYNombre(String apellido, String name){
        if(name.isBlank() || apellido.isBlank()){
            throw new RuntimeException(NOMBRE_Y_APELLIDO_INVALIDO);
        }
        return true;
    }


}
