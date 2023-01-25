package org.acme.service.impl;

import org.acme.model.Persona;
import org.acme.repository.Repository;
import org.acme.service.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ServiceImpl implements Service {
    @Inject
    Repository repository;

    @Override
    public Boolean guardar(Persona persona) {
        if(repository.findByIdPersona(persona.getDNI())) {
            if (repository.isPersistent(persona)) {
                repository.persist(persona);
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public Persona buscarporID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Persona> lista() {
        return repository.listAll();
    }

    @Override
    public Persona modificar(Persona persona) {
        repository.persist(persona);
        return persona;
    }
}
