package com.example.alphaexchangeapi.service;

public interface CurrencyStoreService {
    boolean existsByAbbreviation(String abbreviation);

    boolean anyMatchCurrency(String... currencies);

    boolean anyMatchCurrencyBasic(String... currencies);

}
