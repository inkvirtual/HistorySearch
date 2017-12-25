package com.shopAssistant.offer;

import com.shopAssistant.application.PhoneNumber;
import com.shopAssistant.currency.Currency;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by fanta on 7/3/17.
 */
public abstract class AbstractOffer {
    private final static Logger LOGGER = Logger.getLogger("Offer");

    private Integer price;
    private Currency currency;
    private Date publicationTime;
    private Long id;
    private String offerText;
    private String profileName;
    private Set<PhoneNumber> phoneNumbers;

    public AbstractOffer() {
        price = null;
        currency = null;
        publicationTime = null;
        id = null;
        offerText = null;
        profileName = null;
        phoneNumbers = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber != null)
            this.phoneNumbers.add(phoneNumber);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }

}
