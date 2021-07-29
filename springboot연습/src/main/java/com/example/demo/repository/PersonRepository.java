package com.example.demo.repository;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}


//.save() : 데이터 저장
//.findById() : 아이디로 데이터 하나 불러오기
//.findAll() : 객체로 데이터 다 가져오기?
//.deleteAll(): 데이터베이스 비우기

