package com.pds.taller.Barberia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pds.taller.Barberia.model.Cita;
import com.pds.taller.Barberia.service.CitaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/buscar/{fecha}")
    public List<Cita> getCitas(@PathVariable String fecha) {
        return citaService.getCitasByFecha(fecha);
    }

    @PostMapping("/agendar")
    public Cita postCita(@RequestBody Cita cita) {
        return citaService.createCita(cita);
    }

}
