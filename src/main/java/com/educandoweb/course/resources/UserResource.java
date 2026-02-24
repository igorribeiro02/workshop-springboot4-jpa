package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users") // responsavel por mapear as requisições http que chegarem no endpoint /users
public class UserResource {

    //dependencia par ao service
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository userRepository;

    // aqui vai ficar os endpoints para acessar os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);// retorna a resposta com sucesso
    }

    // o / rretorna um usuario especifico
    @GetMapping(value = "/{id}") //será uma requisição do tipo get, para acessar o id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);// retorna a resposta com sucesso
    }
    @PostMapping
    // o @resquestbody é para dizer que o objeto que vai chegar no corpo da requisição, vai ser convertido para um objeto do tipo User, e o @postmapping é para dizer que essa requisição vai ser do tipo post, ou seja, para inserir um novo usuário no banco de dados
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri(); // para retornar a uri do novo recurso criado, ou seja, o id do novo usuário criado, usando o método fromCurrentRequest para pegar a uri atual, e o método path para adicionar o id do novo usuário criado, e o método buildAndExpand para construir a uri com o id do novo usuário criado, e o método toUri para converter a uri para um objeto do tipo URI
        return ResponseEntity.created(uri).body(obj);// retorna a resposta com sucesso
    }

    // lembrar de passar o id
    @DeleteMapping(value = "/{id}") // o @resquestbody é para dizer que o objeto que vai chegar no corpo da requisição, vai ser convertido para um objeto do tipo User, e o @postmapping é para dizer que essa requisição vai ser do tipo post, ou seja, para inserir um novo usuário no banco de dados
    public ResponseEntity<Void> delete(@PathVariable Long id){ // a resposta da requisiçãoi noa vai retornar nada
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //resource para atualizar um usuário, usando o método put, que é o método recomendado para atualizar um recurso, e o @resquestbody é para dizer que o objeto que vai chegar no corpo da requisição, vai ser convertido para um objeto do tipo User, e o @putmapping é para dizer que essa requisição vai ser do tipo put, ou seja, para atualizar um usuário no banco de dados
    @PutMapping(value = "/{id}") // o @resquestbody é para dizer que o objeto que vai chegar no corpo da requisição, vai ser convertido para um objeto do tipo
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){ // a resposta da requisiçãoi noa vai retornar nada
        obj = service.update(id, obj); // atualiza meu usuario
        return ResponseEntity.ok().body(obj); // retorna a resposta com sucesso, e o corpo da resposta é o usuário atualizado
    }
}
