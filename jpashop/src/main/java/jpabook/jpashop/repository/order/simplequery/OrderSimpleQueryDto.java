package jpabook.jpashop.repository.order.simplequery;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class OrderSimpleQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(Order o) {
        orderId = o.getId();
        name = o.getMember().getName(); //Lazy 초기화, DB에 갔다옴
        orderDate = o.getOrderDate();
        orderStatus = o.getStatus();
        address = o.getDelivery().getAddress(); //Lazy 초기화, DB에 갔다옴
    }

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this. orderId = orderId;
        this.name = name; //Lazy 초기화, DB에 갔다옴
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address; //Lazy 초기화, DB에 갔다옴
    }
}
