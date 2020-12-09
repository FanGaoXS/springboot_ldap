package com.example.demo.service;

import com.example.demo.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/09/15:47
 * @Description:
 */
@Service
public class OdmUserRepo {

    @Autowired
    private LdapTemplate ldapTemplate;

    /*
     * 新增User
     * */
    public User create(User user){
        ldapTemplate.create(user);
        return user;
    }

    /*
     * 通过cn查询User
     * */
    public User findByCn(String cn){
        return ldapTemplate.findOne(query().where("cn").is(cn),User.class);
    }

    /*
     * 修改User
     * */
    public User modifyUser(User user){
        ldapTemplate.update(user);
        return user;
    }

    /*
     * 删除User
     * */
    public void deleteUser(User user){
        ldapTemplate.delete(user);
    }

    /*
     * 查询所有User
     * */
    public List<User> findAll(){
        return ldapTemplate.findAll(User.class);
    }

}
