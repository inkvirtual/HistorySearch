package com.shopAssistant.profiles;

import com.shopAssistant.application.PhoneNumber;

import java.util.Set;

public interface IProfile {
    AuthorType getAuthorType();
    String getName();
    Set<PhoneNumber> getPhoneNumbers();
}
