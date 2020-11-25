package com.example.demo;

import com.example.demo.pojo.Person;
import com.example.demo.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    PersonRepository personRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void findAll(){

        Iterable<Person> personIterable = personRepository.findAll();
        Iterator<Person> iterator = personIterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    void findPersonByUid(){
        Person person = personRepository.findPersonByUid("zhangsan1004uid");
        System.out.println(person);
    }

}
