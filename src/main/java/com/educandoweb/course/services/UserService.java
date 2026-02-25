package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//Registrar como componente de serviço do Spring, para que ele possa ser injetado em outras classes, como o UserResource
//para isso, basta colocar a anotação @Service na classe
@Service // agora poderá ser injetado em outras classes, como o UserResource, usando a anotação @Autowired
public class UserService {

    @Autowired
    private UserRepository repository;
    private UserService service;

    public List<User> findAll() {
        return repository.findAll(); // retorna a lista de usuários do banco de dados, usando o método findAll do user repository, que retorna uma lista de usuários
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retorna o usuário do banco de dados, usando o método findById do user repository, que retorna um Optional<User>, e o método get() para obter o usuário do Optional
    }

    // operação para salvar no banco de dados um
    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id); // lanço a minha excessão de serviço
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }


    @PutMapping(value = "/{id}") // o @resquestbody é para dizer
    public User update(Long id, User obj){
        try{
            User entity = repository.getReferenceById(id); // prepara o obj para ser modigicado
            service.updateData(entity, obj); // atualiza os dados do obj com os dados do entity
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //so deixo atualizar os campos que eu quero, para evitar que o cliente possa atualizar campos que não devem ser atualizados, como o id, ou a senha, por exemplo
    public void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
