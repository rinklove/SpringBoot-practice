package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

/**
 * xxxToOne 관계에서의 성능 최적화
 * Order -> Member -> Delievery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderRepository orderRepository;

    private final OrderSimpleQueryRepository repository;

    /**
     * Member, Order -> Lazy로 되어있음
     * 현재 엔티티(불필요한 데이터)가 외부에 노출되어있음
     * @return
     */
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1 () {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        //성능 최적화가 전혀 이루어지지 않은 상태임
        for (Order o :
                all) {
            //ByteBuddyInspector객체에서 Member의 name값을 가져옴 -> 지연 로딩을 강제 초기화함
            o.getMember().getName();
            o.getDelivery().getAddress();
        }
        return all;
    }

    /**
     * 엔티티의 데이터를 DTO로 변환해서 필요한 데이터만 외부에 공개
     * 문제점: Lazy 로딩으로 인한
     * @return
     */
    @GetMapping("/api/v2/simple-orders")
    public List<OrderSimpleQueryDto> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        return orders.stream().map(OrderSimpleQueryDto::new).collect(Collectors.toList());
    }



    @GetMapping("/api/v3/simple-orders")
    public List<OrderSimpleQueryDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        return orders.stream().map(OrderSimpleQueryDto::new).collect(Collectors.toList());
    }

    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> ordersV4() {
        return repository.findOrderDto();
    }
}
