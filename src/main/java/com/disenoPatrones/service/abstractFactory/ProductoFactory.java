package com.disenoPatrones.service.abstractFactory;

import com.disenoPatrones.entity.producto;

public interface ProductoFactory {
    producto crearProducto(String codigo, String nombre, String descripcion, double precio, int stock);
}
