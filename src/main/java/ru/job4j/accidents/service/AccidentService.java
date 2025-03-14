package ru.job4j.accidents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentMem accidentMem;

    @Autowired
    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public void addAccident(Accident accident) {
        accidentMem.add(accident);
    }

    public Collection<Accident> getAllAccidents() {
        return accidentMem.findAll();
    }

    public Accident getAccidentById(int id) {
        return accidentMem.findById(id);
    }

    public void updateAccident(Accident accident) {
        accidentMem.update(accident);
    }

    public void deleteAccident(int id) {
        accidentMem.delete(id);
    }
}
