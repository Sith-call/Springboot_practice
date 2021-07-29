package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
@Entity
public class Person extends Timestamped {
    // 타임 스탬프를 상속 받아서 타임 스탬프 관련 컬럼이 생성된다.
    // 스프링 부트가 도메인에 있는 클래스는 자동으로 테이블로 만들고 시작한다.
    // 이 객체는 DAO에 해당한다(?)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotNull 도 가능
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    // primary key 값은 변경해선 안된다.
    public Long update(Person person){
        this.name = person.getName();
        this.job = person.getJob();
        this.age = person.getAge();
        this.address = person.getAddress();
        return this.id;
    }

}