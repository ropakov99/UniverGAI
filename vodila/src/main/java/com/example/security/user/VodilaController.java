package com.example.security.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class VodilaController {

    VodilaService service;

    @GetMapping
    public List<Vodila> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Vodila getById(@PathVariable(name = "id") Long id){
        return service.getById(id).orElse(new Vodila());
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        service.deleteById(id);
    }

    @PostMapping
    public Vodila save(@RequestBody Vodila vodila){
        return service.save(vodila);
    }

}
