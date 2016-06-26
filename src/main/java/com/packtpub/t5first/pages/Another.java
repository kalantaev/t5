package com.packtpub.t5first.pages;

import com.packtpub.t5first.util.User;
import org.apache.tapestry5.annotations.SessionState;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class Another {
    private String passedMessage;

    @SessionState
    private User myUser;
    public User getMyUser()
    {
        return myUser;
    }

    public String getPassedMessage()
    {
        return passedMessage;
    }
    public void setPassedMessage(String passedMessage)
    {
        this.passedMessage = passedMessage;
    }
    void onActivate(String message)
    {
        System.out.println("Another page is activated! The message is: " + message);
        this.passedMessage = message;
    }
    String onPassivate()
    {
        System.out.println("Another page is passivated...");
        return passedMessage;
    }
}
