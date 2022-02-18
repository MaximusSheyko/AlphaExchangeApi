package com.example.alphaexchangeapi.service.implementation;

import com.example.alphaexchangeapi.constant.Currencies;
import com.example.alphaexchangeapi.service.CurrencyStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Predicate;

@Service
public class CurrencyStoreImpl implements CurrencyStoreService {

    private final Logger LOGGER = LoggerFactory.getLogger( CurrencyStoreImpl.class);

    @Override
    public boolean existsByAbbreviation(String abbreviation) {
        boolean isFound = false;
        LOGGER.debug("abbreviation: {} found: {}", abbreviation, isFound);
        return isFound;
    }

    @Override
    public boolean anyMatchCurrency(String... currencies){
        Predicate<String> matcher = this::existsByAbbreviation;
        return Arrays.stream(currencies).anyMatch(matcher);
    }

    @Override
    public boolean anyMatchCurrencyBasic(String... currencies){
        return Arrays.stream(currencies)
                .anyMatch(currency -> currency.equals(Currencies.BASIC.getCurrency()));
    }
}
