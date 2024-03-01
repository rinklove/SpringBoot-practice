package hello.core.order;

import org.springframework.core.annotation.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
