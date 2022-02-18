package com.example.alphaexchangeapi.service.implementation;

import com.example.alphaexchangeapi.service.ExchangeRatesService;
import com.example.alphaexchangeapi.service.exception.RateCurrencyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ExchangeRatesImpl implements ExchangeRatesService {


    private final Logger logger = LoggerFactory.getLogger(ExchangeRatesImpl.class);

    @Override
    public String getBuyRate(String currency) {
        boolean isFound = false;
        logger.debug("currency: {}, found: {}", currency, isFound);
        return null;
    }

    @Override
    public boolean existRateByCurrency(String currency) {
        boolean isFound = false;
        logger.debug("currency: {}, found: {}", currency, isFound);
        return isFound;
    }

    @Override
    public boolean existRateByCurrencies(String... currencies) throws RateCurrencyNotFoundException {
        return Arrays.stream( currencies ).allMatch(this::existRateByCurrency);
    }

    @Override
    public String getSaleRate(String currencyConversion) {
        return null;
    }
}
