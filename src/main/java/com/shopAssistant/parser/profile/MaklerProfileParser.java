package com.shopAssistant.parser.profile;

import com.shopAssistant.profiles.IProfile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MaklerProfileParser implements IProfileParser {
    public static final String NAME = "MAKLER";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getProfileName(String page) {
        throw new NotImplementedException();
    }

    @Override
    public IProfile parse(String page) {
        throw new NotImplementedException();
    }
}
