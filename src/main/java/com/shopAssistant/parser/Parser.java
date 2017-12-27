package com.shopAssistant.parser;

import com.shopAssistant.offer.AbstractOffer;
import com.shopAssistant.parser.offer.IOfferParser;
import com.shopAssistant.parser.profile.IProfileParser;
import com.shopAssistant.profiles.IProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fanta on 7/4/17.
 */
public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
    private static final String DEFAULT_NAME = "NOT_DEFINED";

    private String parserName;
    private Set<IOfferParser> offerParsers;
    private Set<IProfileParser> profileParsers;

    public Parser() {
        this.parserName = DEFAULT_NAME;
        this.offerParsers = new HashSet<>();
        this.profileParsers = new HashSet<>();
    }

    private void setParserName(String newName) {
        if (newName == null || newName.length() == 0)
            throw new IllegalArgumentException("Parser Name not initialized.");

        if (this.parserName.equals(DEFAULT_NAME))
            this.parserName = newName;
    }

    public void addOfferParser(IOfferParser parser) {
        if (parser == null)
            throw new IllegalArgumentException(parserName + " Parser:  Could not add null Offer Parser");

        if (!parser.getName().equals(parserName))
            throw new IllegalArgumentException(parserName + " Parser: Could not add incompatible Offer Parser: " + parser.getName());

        offerParsers.add(parser);
        LOGGER.log(Level.INFO, parserName + " Added Offer Parser.");

        setParserName(parser.getName());
    }

    public void addProfileParser(IProfileParser parser) {
        if (parser == null)
            throw new IllegalArgumentException(parserName + " Parser:  Could not add null Profile Parser");

        if (!parser.getName().equals(parserName))
            throw new IllegalArgumentException(parserName + " Parser: Could not add incompatible Profile Parser: " + parser.getName());

        profileParsers.add(parser);
        LOGGER.log(Level.INFO, parserName + " Added Profile Parser.");

        setParserName(parser.getName());
    }

    public AbstractOffer parseOffer(String page) {
        AbstractOffer result = null;

        for (IOfferParser parser : offerParsers) {
            result = parser.parse(page);
            if (result != null) {
                LOGGER.log(Level.INFO, parserName + " Parsed offer " + result.getId());
                return result;
            }
        }

        if (result == null)
            LOGGER.log(Level.WARNING, parserName + " Could not parse Offer.");

        return null;
    }

    public IProfile parseProfile(String page) {
        IProfile result = null;

        for (IProfileParser parser : profileParsers) {
            result = parser.parse(page);
            if (result != null) {
                LOGGER.log(Level.INFO, parserName + " Parsed profile " + result.getProfileName());
                return result;
            }
        }

        if (result == null)
            LOGGER.log(Level.WARNING, parserName + " Could not parse Profile.");

        return null;
    }
}
