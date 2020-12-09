package com.example.demo.entry;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/09/15:18
 * @Description:
 */
@Entry(objectClasses = {"account","simpleSecurityObject","top"},base = "ou=Financer,o=blctek")
public class User {
    @Id
    private Name dn;

    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "userPassword")
    private String userPassword;

    public User() {
    }

    public User(String uid) {
        /*
        *  构造dn:uid=xxx,ou=Financer,o=blctek
        * */
        Name dn = LdapNameBuilder.newInstance()
                .add("o", "blctek")
                .add("ou", "Financer")
                .add("uid", uid)
                .build();
        this.dn = dn;
    }

    public Name getDn() {
        return dn;
    }

    public String getUid() {
        return uid;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public void setUid(String uid) {
        this.uid = uid;
        if(this.dn==null){
            Name dn = LdapNameBuilder.newInstance()
                    .add("o", "blctek")
                    .add("ou", "Financer")
                    .add("uid", uid)
                    .build();
            this.dn = dn;
        }
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "dn:" + dn.toString() +
                "\t" + "attributes:" +
                "uid='" + uid + '\'' +
                ",userPassword='" + userPassword + '\'' +
                '}';
    }
}
