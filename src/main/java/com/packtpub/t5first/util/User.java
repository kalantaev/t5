package com.packtpub.t5first.util;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class User {
    private String firstName = "John";
    private String lastName = "Smith";
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
