package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // indica que essa classe de configuração só será carregada quando o perfil "test" estiver ativo
public class TestConfig implements CommandLineRunner {

//terá uma ddpendencia do meu user repository, para acessar os dados do banco de dados e popular o banco de dados com alguns dados de teste
    //essa injeção tem que ser fraca, então vou usar o construtor para injetar a dependencia do user repository
    //declarar a decpendencia do user repository
    @Autowired
    private UserRepository userRepository; // o spring vai injetar uma instancia do user repository aqui, para que eu possa usar para acessar os dados do banco de dados e popular o banco de dados com alguns dados de teste


    @Override //será executado quando a aplicação for iniciada, e é aqui que eu vou colocar o código para popular o banco de dados com alguns dados de teste
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "988888888","maria@gmail.com", "123456");
        User u2 = new User(null, "Alex Green", "977777777","alex@gmail.com", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); // salva os usuários no banco de dados, usando o método saveAll do user repository, que recebe uma lista de usuários e salva todos eles no banco de dados
    }
}
