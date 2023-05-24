package com.example.demo;

import com.example.demo.jpa.User;
import com.example.demo.jpa.UserRepository;
import com.example.demo.mongo.Product;
import com.example.demo.mongo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.demo.jpa"})
@EnableMongoRepositories(basePackages = {"com.example.demo.mongo"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository userRepository, ProductRepository productRepository) {
        return args -> {
            User user = User
                    .builder()
                    .name("Abc")
                    .build();
            userRepository.save(user);

            Product product = Product
                    .builder()
                    .id("p1")
                    .name("product 1")
                    .testedBy(user)
                    .build();
            productRepository.save(product);
        };
    }
}
