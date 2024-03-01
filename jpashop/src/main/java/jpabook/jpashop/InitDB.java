package jpabook.jpashop;


import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

//컴포넌트 스캔 대상으로 지정
@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;



        public void dbInit1() {
            //회원 생성 
            Member member = createMember("userA", "서울", "1", "1111");
            em.persist(member);

            //책 더미 데이터 생성
            Book book1 = getBook("JPA1 BOOK", 10000, 100);
            em.persist(book1);

            Book book2 = getBook("JPA2 BOOK", 20000, 100);
            em.persist(book2);

            //주문 더미데이터 생성
            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Order order = getOrder(member, orderItem1, orderItem2);
            em.persist(order);

        }

        public void dbInit2() {
            //회원 생성 
            Member member = createMember("userB", "부산", "2", "2222");
            em.persist(member);

            //책 더미 데이터 생성
            Book book1 = getBook("SPRING1 BOOK", 20000, 200);
            em.persist(book1);

            Book book2 = getBook("SPRING2 BOOK", 4000, 300);
            em.persist(book2);

            //주문 더미데이터 생성
            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);

            Order order = getOrder(member, orderItem1, orderItem2);
            em.persist(order);

        }
    }

    private static Order getOrder(Member member, OrderItem orderItem1, OrderItem orderItem2) {
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
        return order;
    }

    private static Book getBook(String bookName, int price, int quantity) {
        Book book1 = new Book();
        book1.setName(bookName);
        book1.setPrice(price);
        book1.setStockQuantity(quantity);
        return book1;
    }

    private static Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(new Address(city, street, zipcode));
        return member;
    }
}


