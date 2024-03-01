package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

//            Order order = new Order();
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem();
//            order.addOrderItem(orderItem);
//
//            em.persist(orderItem);
//            --------------------------------
            Book book = new Book();
            book.setName("jpa");
            book.setAuthor("이준호");


            em.persist(book);
            em.createQuery("select  i from Item i where type(i) = Book ", Item.class)
                    .getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
