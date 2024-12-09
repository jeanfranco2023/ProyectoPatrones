package com.disenoPatrones.service.observer;

import com.disenoPatrones.entity.producto;

public class DashboardObserver implements ProductoObserver {
  @Override
    public void actualizar(producto producto) {
        System.out.println("Dashboard actualizado: Producto " + producto.getNombreProducto() + " ahora tiene un stock de " + producto.getStockProducto());
    }
    
}
