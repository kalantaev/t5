package com.packtpub.t5first.model;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class User {
    private String firstName;
    private String lastName;
    public User()
    {
    }
    public User(String firstName, String lastName)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
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
