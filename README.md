# 🛒 E-commerce API - Workshop Spring Boot & JPA

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)

## 💻 Sobre o Projeto
Este projeto é uma API RESTful desenvolvida em **Java** com **Spring Boot**, simulando o domínio de um sistema de E-commerce. O objetivo principal é demonstrar na prática a modelagem de domínio complexa, Mapeamento Objeto-Relacional (ORM) com JPA/Hibernate e a estruturação de uma aplicação em camadas lógicas.

## ⚙️ Funcionalidades e Aprendizados
- **Arquitetura em Camadas:** Divisão clara entre `Resources` (Controladores REST), `Services` (Regras de negócio) e `Repositories` (Acesso a dados).
- **Mapeamento Objeto-Relacional (ORM):** - Relacionamentos `@OneToMany`, `@ManyToOne`, `@OneToOne` e `@ManyToMany`.
  - Utilização de chaves primárias compostas (`@EmbeddedId`) na classe `OrderItemPK`.
- **Tratamento de Exceções:** Implementação de um `@ControllerAdvice` para interceptar e tratar erros de forma padronizada (ex: `ResourceNotFoundException`, `DatabaseException`), retornando respostas HTTP adequadas com o objeto `StandardError`.
- **Database Seeding:** Utilização do `CommandLineRunner` no `TestConfig` para popular o banco de dados de teste (H2) automaticamente na inicialização.
- **Operações CRUD:** Endpoints completos para gerenciamento de Usuários, Produtos, Categorias e Pedidos.

## 🗂️ Modelo de Domínio
O projeto engloba as seguintes entidades e suas associações:
* **User** (Cliente)
* **Order** (Pedido) - Contém status do pedido (Enum `OrderStatus`)
* **Category** (Categoria)
* **Product** (Produto)
* **OrderItem** (Item de Pedido) - Classe de associação com chave composta.
* **Payment** (Pagamento) - Entidade dependente mapeada de forma 1:1 com o Pedido.

## 🚀 Tecnologias Utilizadas
* **Java**
* **Spring Boot**
* **Spring Data JPA / Hibernate**
* **H2 Database** (Banco de dados em memória para testes)
* **Maven** (Gerenciamento de dependências)

## 🛠️ Como Executar
1. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/workshop-springboot4-jpa.git](https://github.com/SEU_USUARIO/workshop-springboot4-jpa.git)
