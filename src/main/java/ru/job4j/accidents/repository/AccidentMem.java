package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final ConcurrentHashMap<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public AccidentMem() {
        add(new Accident(0, "Инцидент 1", "Описание инцидента 1", "Адрес 1"));
        add(new Accident(0, "Инцидент 2", "Описание инцидента 2", "Адрес 2"));
        add(new Accident(0, "Инцидент 3", "Описание инцидента 3", "Адрес 3"));
    }

    public void add(Accident accident) {
        accident.setId(idGenerator.getAndIncrement());
        accidents.put(accident.getId(), accident);
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public void delete(int id) {
        accidents.remove(id);
    }
}
