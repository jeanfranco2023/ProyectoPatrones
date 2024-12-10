package com.disenoPatrones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disenoPatrones.entity.producto;
import com.disenoPatrones.repository.Productorepository;
import com.disenoPatrones.service.abstractFactory.ProductoFactory;
import com.disenoPatrones.service.observer.AlertaStockObserver;
import com.disenoPatrones.service.observer.DashboardObserver;
import com.disenoPatrones.service.observer.ProductoSubject;

@Service
public class ProductoService {
    @Autowired
    private Productorepository productoRepository;

    private final ProductoFactory productoFactory;

    private final ProductoSubject productoSubject;

     public ProductoService(ProductoFactory productoFactory, Productorepository productoRepository) {
        this.productoFactory = productoFactory;
        this.productoRepository = productoRepository;
        this.productoSubject = new ProductoSubject();

        // Registra observadores
        productoSubject.registrarObservador(new AlertaStockObserver());
        productoSubject.registrarObservador(new DashboardObserver());
    }


    public producto crearYGuardarProducto(String codigo, String nombre, String descripcion, double precio, int stock) {
        producto nuevoProducto = productoFactory.crearProducto(codigo, nombre, descripcion, precio, stock);
        return productoRepository.save(nuevoProducto);
    }

    public List<producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<producto> buscarProductoPorCodigo(String codigo) {
        return productoRepository.findByCodigoProducto(codigo);
    }

    public List<producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    public producto obtenerProductoPorId(int id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public producto actualizarStockProducto(Integer id, int nuevoStock) {
        producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de producto inválido: " + id));
        producto.setStockProducto(nuevoStock);
        productoRepository.save(producto);

        // Notificar a los observadores sobre el cambio
        productoSubject.notificar(producto);

        return producto;
    }

}
