package com.shopAssistant.parser.profile;

import com.shopAssistant.profiles.IProfile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MaklerProfileParser implements IProfileParser {
    public static final String NAME = "MAKLER";

    @Override
    public String getName(String page) {
        return NAME;
    }

    @Override
    public IProfile parse(String page) {
        throw new NotImplementedException();
    }
}
