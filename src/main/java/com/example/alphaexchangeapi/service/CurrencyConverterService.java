package com.example.alphaexchangeapi.service;

import com.example.alphaexchangeapi.service.exception.RateCurrencyNotFoundException;

public interface CurrencyConverterService<T> {

    T convert(String totalSaleSum, String currencySale, String currencyBuy) throws RateCurrencyNotFoundException;
}
