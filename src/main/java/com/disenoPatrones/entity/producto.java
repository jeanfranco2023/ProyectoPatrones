package com.disenoPatrones.entity;

import java.util.List;

import com.disenoPatrones.service.State.EstadoAgotado;
import com.disenoPatrones.service.State.EstadoDisponible;
import com.disenoPatrones.service.State.EstadoProducto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table (name = "producto")
public class producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_producto")
    private int idProducto;

    @Column(unique = true)
    private String codigoProducto;

    @Column(unique = true)
    private String nombreProducto;

    private String descripcionProducto;

    private double precioProducto;  

    private int stockProducto;

    @Transient
    private EstadoProducto estadoProducto;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesVentas;

    public producto() {
    }

    public producto(String codigoProducto, String nombreProducto, String descripcionProducto, double precioProducto, int stockProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public List<DetalleVenta> getDetallesVentas() {
        return detallesVentas;
    }

    public void setDetallesVentas(List<DetalleVenta> detallesVentas) {
        this.detallesVentas = detallesVentas;
    }

     public void actualizarEstado() {
        if (stockProducto > 100) {
            estadoProducto = new EstadoDisponible();
        } else {
            estadoProducto = new EstadoAgotado();
        }
    }

    public EstadoProducto getEstado() {
        return estadoProducto;
    }

    public void setEstado(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
}

    

