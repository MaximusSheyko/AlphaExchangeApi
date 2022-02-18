package com.example.alphaexchangeapi.service;

import com.example.alphaexchangeapi.service.exception.RateCurrencyNotFoundException;

public interface ExchangeRatesService {

    String getBuyRate(String currency);

    boolean existRateByCurrency(String currency);

    boolean existRateByCurrencies(String... currencies) throws RateCurrencyNotFoundException;

    String getSaleRate(String currencyConversion);
}
