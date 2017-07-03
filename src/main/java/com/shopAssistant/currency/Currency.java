package com.shopAssistant.currency;

/**
 * Created by fanta on 7/3/17.
 */
public class Currency {
    private String symbol;
    private String code;
    private String description;

    public Currency(String symbol, String code, String description) {
        this.symbol = symbol;
        this.code = code;
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
