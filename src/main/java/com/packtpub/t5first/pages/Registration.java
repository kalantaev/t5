package com.packtpub.t5first.pages;

import com.packtpub.t5first.model.Country;
import com.packtpub.t5first.model.Gender;
import com.packtpub.t5first.model.User;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import java.util.Date;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class Registration {

    @SessionState
    private User user;
    @Persist
    private String userName;
    @Persist
    private String password;
    @Persist
    private String password2;
    @Persist
    private Double age;

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getAge() {

        return age;
    }

    private Gender gender = Gender.FEMALE;
    @Persist
    private boolean subscribe;
    @Persist
    private String email;
    private boolean unsubscribe;

    @Inject
    private Messages messages;
    public SelectModel getCountries()
    {
        return new EnumSelectModel(Country.class, messages);
    }
    @Persist
    private Country country;
    @Persist
    private Date dateOfBirth;
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public Country getCountry()
    {
        return country;
    }
    public void setCountry(Country country)
    {
        this.country = country;
    }


    public boolean isPasswordNotSubmitted()
    {
        return userName == null;
    }
    public boolean isUnsubscribe() {
        return unsubscribe;
    }

    public void setUnsubscribe(boolean unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        System.out.println("Setting subscribe: " + subscribe);
        this.subscribe = subscribe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("Setting user name: " + userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Setting password: " + password);
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getMale() {
        return Gender.MALE;
    }

    public Gender getFemale() {
        return Gender.FEMALE;
    }

    void onSubmitFromRegistrationForm() {
        System.out.println("The form was submitted!");
        if (unsubscribe) subscribe = false;
    }
    @OnEvent(component="submitButton")
    Object onSubmitButton()
    {
        System.out.println("Submit button was pressed!");
        User newUser = new User("John", "Johnson");
        this.user = newUser;
        return ShowAll.class;
    }
    @OnEvent(component="resetButton")
    void  onResetButton()
    {
        userName = null;
        password = null;
        email = null;
        gender = null;
        subscribe = false;
    }
    String onSubmit()
    {
        System.out.println("The form was submitted!");
        if (unsubscribe) subscribe = false;
        return "showall";
    }
    void onValidate()
    {
        System.out.println("In onValidate.");
    }
    void onSuccess()
    {
        System.out.println("In onSuccess.");
    }
    void onFailure()
    {
        System.out.println("In onFailure.");
    }
}
