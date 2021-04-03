package com.example.offense;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OffenceService {

    OffenceRepository repository;

    public List<Offence> getAll() {
        return repository.findAll();
    }

    public Optional<Offence> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Offence save(Offence user) {
        return repository.save(user);
    }

}