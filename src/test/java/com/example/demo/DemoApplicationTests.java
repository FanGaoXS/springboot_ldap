package com.example.demo;

import com.example.demo.entry.Person;
import com.example.demo.entry.User;
import com.example.demo.service.OdmPersonRepo;
import com.example.demo.service.OdmUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OdmPersonRepo odmPersonRepo;
    @Autowired
    private OdmUserRepo odmUserRepo;

    @Test
    void contextLoads() {

    }

    @Test
    void insertPerson(){
        Person person = new Person();
        person.setCn("baoluo");
        person.setSn("bao");
        person.setUserPassword("954278478");
        odmPersonRepo.create(person);
    }

    @Test
    void deletePerson(){
        Person person = new Person();
        person.setCn("baoluo");
        odmPersonRepo.deletePerson(person);
    }

    @Test
    void updatePerson(){

    }

    @Test
    void findPersonByCn(){
        String cn = "wuqingke";
        Person person = odmPersonRepo.findByCn(cn);
        System.out.println(person);
    }

    @Test
    void findAllPerson(){
        List<Person> personList = odmPersonRepo.findAll();
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    @Test
    void findAllUser(){
        List<User> userList = odmUserRepo.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
