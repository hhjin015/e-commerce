package com.github.hhjin015.commerce.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

//    @Bean
//    ApplicationRunner a(ProductItemRepository repository) {
//        return new ApplicationRunner() {
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//                repository.save(new ProductItem("1", "양말"));
//            }
//        };
//    }

}
