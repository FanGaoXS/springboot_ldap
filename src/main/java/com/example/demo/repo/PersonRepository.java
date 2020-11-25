package com.example.demo.repo;

import com.example.demo.pojo.Person;
import org.springframework.data.ldap.repository.LdapRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/11/24/17:04
 * @Description:
 */
public interface PersonRepository extends LdapRepository<Person> {
    Person findPersonByUid(String uid);
    Person findPersonByOrganizationalUnit();
}

