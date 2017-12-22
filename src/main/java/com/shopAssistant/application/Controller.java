package com.shopAssistant.application;

import com.shopAssistant.configuration.IConfiguration;
import com.shopAssistant.currency.CurrencyHandler;
import com.shopAssistant.currency.currencies.EURO;
import com.shopAssistant.currency.currencies.MDL;
import com.shopAssistant.currency.currencies.USD;

import java.util.Map;

public class Controller {
    private Map<String, String> properties;

    public Controller(IConfiguration configuration) {
        properties = configuration.getProperties();
        addCurrencies();
    }

    private void addCurrencies() {
        CurrencyHandler.addCurrency(new MDL());
        CurrencyHandler.addCurrency(new EURO());
        CurrencyHandler.addCurrency(new USD());
    }
}
