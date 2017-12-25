package com.shopAssistant.profileWithOffers;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.profileWithOffers.ProfileWithOffers;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;

public class ProfileWithOffersSync {
    private Set<ProfileWithOffers> profilesWithOffers;

    public ProfileWithOffersSync() {
        profilesWithOffers = new HashSet<>();
    }

    public boolean addProfile(IProfile profile) {
        ProfileWithOffers newProfileWithOffers;

        if (profile == null)
            return false;

        for (ProfileWithOffers elem : profilesWithOffers) {
            if (elem.getProfileName().equals(profile.getName()))
                return false;
        }

        newProfileWithOffers = new ProfileWithOffers(profile);

        return profilesWithOffers.add(newProfileWithOffers);
    }

    public boolean addOffer(AbstractOffer offer) {
        if (offer == null)
            throw new IllegalArgumentException("Offer should be initialized");

        for (ProfileWithOffers elem : profilesWithOffers) {
            if (elem.getProfileName().equals(offer.getProfileName())) {
                return elem.addOffer(offer);
            }
        }

        // Could not find profile
        return false;
    }

    public boolean addOffer(IProfile profile, AbstractOffer offer) {
        ProfileWithOffers newProfileWithOffers;

        if (profile == null || offer == null)
            throw new IllegalArgumentException("Both Profile and Offer should be initialized");

        if (!profile.getName().equals(offer.getProfileName()))
            throw new IllegalArgumentException("Offer " + offer.getId() + " does not belong to " + profile.getName() + " profile");

        for (ProfileWithOffers profileWithOffers : profilesWithOffers) {
            if (profileWithOffers.getProfileName().equals(profile.getName())) {
                return profileWithOffers.addOffer(offer);
            }
        }

        newProfileWithOffers = new ProfileWithOffers(profile);
        newProfileWithOffers.addOffer(offer);

        profilesWithOffers.add(newProfileWithOffers);
        return true;
    }
}