package com.packtpub.t5first.pages;


import com.packtpub.t5first.util.User;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.slf4j.Logger;

import java.util.Date;

/**
 * Start page of application t5first.
 */
public class Index
{
  @Inject
  private Logger logger;
  private String message="initial value";
  @Inject
  private AjaxResponseRenderer ajaxResponseRenderer;

  @Property
  @Inject
  @Symbol(SymbolConstants.TAPESTRY_VERSION)
  private String tapestryVersion;

  @InjectPage
  private About about;

  @InjectPage
  private Another another;

  @Inject
  private Block block;

  private int someValue = 12345;

  @SessionState
  private User user;

  private boolean userExists;
  public boolean getUserExists()
  {
    return userExists;
  }
  public User getUser()
  {
    return user;
  }
  public String getMessage()
  {
    return message;
  }
  public void setMessage(String message)
  {
    System.out.println("Setting the message: " + message);
    this.message = message;
  }
  public int getSomeValue()
  {
    return someValue;
  }
  public void setSomeValue(int value)
  {
    this.someValue = value;
  }

  // Handle call with an unwanted context
  Object onActivate(EventContext eventContext)
  {
    return eventContext.getCount() > 0 ?
        new HttpError(404, "Resource not found") :
            null;
  }


  Object onActionFromLearnMore()
  {
    about.setLearn("LearnMore");

    return about;
  }

  @Log
  void onComplete() {
    logger.info("Complete call on Index page");
  }

  @Log
  void onAjax()
  {
    logger.info("Ajax call on Index page");

    ajaxResponseRenderer.addRender("middlezone", block);
  }


  public String getCurrentTime()
  {
    String message = "Tapestry is cool";
    return message+ new  Date();
  }




  @OnEvent(value="submit", component="userInputForm")
  Object onFormSubmit()
  {
    System.out.println("Handling form submission!");
    String[] words = message.split(" ");
    if (words.length > 0)
    {
      user.setFirstName(words[0]);
      if (words.length > 1)
      {
        user.setLastName(words[1]);
      }
    }
    another.setPassedMessage(message);
    return another;
  }


}
