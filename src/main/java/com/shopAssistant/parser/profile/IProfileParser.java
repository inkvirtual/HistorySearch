package com.shopAssistant.parser.profile;

import com.shopAssistant.profiles.IProfile;

/**
 * Created by fanta on 7/3/17.
 */
public interface IProfileParser {
    String getName(String page);

    IProfile parse(String page);
}
