package hello.itemservice.domain.item;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data // -> getter, setter, toString 생성
@NoArgsConstructor
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
