package com.packtpub.t5first.pages;

import java.text.Format;
import java.util.List;

import com.packtpub.t5first.data.IDataSource;
import com.packtpub.t5first.model.Celebrity;
import com.packtpub.t5first.model.User;
import com.packtpub.t5first.util.CelebritySource;
import com.packtpub.t5first.util.Formats;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.grid.GridDataSource;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class ShowAll {
    @SessionState
    private User user;
    private boolean userExists;
    @SessionState
    private IDataSource dataSource;
    @InjectPage
    private Details detailsPage;
    private Celebrity celebrity;
    String onActivate()
    {
        if (!userExists) return "index";
        return null;
    }
//    @OnEvent(component="detailsLink")
//    Object onShowDetails(long id)  {
//        Celebrity celebrity = dataSource.getCelebrityById(id);
//        detailsPage.setCelebrity(celebrity);
//        return detailsPage;
//    }

    public GridDataSource getCelebritySource()
    {
        return new CelebritySource(dataSource);
    }

    public List<Celebrity> getAllCelebrities()
    { System.out.println("Getting all celebrities...");
        return dataSource.getAllCelebrities();
    }
    public Celebrity getCelebrity()
    {
        return celebrity;
    }
    public void setCelebrity(Celebrity celebrity)
    {
        this.celebrity = celebrity;
    }
    public Format getDateFormat()
    {
        return Formats.getDateFormat();
    }
}
