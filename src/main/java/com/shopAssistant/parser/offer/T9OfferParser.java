package com.shopAssistant.parser.offer;

import com.shopAssistant.offer.AbstractOffer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by fanta on 7/4/17.
 */
public class T9OfferParser implements IOfferParser {
    public static final String NAME = "999";

    @Override
    public String getName() {
        return T9OfferParser.NAME;
    }

    @Override
    public AbstractOffer parse(String page) {
        throw new NotImplementedException();
    }
}
