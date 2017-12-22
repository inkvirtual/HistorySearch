package com.shopAssistant.parser.offer;

import com.shopAssistant.offer.AbstractOffer;

public interface IOfferParser {
    AbstractOffer parse(String page);
}
