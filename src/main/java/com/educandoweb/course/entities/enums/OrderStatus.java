package com.educandoweb.course.entities.enums;

import com.educandoweb.course.entities.Order;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) { //construtor do tipo enumerado é private
        this.code = code;
    }

    public int getCode() { // metodo public opara acessar o code
        return code;
    }

    public static OrderStatus valueOf(int code){
        //vai retornar o OrderStatus correspondente ao code recebido por parametro
        for(OrderStatus value: OrderStatus.values()){
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
