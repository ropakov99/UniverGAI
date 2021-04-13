package com.example.offense;

import com.example.offense.model.Card;
import com.example.offense.model.Offence;
import com.example.offense.rest.RestClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OffenceService {

    @Autowired
    OffenceRepository repository;

    public List<Offence> getAll() {
        return repository.findAll();
    }

    public List<Offence> getByUserId(Long id) {
        return repository.findAllByUserId(id);
    }

    public Optional<Offence> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean payOffence(Long id) {
        Offence offence = repository.getOne(id);
        Card card = RestClient.sendHttpRequest("/bank", HttpMethod.GET,null, HttpHeaders.EMPTY);
        Long result = card.getSummary() - offence.getPrice();
        if (result<0){
            return false;
        }
        repository.deleteById(id);
        card.setSummary(result);
        RestClient.sendHttpRequest("/bank", HttpMethod.PUT,card, HttpHeaders.EMPTY);
        return true;
    }

    public Offence save(Offence user) {
        return repository.save(user);
    }

}