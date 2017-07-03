package com.shopAssistant.offers.base;

import com.shopAssistant.currency.Currency;

/**
 * Created by fanta on 7/3/17.
 */
public class Offer {
    protected Integer price;
    protected Currency currency;
    protected Long timeStamp;
    protected String dateTime;

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getDateTime() {
        return dateTime;
    }
}
