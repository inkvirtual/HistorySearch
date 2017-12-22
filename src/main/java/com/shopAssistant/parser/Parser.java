package com.shopAssistant.parser;

import com.shopAssistant.Main;
import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.parser.offer.IOfferParser;
import com.shopAssistant.parser.profile.IProfileParser;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fanta on 7/4/17.
 */
public class Parser {
    private Set<IOfferParser> offerParsers;
    private Set<IProfileParser> profileParsers;

    public Parser() {
        this.offerParsers = new HashSet<>();
        this.profileParsers = new HashSet<>();
    }

    public void addOfferParser(IOfferParser parser) {
        offerParsers.add(parser);
    }

    public void addProfileParser(IProfileParser parser) {
        profileParsers.add(parser);
    }

    public AbstractOffer parseOffer(String page) {
        AbstractOffer result = null;

        for (IOfferParser parser : offerParsers) {
            result = parser.parse(page);
            if (result != null)
                return result;
        }

        if (result == null)
            Main.LOGGER.error("Parse AbstractOffer failed.");

        return null;
    }

    public IProfile parseProfile(String page) {
        IProfile result = null;

        for (IProfileParser parser : profileParsers) {
            result = parser.parse(page);
            if (result != null)
                return result;
        }

        if (result == null)
            Main.LOGGER.error("Parse Profile failed.");

        return null;
    }
}
