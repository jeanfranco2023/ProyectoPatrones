package com.disenoPatrones.service.observer;

import com.disenoPatrones.entity.producto;

public class AlertaStockObserver implements ProductoObserver {
     @Override
    public void actualizar(producto producto) {
        if (producto.getStockProducto() < 10) {
            System.out.println("ALERTA: El stock del producto " + producto.getNombreProducto() + " es bajo (" + producto.getStockProducto() + ").");
        }
    }
}
