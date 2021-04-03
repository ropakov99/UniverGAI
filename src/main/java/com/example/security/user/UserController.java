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
public class UserController {

    UserService userService;

    @GetMapping
    public List<User> getListOfUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id).orElse(new User());
    }

    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
    }

    @PostMapping
    public User saveEmail(@RequestBody User user){
        return userService.saveUser(user);
    }

}
/*
*
* @PreAuthorize

Ограничивает доступ к методам перед их вызовом, опираясь на результат вычисления выражения

@PostAuthorize  Проверка условия после вызова метода

@PostFilter

Позволяет вызывать методы, но фильтрует его результаты в соответствии со значением выражения

@PreFilter

Позволяет вызывать методы, но фильтрует входные данные перед фактическим вызовом метода

*
*
*
*
*
*
*
* @PreAuthorize("hasRole(‘ROLE_SPITTER)")
@PostFilter("filterObject.spitter.username    ==    principal.name") public  List<Spittle>  getABunchOfSpittles()  {}

Здесь аннотация @PreAuthorize позволяет вызывать метод лишь пользователям с привилегией ROLE_SPITTER. Если пользователь прой- дет эту проверку, метод будет вызван и вернет список сообщений.
*  Но аннотация @PostFilter отфильтрует этот список, оставив в нем только сообщения (объекты Spittle), принадлежащие пользователю.
* */