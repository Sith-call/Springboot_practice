package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 이 어노테이션이 있어야 timestamped 값 사용 가능
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(Person.builder().name("이름").address("주소").job("백수").age(12).build());
            personRepository.save(Person.builder().name("이름1").address("주소2").job("백수3").age(123).build());
            personService.update(1L, Person.builder().name("수빈").address("영통").job("백수").age(21).build());
        };
    }

}
