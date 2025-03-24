package Inciso2;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    static final String CANT_SILLAS_INVALIDA = "Cantidad de sillas Insuficiente";
    private GestorDeMenu menu;
    private List<Comensal> clientes;
    private int cantidadSillas;


    public Mesa(int cantidadSillas){
        checkCantSillas(cantidadSillas);

        this.cantidadSillas = cantidadSillas;
        this.clientes = new ArrayList<>();
        this.menu = new GestorDeMenu();
    }

    public void sentarseEnLaMesa(Comensal cliente){ clientes.add(cliente); }

    public void aniadirComidaAMenu(Alimento comida){ menu.agregarComida(comida); }

    public void aniadirBebidaAMenu(Alimento bebida){ menu.agregarBebida(bebida); }

    public void checkCantSillas(int cantSillas){
        if(cantSillas <= 0){throw new RuntimeException(CANT_SILLAS_INVALIDA);}
    }

     public void hacerPedido(Comensal comensal, Alimento comida, int cantComida, Alimento bebida, int cantBebida){

       float precioBebidas = menu.elegirDelMenuBebidas(bebida, cantBebida);
       float precioComidas = menu.elegirDelMenuComidas(comida, cantComida);

       comensal.pedirLaCuenta(precioBebidas, precioComidas);
     }




}
