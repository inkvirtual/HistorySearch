package com.shopAssistant.parsers.base.parserResult;

import com.shopAssistant.offers.base.IOffer;
import com.shopAssistant.profiles.base.IProfile;

/**
 * Created by fanta on 7/3/17.
 */
public interface IParserResult {
    ResultType getResultType();
    FailReason getFailReason();
    IOffer getOffer();
    IProfile getProfile();
}
