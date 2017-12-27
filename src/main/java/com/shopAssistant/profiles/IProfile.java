package com.shopAssistant.profiles;

import com.shopAssistant.phoneNumber.PhoneNumber;

import java.net.URL;
import java.util.Set;

public interface IProfile {
    AuthorType getAuthorType();
    String getProfileName();
    URL getUrl();
    Set<PhoneNumber> getPhoneNumbers();
}
