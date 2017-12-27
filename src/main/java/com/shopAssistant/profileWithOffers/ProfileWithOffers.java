package com.shopAssistant.profileWithOffers;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileWithOffers {
    private static final Logger LOGGER = Logger.getLogger(ProfileWithOffers.class.getName());

    private IProfile profile;
    private Set<AbstractOffer> offers;

    public ProfileWithOffers(IProfile profile) {
        setProfile(profile);
        this.offers = new HashSet<>();
    }

    public IProfile getProfile() {
        return profile;
    }

    private void setProfile(IProfile profile) {
        if (profile == null) {
            LOGGER.log(Level.WARNING, "Failed to add null Profile");
            return;
        }

        this.profile = profile;
        LOGGER.log(Level.INFO, "Added profile " + getProfileName());
    }

    public Set<AbstractOffer> getOffers() {
        return offers;
    }

//    public void setOffers(Set<AbstractOffer> offers) {
//        if (offers != null)
//            this.offers = offers;
//    }

    private void checkProfileIsNotNull() {
        if (this.profile == null)
            throw new NullPointerException("Profile is not initialized.");
    }

    public boolean addOffer(AbstractOffer offer) {
        checkProfileIsNotNull();

        if (offer == null || this.offers == null)
            throw new IllegalArgumentException(getProfileName() + " Profile failed to add null Offer");

        for (AbstractOffer elem : this.offers) {
            if (elem.getId().equals(offer.getId())) {
                LOGGER.log(Level.WARNING, getProfileName() + " Profile the Offer already added : " + elem.getId());
                return false;
            }
        }

        LOGGER.log(Level.INFO, getProfileName() + " Profile added Offer : " + offer.getId());
        return this.offers.add(offer);
    }

    public String getProfileName() {
        return profile.getProfileName();
    }
}
