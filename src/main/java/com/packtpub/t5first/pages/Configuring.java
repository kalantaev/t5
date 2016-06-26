package com.packtpub.t5first.pages;

import org.apache.tapestry5.Asset2;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Created by Kalantaev Alexandr on 25.06.2016.
 */
public class Configuring {
    @Persist
    @Property
    private String val;

    @Property
    @Inject
    @Path("context:fckconf.js")
    private Asset2 customConf;

    void onSuccess() {
        //Here you can save the value etc.
    }
}
