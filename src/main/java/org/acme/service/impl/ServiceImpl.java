package org.acme.service.impl;

import io.quarkus.panache.common.Parameters;
import org.acme.model.Persona;
import org.acme.repository.Repository;
import org.acme.service.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServiceImpl implements Service {
    @Inject
    Repository repository;

    @Override
    public Boolean guardar(Persona persona) {
        if(repository.findByIdPersona(persona.getDNI())) {

                repository.persist(persona);
                return true;

        }else {
            return false;
        }
    }
    @Override
    public Persona buscarporID(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Persona> lista(Integer edad) {
        int pesonaedad=0;
        List<Persona> personaList=repository.listAll();
        return  personaList.stream()
                .filter(c -> Integer.parseInt(c.getAge())>=edad)
                .collect(Collectors.toList());
    }

    @Override
    public Persona modificar(Persona persona) {
        repository.update("name= :name ," +
                        "lastName= :lastName ," +
                        "age= :age ," +
                        "country= :country ," +
                        "DNI= :DNI " +
                        " where id = :id",
                       Parameters.with("name", persona.getName())
                        .and("id",persona.getId())
                        .and("lastName",persona.getLastName())
                        .and("DNI",persona.getDNI())
                        .and("age",persona.getAge())
                        .and("country",persona.getCountry()));

        return  persona;

    }
}
