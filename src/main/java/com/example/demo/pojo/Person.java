package com.example.demo.pojo;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/11/24/17:03
 * @Description:
 */
@Data
@Entry(base = "ou=people,dc=yaobili,dc=com", objectClasses = {"inetOrgPerson","organizationalPerson","person","top"})
public class Person {

    @Id
    private Name dn;

    @DnAttribute(value = "uid",index = 3)
    private String uid;

    @Attribute(name = "cn")
    private String commonName;

    @Attribute(name = "sn")
    private String surName;

    private String description;

    private String title;

    private String displayName;

}

