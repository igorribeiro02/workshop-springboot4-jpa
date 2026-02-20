package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.CategoryService;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories") // responsavel por mapear as requisições http que chegarem no endpoint /users
public class CategoryResource {

    //dependencia par ao service
    @Autowired
    private CategoryService service;

    // aqui vai ficar os endpoints para acessar os usuários
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);// retorna a resposta com sucesso

    }

    @GetMapping(value = "/{id}") //será uma requisição do tipo get, para acessar o id
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);// retorna a resposta com sucesso
    }

}
