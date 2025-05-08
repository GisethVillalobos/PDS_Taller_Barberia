package com.pds.taller.Barberia.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pds.taller.Barberia.model.Cita;
import com.pds.taller.Barberia.repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    private final ObjectMapper objectMapper;

    public CitaService() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Cita> getCitasByFecha(String fecha) {
        String dirName = "citas/" + fecha;
        File dir = new File(dirName);
    
        if (!dir.exists() || !dir.isDirectory()) {
            return List.of();
        }
    
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
    
        ObjectMapper objectMapper = new ObjectMapper();
        List<Cita> citas = new ArrayList<>();
    
        for (File file : files) {
            try {
                Cita cita = objectMapper.readValue(file, Cita.class);
                if (cita.getFecha().equals(fecha.toString())) {
                    citas.add(cita);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        return citas;
    }

    public Cita createCita(Cita cita) {

        cita.setFecha(cita.getFecha().toString());
        cita.setHora(cita.getHora().toString());

        String dirName = "citas/" + cita.getFecha();
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = dirName + "/" + cita.getCedula() + ".json";
        File file = new File(fileName);

        try {
            objectMapper.writeValue(file, cita);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return citaRepository.save(cita);
    }
}
