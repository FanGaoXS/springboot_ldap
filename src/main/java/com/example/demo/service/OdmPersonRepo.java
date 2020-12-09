package com.example.demo.service;

import com.example.demo.entry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/09/13:21
 * @Description:
 */
@Service
public class OdmPersonRepo {

    @Autowired
    private LdapTemplate ldapTemplate;

    /*
    * 新增Person
    * */
    public Person create(Person person){
        ldapTemplate.create(person);
        return person;
    }

    /*
    * 通过cn查询Person
    * */
    public Person findByCn(String cn){
        return ldapTemplate.findOne(query().where("cn").is(cn),Person.class);
    }

    /*
    * 修改Person
    * */
    public Person modifyPerson(Person person){
        ldapTemplate.update(person);
        return person;
    }

    /*
    * 删除Person
    * */
    public void deletePerson(Person person){
        ldapTemplate.delete(person);
    }

    /*
    * 查询所有Person
    * */
    public List<Person> findAll(){
        return ldapTemplate.findAll(Person.class);
    }
}
