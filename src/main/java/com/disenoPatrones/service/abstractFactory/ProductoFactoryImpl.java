package com.disenoPatrones.service.abstractFactory;

import com.disenoPatrones.entity.producto;

public class ProductoFactoryImpl implements ProductoFactory {
    @Override
    public producto crearProducto(String codigo, String nombre, String descripcion, double precio, int stock) {
        producto nuevoProducto = new producto();
        nuevoProducto.setCodigoProducto(codigo);
        nuevoProducto.setNombreProducto(nombre);
        nuevoProducto.setDescripcionProducto(descripcion);
        nuevoProducto.setPrecioProducto(precio);
        nuevoProducto.setStockProducto(stock);
        return nuevoProducto;
    }
}
