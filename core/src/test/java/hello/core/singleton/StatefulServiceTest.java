package hello.core.singleton;

import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자, 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //A사용자가 주문 금액 조회

        System.out.println("userA의 price = " + userAPrice); //20000

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public  StatefulService statefulService() {
            return new StatefulService();
        }
    }
}