package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // repositoires serao interfaces, somente o que coloequei acime
    //será suficiente para ter acesso a todas as operações de acesso a dados para a entidade User
}
