package com.shopAssistant.offer;

import com.shopAssistant.currency.Currency;

import java.util.Date;

/**
 * Created by fanta on 7/3/17.
 */
public abstract class AbstractOffer {
    private Integer price;
    private Currency currency;
    private Date publicationTime;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(Date publicationTime) {
        this.publicationTime = publicationTime;
    }
}
