package com.shopAssistant.currency;

import java.util.HashSet;
import java.util.Set;

public class CurrencyHandler {
    private static Set<Currency> currencies = new HashSet<>();

    public static void addCurrency(Currency currency) {
        if (currency != null)
            CurrencyHandler.currencies.add(currency);
    }

    public static Set<Currency> getCurrencies() {
        return CurrencyHandler.currencies;
    }

    public static Currency parseSymbol(String symbol) {
        if (symbol == null || symbol.length() == 0)
            return null;

        for (Currency currency : currencies)
            if (symbol.equalsIgnoreCase(currency.getSymbol()))
                return currency;

        return null;
    }

    public static Currency parseCode(String code) {
        if (code == null || code.length() == 0)
            return null;

        for (Currency currency : currencies)
            if (code.equalsIgnoreCase(currency.getCode()))
                return currency;

        return null;
    }

    public static Currency parseDescription(String description) {
        if (description == null || description.length() == 0)
            return null;

        for (Currency currency : currencies)
            if (description.equalsIgnoreCase(currency.getDescription()))
                return currency;

        return null;
    }
}
