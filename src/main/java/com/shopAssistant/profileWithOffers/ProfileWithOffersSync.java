package com.shopAssistant.profileWithOffers;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileWithOffersSync {
    private static final Logger LOGGER = Logger.getLogger(ProfileWithOffers.class.getName());

    private Set<ProfileWithOffers> profilesWithOffers;

    public ProfileWithOffersSync() {
        this.profilesWithOffers = new HashSet<>();
    }

    public boolean addProfile(IProfile profile) {
        ProfileWithOffers newProfileWithOffers;

        if (profile == null) {
            throw new IllegalArgumentException("Could not add null Profile.");
        }

        for (ProfileWithOffers elem : this.profilesWithOffers) {
            if (elem.getProfileName().equals(profile.getProfileName())) {
                LOGGER.log(Level.WARNING, "Profile already added : " + elem.getProfileName());
                return false;
            }
        }

        newProfileWithOffers = new ProfileWithOffers(profile);

        LOGGER.log(Level.INFO, "Added new ProfileWithOffers with Profile : " + newProfileWithOffers.getProfileName());
        return this.profilesWithOffers.add(newProfileWithOffers);
    }

    public boolean addOffer(AbstractOffer offer) {
        if (offer == null)
            throw new IllegalArgumentException("Offer should be initialized");

        for (ProfileWithOffers elem : profilesWithOffers) {
            if (elem.getProfileName().equals(offer.getProfileName())) {
                LOGGER.log(Level.INFO, "Added Offer for Profile " + offer.getProfileName());
                return elem.addOffer(offer);
            }
        }

        LOGGER.log(Level.WARNING, "Could Add Offer " + offer.getId() + " as Profile " + offer.getProfileName() + " was not found.");
        return false;
    }

    public boolean addOffer(IProfile profile, AbstractOffer offer) {
        ProfileWithOffers newProfileWithOffers;

        if (profile == null || offer == null)
            throw new IllegalArgumentException("Both Profile and Offer should be initialized");

        if (!profile.getProfileName().equals(offer.getProfileName()))
            throw new IllegalArgumentException("Offer " + offer.getId() + " does not belong to " + profile.getProfileName() + " profile");

        for (ProfileWithOffers profileWithOffers : profilesWithOffers) {
            if (profileWithOffers.getProfileName().equals(profile.getProfileName())) {
                LOGGER.log(Level.INFO, "Existing Profile " + profile.getProfileName() + " added Offer " + offer.getId());
                return profileWithOffers.addOffer(offer);
            }
        }

        newProfileWithOffers = new ProfileWithOffers(profile);
        newProfileWithOffers.addOffer(offer);

        LOGGER.log(Level.INFO, "New Profile " + profile.getProfileName() + " added Offer " + offer.getId());
        profilesWithOffers.add(newProfileWithOffers);
        return true;
    }
}