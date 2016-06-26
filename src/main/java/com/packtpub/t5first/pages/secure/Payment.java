package com.packtpub.t5first.pages.secure;

import com.packtpub.t5first.model.User;
import com.packtpub.t5first.pages.ShowAll;
import com.packtpub.t5first.pages.Registration;
import com.packtpub.t5first.util.Security;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import java.util.Locale;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class Payment {
    private String userName;
    private String password;
    @SessionState
    private User user;
    @Inject
    private Locale currentLocale;
    @Inject
    private PersistentLocale persistentLocale;
    @Persist
    private String localeLabel;
    public String getLocaleLabel()
    {
        if (localeLabel == null)
        {
            if (currentLocale.equals(Locale.GERMAN))
            {
                localeLabel = new Locale("en").getDisplayName(Locale.ENGLISH);
            }
            else
            {
                localeLabel = new Locale("de").getDisplayName(Locale.GERMAN);
            }
        }  return localeLabel;
    }
    @OnEvent(component="switchlocale")
    void changeLocale()
    {
        localeLabel = currentLocale.getDisplayName(currentLocale);
        if (currentLocale.equals(Locale.GERMAN))
        {
            persistentLocale.set(Locale.ENGLISH);
        }
        else
        {
            persistentLocale.set(Locale.GERMAN);
        }
    }

    Object onSubmitFromLoginForm()
    {
        Class nextPage = null;
        User authenticatedUser = null;
        authenticatedUser =
                Security.authenticate(userName, password);
        if (authenticatedUser != null)
        {
            user = authenticatedUser;
            nextPage = ShowAll.class;
        }
        else
        {
            nextPage = Registration.class;
        }
        return nextPage;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;  }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
