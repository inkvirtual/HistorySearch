package com.shopAssistant.parser.profile;

import com.shopAssistant.profiles.IProfile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by fanta on 7/4/17.
 */
public class T9ProfileParser implements IProfileParser {
    public static final String NAME = "999";

    @Override
    public String getName(String page) {
        return NAME;
    }

    @Override
    public IProfile parse(String page) {
        throw new NotImplementedException();
    }
}
