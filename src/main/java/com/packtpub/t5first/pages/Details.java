package com.packtpub.t5first.pages;

import com.packtpub.t5first.data.IDataSource;
import com.packtpub.t5first.data.MockDataSource;
import com.packtpub.t5first.model.Celebrity;
import com.packtpub.t5first.util.Formats;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;

import java.text.Format;

/**
 * Created by Kalantaev Alexandr on 23.06.2016.
 */
public class Details {
    @SessionState
    private IDataSource dataSource;
    private Celebrity celebrity;
    public void setCelebrity(Celebrity c)
    {
        this.celebrity = c;
    }
    public Celebrity getCelebrity()
    {
        return celebrity;
    }
    public Format getDateFormat()
    {
        return Formats.getDateFormat();
    }
    void onActivate(long id)
    {
        celebrity = dataSource.getCelebrityById(id);
    }

}
