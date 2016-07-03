package com.packtpub.t5first.model;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class Celebrity {
    @NonVisual
    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Occupation occupation;
    @NonVisual
    private String biography;
    @NonVisual
    private boolean birthDateVerified;
    @Inject
    public Celebrity() {
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setBirthDateVerified(boolean birthDateVerified) {
        this.birthDateVerified = birthDateVerified;
    }

    public String getBiography() {

        return biography;
    }

    public boolean isBirthDateVerified() {
        return birthDateVerified;
    }




    public Celebrity(String firstName, String lastName,
                     Date dateOfBirth, Occupation occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
