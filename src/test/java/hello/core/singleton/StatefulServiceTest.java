package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : UserA가 10000원 주문
        statefulService1.order("UserA", 10000);
        //ThreadB : UserB가 20000원 주문
        statefulService2.order("UserB", 20000);

        //ThreadA : UserA가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        //UserA 주문 - UserB 주문 - UserA 조회 -> 20000원 출력
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}