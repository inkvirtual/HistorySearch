package com.shopAssistant.profiles;

import com.shopAssistant.application.PhoneNumber;
import com.shopAssistant.offer.AbstractOffer;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by fanta on 7/3/17.
 */
public class Profile implements IProfile {
    private static final Logger log = Logger.getLogger(Profile.class.getName());

    private AuthorType authorType;
    private String name;
    private Set<PhoneNumber> phoneNumbers;
    private Set<AbstractOffer> offers;

    public Profile(String name) {
        this.name = name;
        this.phoneNumbers = new HashSet<>();
        this.offers = new HashSet<>();
        this.authorType = AuthorType.UNKNOWN;
    }

    public Set<AbstractOffer> getOffers() {
        return offers;
    }

    public void setOffers(Set<AbstractOffer> offers) {
        this.offers = offers;
    }

    public void addOffer(AbstractOffer offer) {
        if (offer != null)
            this.offers.add(offer);
    }

    @Override
    public AuthorType getAuthorType() {
        return authorType;
    }

    public void setAuthorType(AuthorType newAuthorType) {
        if (this.authorType != AuthorType.UNKNOWN) {
            log.warning("AuthorType already set to " + this.authorType.name() + ", could not change to " + newAuthorType.name());
            return;
        }
        this.authorType = newAuthorType;
    }

    public void addPhoneNumber(PhoneNumber number) {
        if (number != null)
            phoneNumbers.add(number);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}