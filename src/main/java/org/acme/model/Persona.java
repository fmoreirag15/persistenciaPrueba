package org.acme.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long    id;
    @NotEmpty(message = "nombre no puede ser nulo")
    private String name;
    @NotEmpty(message = "descripcion no puede ser nulo")
    private String lastName;
    @NotEmpty(message = "edad no puede ser nulo")
    private String age;
    @NotEmpty(message = "pais no puede ser nulo")
    private String country;
    @NotEmpty(message = "DNI no puede ser nulo")
    @Size(min = 0, max = 8, message = "No puede ser mayor a 8dig")
    private String DNI;

}
