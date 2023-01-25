package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.model.Persona;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repository implements PanacheRepositoryBase<Persona, Integer> {
    public boolean findByIdPersona(String DNI){
        if(find("DNI",DNI).firstResult()==null)
        {
            return true;
        }
        return false;
    }
}
