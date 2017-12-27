package com.shopAssistant.parser.offer;

import com.shopAssistant.offer.AbstractOffer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MaklerOfferParser implements IOfferParser {
    public static final String NAME = "Makler";

    @Override
    public String getName() {
        return MaklerOfferParser.NAME;
    }

    @Override
    public AbstractOffer parse(String page) {
        throw new NotImplementedException();
    }
}
