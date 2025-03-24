package Inciso2;

import java.time.LocalDate;
import java.util.List;

public class TarjetSinDescuento extends TarjetaDeCredito {

    public TarjetSinDescuento(Comensal apoderado, long numeroTarjeta, LocalDate fechaExpiracion){
        super(apoderado, numeroTarjeta, fechaExpiracion);
    }

    @Override
    public float aplicarDescuento(float precioBebidas, float precioComidas) {return precioBebidas + precioComidas;}


}
