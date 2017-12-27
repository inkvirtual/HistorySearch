package com.shopAssistant.currency;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyHandler {
    private static final Logger LOGGER = Logger.getLogger(CurrencyHandler.class.getName());

    private Set<AbstractCurrency> currencies;

    private CurrencyHandler() {
        currencies = new HashSet<>();
    }

    public static CurrencyHandler create() {
        return new CurrencyHandler();
    }

    public void addCurrency(AbstractCurrency currency) {
        if (currency == null) {
            LOGGER.log(Level.WARNING, "Could not add null currency.");
            return;
        }

        this.currencies.add(currency);
        LOGGER.log(Level.INFO, "Added Currency : " + currency);
    }

    public Set<AbstractCurrency> getCurrencies() {
        return this.currencies;
    }

    public AbstractCurrency parseSymbol(String symbol) {
        if (symbol == null || symbol.length() == 0)
            return null;

        for (AbstractCurrency currency : currencies)
            if (symbol.equalsIgnoreCase(currency.getSymbol()))
                return currency;

        return null;
    }

    public AbstractCurrency parseCode(String code) {
        if (code == null || code.length() == 0)
            return null;

        for (AbstractCurrency currency : currencies)
            if (code.equalsIgnoreCase(currency.getCode()))
                return currency;

        return null;
    }

    public AbstractCurrency parseDescription(String description) {
        if (description == null || description.length() == 0)
            return null;

        for (AbstractCurrency currency : currencies)
            if (description.equalsIgnoreCase(currency.getDescription()))
                return currency;

        return null;
    }
}
