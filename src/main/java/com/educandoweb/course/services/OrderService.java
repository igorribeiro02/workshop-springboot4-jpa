package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Registrar como componente de serviço do Spring, para que ele possa ser injetado em outras classes, como o UserResource
//para isso, basta colocar a anotação @Service na classe
@Service // agora poderá ser injetado em outras classes, como o UserResource, usando a anotação @Autowired
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll(); // retorna a lista de usuários do banco de dados, usando o método findAll do user repository, que retorna uma lista de usuários
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get(); // retorna o usuário do banco de dados, usando o método findById do user repository, que retorna um Optional<User>, e o método get() para obter o usuário do Optional
    }
}
