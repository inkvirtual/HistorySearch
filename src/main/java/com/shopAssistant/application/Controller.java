package com.shopAssistant.application;

import com.shopAssistant.Main;
import com.shopAssistant.offers.base.IOffer;
import com.shopAssistant.parsers.IParser;
import com.shopAssistant.parsers.OfferParser;
import com.shopAssistant.parsers.ProfileParser;
import com.shopAssistant.parsers.base.parserResult.IParserResult;
import com.shopAssistant.parsers.base.parserResult.ResultType;
import com.shopAssistant.profiles.base.IProfile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fanta on 7/4/17.
 */
public class Controller {
    private List<OfferParser> offerParsers = Collections.synchronizedList(new ArrayList<>());
    private List<ProfileParser> profileParsers = Collections.synchronizedList(new ArrayList<>());

    public void addToOfferParsers(OfferParser parser) {
        offerParsers.add(parser);
    }

    public void addToProfileParsers(ProfileParser parser) {
        profileParsers.add(parser);
    }

    public IOffer parseOffer(String text) {
        IParserResult result = null;

        for (OfferParser parser : offerParsers) {
            result = parser.parse(text);
            if (result.getResultType().equals(ResultType.SUCCESS))
                return result.getOffer();
        }

        if (result != null)
            Main.LOGGER.error("Parse Offer failed for reason:", result.getFailReason().name());

        return null;
    }

    public IProfile parseProfile(String text) {
        IParserResult result = null;

        for (ProfileParser parser : profileParsers) {
            result = parser.parse(text);
            if (result.getResultType().equals(ResultType.SUCCESS))
                return result.getProfile();
        }

        if (result != null)
            Main.LOGGER.error("Parse Profile failed for reason:", result.getFailReason().name());

        return null;
    }
}
