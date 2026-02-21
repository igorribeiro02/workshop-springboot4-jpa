package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order") //gera um noutro nome para a tabela par an oter conflitos
public class Order implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //formato de data e hora para o json, para que o cliente possa entender melhor
    private Instant moment;

    private Integer orderStatus;

    //criar as associeações
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client") // nome da chave estrangeira na tabela de pedidos, que vai referenciar a tabela de usuários
    private User client;// implementar o relacionamento

    //para implementar o relacionamento entre Order e User, basta colocar o tipo do atributo como User, e o nome do atributo como client, para indicar que o cliente é um usuário, e o pedido tem um cliente, que é um usuário

    @JsonIgnore
    @OneToMany(mappedBy = "id.order") //mapeamento do relacionamento, indicando que o atributo id.order da classe OrderItem é o responsável pelo relacionamento
    private Set<OrderItem> items = new HashSet<>();


    public Order() {
    }

    public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Order(Object o, Instant parse, OrderStatus orderStatus, User u1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }
}
