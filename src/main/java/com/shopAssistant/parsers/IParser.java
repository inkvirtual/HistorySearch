package com.shopAssistant.parsers;

import com.shopAssistant.parsers.base.parserResult.IParserResult;

/**
 * Created by fanta on 7/3/17.
 */
public interface IParser {
    IParserResult parse(String text);
}
