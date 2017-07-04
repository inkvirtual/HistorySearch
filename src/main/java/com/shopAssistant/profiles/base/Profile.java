package com.shopAssistant.profiles.base;

import com.shopAssistant.profiles.base.IProfile;

import java.util.Set;

/**
 * Created by fanta on 7/3/17.
 */
public class Profile implements IProfile {
    protected String name;
    protected Set<String> phoneNumbers;

    public Profile(String name, Set<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
