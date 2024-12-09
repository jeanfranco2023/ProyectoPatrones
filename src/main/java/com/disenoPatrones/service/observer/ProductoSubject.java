package com.disenoPatrones.service.observer;

import java.util.ArrayList;
import java.util.List;

import com.disenoPatrones.entity.producto;

public class ProductoSubject {
     private List<ProductoObserver> observadores = new ArrayList<>();

    // Método para registrar observadores
    public void registrarObservador(ProductoObserver observador) {
        observadores.add(observador);
    }

    // Método para eliminar observadores
    public void eliminarObservador(ProductoObserver observador) {
        observadores.remove(observador);
    }

    // Notificar a todos los observadores
    public void notificar(producto producto) {
        for (ProductoObserver observador : observadores) {
            observador.actualizar(producto);
        }
    }
}
