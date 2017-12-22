package com.shopAssistant.profiles;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fanta on 7/3/17.
 */
public class Profile implements IProfile {
    private String name;
    private Set<String> phoneNumbers;

    public Profile(String name) {
        this.name = name;
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(String number) {
        if (number != null || number.length() != 0)
            phoneNumbers.add(number);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

}
