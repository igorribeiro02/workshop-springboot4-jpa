package com.educandoweb.course.config;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // indica que essa classe de configuração só será carregada quando o perfil "test" estiver ativo
public class TestConfig implements CommandLineRunner {

//terá uma ddpendencia do meu user repository, para acessar os dados do banco de dados e popular o banco de dados com alguns dados de teste
    //essa injeção tem que ser fraca, então vou usar o construtor para injetar a dependencia do user repository
    //declarar a decpendencia do user repository
    @Autowired
    private UserRepository userRepository; // o spring vai injetar uma instancia do user repository aqui, para que eu possa usar para acessar os dados do banco de dados e popular o banco de dados com alguns dados de teste

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private OrderRepository orderRepository;

    @Override //será executado quando a aplicação for iniciada, e é aqui que eu vou colocar o código para popular o banco de dados com alguns dados de teste
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // salva as categorias no banco de dados, usando o método saveAll do category repository, que recebe uma lista de categorias e salva todas elas no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // salva os produtos no banco de dados, usando o método saveAll do product repository, que recebe uma lista de produtos e salva todos eles no banco de dados

        p1.getCategories().add(cat2); // adiciona a categoria "Books" ao produto "The Lord of the Rings", usando o método getCategories() para obter a lista de categorias do produto, e o método add() para adicionar a categoria à lista de categorias do produto
        p2.getCategories().add(cat1); // adiciona a categoria "Electronics" ao produto "Smart TV"
        p2.getCategories().add(cat3); // adiciona a categoria "Computers" ao produto "Smart TV"
        p3.getCategories().add(cat3); // adiciona a categoria "Computers" ao produto "Macbook Pro"
        p4.getCategories().add(cat3); // adiciona a categoria "Computers" ao produto "PC Gamer"
        p5.getCategories().add(cat2); // adiciona a categoria "Books" ao produto "Rails for Dummies"

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // salva os produtos no banco de dados, usando o método saveAll do product repository, que recebe uma lista de produtos e salva todos eles no banco de dados, para atualizar as categorias dos produtos no banco de dados


        User u1 = new User(null, "Maria Brown", "988888888","maria@gmail.com", "123456");
        User u2 = new User(null, "Alex Green", "977777777","alex@gmail.com", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
        userRepository.saveAll(Arrays.asList(u1,u2)); // salva os usuários no banco de dados, usando o método saveAll do user repository, que recebe uma lista de usuários e salva todos eles no banco de dados
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));





    }
}
