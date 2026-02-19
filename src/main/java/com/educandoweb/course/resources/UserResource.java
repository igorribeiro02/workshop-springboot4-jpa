package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") // responsavel por mapear as requisições http que chegarem no endpoint /users
public class UserResource {

    // aqui vai ficar os endpoints para acessar os usuários
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria Brown", "988888888","maria@gmail.com", "123456");
        return ResponseEntity.ok().body(u); // retorna a resposta com sucesso


    }

}
