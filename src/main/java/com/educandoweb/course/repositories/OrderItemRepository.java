package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // repositoires serao interfaces, somente o que coloequei acime
    //será suficiente para ter acesso a todas as operações de acesso a dados para a entidade User
}
