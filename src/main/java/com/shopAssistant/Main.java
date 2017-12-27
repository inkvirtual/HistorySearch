package com.shopAssistant;

import com.shopAssistant.application.Controller;
import com.shopAssistant.currency.CurrencyHandler;
import com.shopAssistant.currency.currencies.MDL;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    //    public static final Logger LOGGER = LoggerFactory.getLogger("HistorySearch");
    public static final Logger LOGGER = Logger.getLogger("HistorySearch");

    private static final String RESOURCES_PATH = "../HistorySearch";
    private static final String SERVICE_PROPERTIES = "history_search.properties";


    public static void main(String[] args) {
        // write your code here
        LOGGER.log(Level.INFO, "This is a info message");

        Controller controller = new Controller(null);

    }
}
