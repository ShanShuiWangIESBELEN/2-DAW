package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.OptionalDouble;

@Data
@AllArgsConstructor
public class ComercialDTO{

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private float comision;

    private Double mediaPedidosCoste;
    private int totalPedidos;
    private double totalPedidosCoste;
    private List<Pedido> listaPedidos;


    public ComercialDTO() {
    }


}
