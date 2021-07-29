package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// @RequiredArgsConstructor // 변수중에 final, @NotNull 변수가 있으면 그 변수에 대해서 생성자를 만들어 준다.

@Service
public class PersonService {
    // 객체를 불러오는 방법(내가 생성하지 않고 서버에 떠 있는 객체 사용)
    // DI IoC
    // 1. @Autowired 사용
    // 2. 생성자를 통한 주입 (가장 선호)
    // 하여튼 di 방법은 총 세 가지가 있다.

    // DI
    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    // Optional<Person> optionalPerson = personRepository.findById(id);
    // findById는 Optional<T>를 반환한다.

    // Optional<T>가 아닌 Person 객체를 반환 받기 위해 아래와 같이 코드로 작성
    // Person 객체로 반환 받으면 바로 Person DAO의 메소드를 사용할 수 있다.
    // 객체 하나는 하나의 데이터(테이블의 한 개의 레코드)에 해당한다.
    // optional 자료형은 DAO의 메소드를 바로 사용할 수가 없다. 이 점이 불편하다.
    // 따라서 orElseThrow 메소드를 통해서 Person 자료형으로 데이터를 받아올 수 있도록 한다.

    @Transactional
    public Long update(Long id, Person person){
        Person person1 = personRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 존재 X")
        ); // person1로 데이터를 검색해서 불러온다.
        person1.update(person); // 주의사항은 모든 필드값이 변경된다는 것이다.
        return null;
    }
}


