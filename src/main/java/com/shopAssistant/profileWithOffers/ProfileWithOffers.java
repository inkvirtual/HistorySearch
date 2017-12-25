package com.shopAssistant.profileWithOffers;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;

public class ProfileWithOffers {
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
        if (profile != null)
            this.profile = profile;
    }

    public Set<AbstractOffer> getOffers() {
        return offers;
    }

//    public void setOffers(Set<AbstractOffer> offers) {
//        if (offers != null)
//            this.offers = offers;
//    }

    public boolean addOffer(AbstractOffer offer) {
        if (offer == null || this.offers == null)
            return false;

        for (AbstractOffer elem : this.offers)
            if (elem.getId().equals(offer.getId()))
                return false;

        return this.offers.add(offer);
    }

    public String getProfileName() {
        return profile.getName();
    }
}
