package org.acme.service.impl;

import org.acme.model.Producto;
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
    public Boolean guardar(Producto producto) {
        if(repository.isPersistent(producto))
        {
            repository.persist(producto);
            return true;
        }else
        {
            return  false;
        }

    }

    @Override
    public Producto buscarporID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Producto> lista() {
        return repository.listAll();
    }

    @Override
    public Producto modificar(Producto producto) {
        repository.persist(producto);
        return producto;
    }
}
