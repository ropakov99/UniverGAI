package com.example.offense;

import com.example.offense.model.Offence;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offence")
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:8080")
public class OffenceController {

    @Autowired
    OffenceService service;

    @GetMapping
    public List<Offence> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Offence getById(@PathVariable(name = "id") Long id){
        return service.getById(id).orElse(new Offence());
    }

    @GetMapping("/{idOffence}/pay/{idCard}")
    public Boolean payOffence(@PathVariable(name = "idOffence") Long idOffence,@PathVariable(name = "idCard") Long idCard){
        return service.payOffence(idCard,idOffence);
    }

    @GetMapping("/user/{id}")
    public List<Offence> getByUserId(@PathVariable(name = "id") Long id){
        return service.getByUserId(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }

    @PostMapping
    public Offence save(@RequestBody Offence offence){
        return service.save(offence);
    }

}
