package jpabook.jpashop.repository.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderItemQueryDto {

    private Long orderId;
    private String itemName;
    private int name;
    private int count;

    public OrderItemQueryDto(Long orderId, String itemName, int name, int count) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.name = name;
        this.count = count;
    }
}
