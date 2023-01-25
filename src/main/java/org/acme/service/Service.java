package org.acme.service;

import org.acme.model.Producto;

import java.util.List;

public interface Service {
    Boolean guardar(Producto producto);
    Producto buscarporID(Integer id);
    List<Producto> lista();
    Producto modificar(Producto producto);
}
