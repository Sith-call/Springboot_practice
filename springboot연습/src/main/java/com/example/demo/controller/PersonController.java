package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @PostMapping("/api/persons")
    public void post()
    {

    }

    @GetMapping("/api/persons")
    public void get()
    {

    }

    @PutMapping("/api/persons/{id}")
    public void put()
    {

    }

    @DeleteMapping("/api/persons/{id}")
    public void delete()
    {

    }

}

//
//- 1주차 숙제로 작성한 Person 클래스를 CRUD할 수 있는 [PersonController.java](http://personcontroller.java) 파일을 만들고, 다음 API를 완성하세요.
//        - [https://localhost:8080/api/persons](https://localhost:8080/api/persons) POST : 친구 생성
//        - [https://localhost:8080/api/persons](https://localhost:8080/api/persons) GET : 친구 목록 조회
//        - [https://localhost:8080/api/persons](https://localhost:8080/api/persons)/{id} PUT : 친구 정보 변경
//        - [https://localhost:8080/api/persons](https://localhost:8080/api/persons)/{id} DELETE : 친구 정보 삭제
