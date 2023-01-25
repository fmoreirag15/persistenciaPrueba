package org.acme.service;

import org.acme.model.Persona;

import java.util.List;

public interface Service {
    Boolean guardar(Persona persona);
    Persona buscarporID(Integer id);
    List<Persona> lista();
    Persona modificar(Persona persona);
}
