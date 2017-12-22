package com.shopAssistant.application;

import com.shopAssistant.configuration.IConfiguration;
import com.shopAssistant.currency.CurrencyHandler;
import com.shopAssistant.currency.currencies.EURO;
import com.shopAssistant.currency.currencies.MDL;
import com.shopAssistant.currency.currencies.USD;
import com.shopAssistant.parser.Parser;
import com.shopAssistant.parser.offer.T9OfferParser;
import com.shopAssistant.parser.profile.T9ProfileParser;

import java.util.Map;

public class Controller {
    private Map<String, String> properties;
    private Parser parser;

    public Controller(IConfiguration configuration) {
        properties = configuration.getProperties();
        parser = initializeParsers();
        addCurrencies();
    }

    private Parser initializeParsers() {
        Parser parser = new Parser();
        parser.addOfferParser(new T9OfferParser());
        parser.addProfileParser(new T9ProfileParser());

        return parser;
    }

    private void addCurrencies() {
        CurrencyHandler.addCurrency(new MDL());
        CurrencyHandler.addCurrency(new EURO());
        CurrencyHandler.addCurrency(new USD());
    }
}
