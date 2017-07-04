package com.shopAssistant.parsers.base.parserResult;

import com.shopAssistant.offers.base.IOffer;
import com.shopAssistant.profiles.base.IProfile;

/**
 * Created by fanta on 7/3/17.
 */
public class ParserResult implements IParserResult{

    protected ResultType resultType;
    protected FailReason failReason;
    protected IOffer offer;
    protected IProfile profile;

    public ParserResult(ResultType resultType, FailReason failReason, IOffer offer, IProfile profile) {
        this.resultType = resultType;
        this.failReason = failReason;
        this.offer = offer;
        this.profile = profile;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public FailReason getFailReason() {
        return failReason;
    }

    public IOffer getOffer() {
        return offer;
    }

    public IProfile getProfile() {
        return profile;
    }
}
