package com.shopAssistant.currency;

/**
 * Created by fanta on 7/3/17.
 */

// TODO: add symbols for EUR and MDL currencies, update parseCurrency() with those symbole
public class Currencies {
    public static Currency EUR = new Currency("", "EUR", "Euro");
    public static Currency USD = new Currency("$", "USD", "United States Dollar");
    public static Currency MDL = new Currency("", "MDL", "Moldovan Lei");

    public static Currency parseCurrency(String symbol) {
        if (symbol == null || symbol.length() == 0) {
            throw new IllegalArgumentException("Null or empty <symbol> argument in Currency.parseCurrency() method");
        }

        switch (symbol) {
            case "dsfs":
                return EUR;
            case "$":
                return USD;
            case "fdf":
                return MDL;
            default:
                throw new IllegalArgumentException(String.format("Unknown <%s> Currency!", symbol));
        }
    }
}
