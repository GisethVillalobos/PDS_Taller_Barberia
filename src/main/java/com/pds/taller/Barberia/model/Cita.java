package com.pds.taller.Barberia.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    
    @Id
    private Long cedula;

    private String nombre;

    private String apellido;

    private int edad;

    private String fecha;

    private String hora;  
    
    
}
