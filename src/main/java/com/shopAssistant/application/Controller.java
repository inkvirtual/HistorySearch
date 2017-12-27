package com.shopAssistant.application;

import com.shopAssistant.configuration.IConfiguration;
import com.shopAssistant.currency.AbstractCurrency;
import com.shopAssistant.currency.CurrencyHandler;
import com.shopAssistant.currency.currencies.EURO;
import com.shopAssistant.currency.currencies.MDL;
import com.shopAssistant.currency.currencies.USD;
import com.shopAssistant.parser.Parser;
import com.shopAssistant.parser.offer.IOfferParser;
import com.shopAssistant.parser.offer.MaklerOfferParser;
import com.shopAssistant.parser.offer.T9OfferParser;
import com.shopAssistant.parser.profile.IProfileParser;
import com.shopAssistant.parser.profile.MaklerProfileParser;
import com.shopAssistant.parser.profile.T9ProfileParser;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    private static final Logger LOGGER = Logger.getLogger("Controller");

    private Map<String, String> properties;
    private Parser parser;
    private CurrencyHandler currencyHandler;

    public Controller(IConfiguration configuration) {
//        properties = configuration.getProperties();
        parser = initializeParsers();
        currencyHandler = initializeCurrencyHandler();
    }

    private Parser initializeParsers() {
        Parser parser = new Parser();

        parser.addProfileParser(new T9ProfileParser());
        parser.addOfferParser(new T9OfferParser());

        parser.addProfileParser(new MaklerProfileParser());
        parser.addOfferParser(new MaklerOfferParser());

        return parser;
    }

    private CurrencyHandler initializeCurrencyHandler() {
        CurrencyHandler currencyHandler = CurrencyHandler.create();

        AbstractCurrency mdl = new MDL();
        AbstractCurrency euro = new EURO();
        AbstractCurrency usd = new USD();

        currencyHandler.addCurrency(mdl);
        currencyHandler.addCurrency(euro);
        currencyHandler.addCurrency(usd);
        LOGGER.log(Level.CONFIG, "Added following currencies: " + mdl.getDescription() + ", " + euro.getDescription() + ", " + usd.getDescription());

        return currencyHandler;
    }
}
