package com.example.demo.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/12/09/12:21
 * @Description:
 */
@Entry(objectClasses = {"organizationalPerson","person","top"},base = "o=blctek")
public class Person {
    @Id
    private Name dn;

    @Attribute(name="cn")
    private String cn;

    @Attribute(name="sn")
    private String sn;

    @Attribute(name="userPassword")
    private String userPassword;

    public Person(String cn) {
        Name dn = LdapNameBuilder.newInstance()
                .add("o", "blctek")
                .add("cn", cn)
                .build();
        this.dn = dn;
    }
    public Person(){}

    /* getter */
    public Name getDn() {
        return dn;
    }

    public String getCn() {
        return cn;
    }

    public String getSn() {
        return sn;
    }

    public String getUserPassword() {
        return userPassword;
    }

    /* setter */
    public void setDn(Name dn) {
        this.dn = dn;
    }

    public void setCn(String cn) {
        this.cn = cn;
        if(this.dn==null){
            Name dn = LdapNameBuilder.newInstance()
                    .add("o", "blctek")
                    .add("cn", cn)
                    .build();
            this.dn = dn;
        }
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dn:" + dn.toString() +
                "\t" + "attributes:" +
                "cn='" + cn + '\'' +
                ",sn='" + sn + '\'' +
                ",userPassword='" + userPassword + '\'' +
                '}';
    }
}
