package com.packtpub.t5first.model;

import java.util.Date;

/**
 * Created by Kalantaev Alexandr on 24.06.2016.
 */
public class TheTest {
    private Date berthdea;
    private Long id;
    private String name;

    private int age;

    public TheTest(){}

    public TheTest( Date berthdea, long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.berthdea = berthdea;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBerthdea(Date berthdea) {
        this.berthdea = berthdea;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {

        return age;
    }

    public Date getBerthdea() {
        return berthdea;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
