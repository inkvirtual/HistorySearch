package com.shopAssistant.profiles;

import java.util.List;

/**
 * Created by fanta on 7/3/17.
 */
public class Profile implements IProfile {
    protected String name;
    protected List<String> phoneNumbers;

    public Profile(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
