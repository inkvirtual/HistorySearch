package com.shopAssistant.parser.offer;

import com.shopAssistant.offer.AbstractOffer;

public interface IOfferParser {
    String getName();
    AbstractOffer parse(String page);
}
