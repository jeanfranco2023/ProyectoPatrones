package com.disenoPatrones.service.State;

import com.disenoPatrones.entity.producto;

public class EstadoAgotado implements EstadoProducto {
    @Override
    public void manejarEstado(producto producto) {
        System.out.println("El producto está sin stock.");
    }

}
