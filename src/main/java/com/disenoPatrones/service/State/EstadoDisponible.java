package com.disenoPatrones.service.State;

import com.disenoPatrones.entity.producto;

public class EstadoDisponible implements EstadoProducto {
    @Override
    public void manejarEstado(producto producto) {
        if (producto.getStockProducto() > 0) {
            System.out.println("El producto está disponible.");
        } else {
            producto.setEstado(new EstadoAgotado());
            producto.getEstado().manejarEstado(producto);
        }
    }

}
