package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int age;
    @Column
    private Date birthday;

    public Client() {
    }

    public Client(int id, String name, String lastname, int age, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
