package com.packtpub.t5first.pages;

import com.packtpub.t5first.data.IDataSource;
import com.packtpub.t5first.model.Celebrity;
import com.packtpub.t5first.model.TheTest;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

/**
 * Created by Kalantaev Alexandr on 24.06.2016.
 */
public class AddCelebrity {
    @Property

    private Celebrity celebrity;
    @SessionState
    private IDataSource dataSource;
    Object onSubmitFromCelebrity()
    {
        System.out.println(celebrity.getFirstName());
        dataSource.addCelebrity(celebrity);
        System.out.println();
        return ShowAll.class;
    }
}
