package com.shopAssistant.profiles;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.phoneNumber.PhoneNumber;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fanta on 7/3/17.
 */
public class Profile implements IProfile {
    private static final Logger LOGGER = Logger.getLogger(Profile.class.getName());

    private AuthorType authorType;
    private String profileName;
    private URL url;
    private Set<PhoneNumber> phoneNumbers;
    private Set<AbstractOffer> offers;

    public Profile(String profileName, URL url) {
        this.profileName = profileName;
        this.phoneNumbers = new HashSet<>();
        this.url = url;
        this.offers = new HashSet<>();
        this.authorType = AuthorType.UNKNOWN;
    }

    public Set<AbstractOffer> getOffers() {
        return offers;
    }

    public void setOffers(Set<AbstractOffer> offers) {
        StringBuilder offersIds;

        if (offers == null || offers.size() == 0) {
            LOGGER.log(Level.WARNING, profileName + " Could not add null or empty offers.");
            return;
        }

        this.offers = offers;

        offersIds = new StringBuilder();
        for (AbstractOffer offer : offers) offersIds.append(offer.getId()).append(" ");

        LOGGER.log(Level.INFO, profileName + " Added " + offers.size() + " offers : " + offersIds.toString());
    }

    public void addOffer(AbstractOffer offer) {
        if (offer == null) {
            LOGGER.log(Level.WARNING, profileName + "Could not add null offer.");
            return;
        }

        this.offers.add(offer);
        LOGGER.log(Level.INFO, profileName + " Added offer " + offer.getId());
    }

    @Override
    public AuthorType getAuthorType() {
        return authorType;
    }

    public void setAuthorType(AuthorType newAuthorType) {
        if (this.authorType != AuthorType.UNKNOWN) {
            LOGGER.log(Level.WARNING, profileName + " AuthorType already set to " + this.authorType.name() +
                    ", could not change to " + newAuthorType.name());
            return;
        }

        this.authorType = newAuthorType;
        LOGGER.log(Level.INFO, profileName + " Author type set to " + newAuthorType.name());
    }

    public void addPhoneNumber(PhoneNumber number) {
        if (number == null) {
            LOGGER.log(Level.WARNING, profileName + " Could not add null Phone Number");
            return;
        }

        phoneNumbers.add(number);
        LOGGER.log(Level.INFO, profileName + " Added Phone Number " + number.getOnlyNumber());
    }

    @Override
    public String getProfileName() {
        return profileName;
    }

    @Override
    public URL getUrl() {
        return this.url;
    }

    @Override
    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbersToAdd) {
        StringBuilder phoneNums;

        if (phoneNumbersToAdd == null || phoneNumbersToAdd.size() == 0) {
            LOGGER.log(Level.WARNING, profileName + " Could not add null or empty phone numbers");
            return;
        }

        this.phoneNumbers = phoneNumbersToAdd;
        phoneNums = new StringBuilder();

        for (PhoneNumber number : phoneNumbersToAdd) phoneNums.append(number.getOnlyNumber()).append(" ");
        LOGGER.log(Level.INFO, profileName + " Added " + phoneNumbersToAdd.size() + " phone numbers: " + phoneNums.toString());
    }
}