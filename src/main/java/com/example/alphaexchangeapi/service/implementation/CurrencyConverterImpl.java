package com.example.alphaexchangeapi.service.implementation;

import com.example.alphaexchangeapi.constant.Currencies;
import com.example.alphaexchangeapi.service.CurrencyConverterService;
import com.example.alphaexchangeapi.service.CurrencyStoreService;
import com.example.alphaexchangeapi.service.ExchangeRatesService;
import com.example.alphaexchangeapi.service.exception.RateCurrencyNotFoundException;
import com.example.alphaexchangeapi.util.MoneyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConverterImpl implements CurrencyConverterService<BigDecimal> {

    private final CurrencyStoreService currencyStoreService;

    private final ExchangeRatesService exchangeService;

    private final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverterImpl.class);

    @Autowired
    public CurrencyConverterImpl(CurrencyStoreService currencyStoreService,ExchangeRatesService exchangeService) {
        this.currencyStoreService = currencyStoreService;
        this.exchangeService = exchangeService;
    }

    @Override
    public BigDecimal convert(String totalSaleSum, String currencySale, String currencyBuy) throws RateCurrencyNotFoundException {
        BigDecimal totalSumBuy;
        try{
            exchangeService.existRateByCurrencies(currencySale, currencyBuy);
            if (!currencyStoreService.anyMatchCurrencyBasic(currencySale, currencyBuy)){
                totalSumBuy = useCrossConversion(totalSaleSum, currencySale, currencyBuy);
            }else if (currencyBuy.equals(Currencies.BASIC.getCurrency())){
                totalSumBuy = convertToCurrencyBasic(totalSaleSum, currencyBuy);
            }else {
                totalSumBuy = convertCurrencyBasicToCurrency(totalSaleSum, currencyBuy);
            }
        }catch (RateCurrencyNotFoundException e){
            throw new RateCurrencyNotFoundException("currency not found");
        }
        return totalSumBuy;
    }

    private BigDecimal convertToCurrencyBasic(String totalConvertSum, String currencyConversion) {
        String currencyBuyAmount = exchangeService.getBuyRate(currencyConversion);
        return MoneyUtils.multiply(totalConvertSum, currencyBuyAmount);
    }

    private BigDecimal convertCurrencyBasicToCurrency(String totalConvertSum,String currencyConversion) {
        String currencySaleAmount = exchangeService.getSaleRate(currencyConversion);
        return MoneyUtils.divide(totalConvertSum, currencySaleAmount);
    }

    private BigDecimal useCrossConversion(String totalSaleSum, String currencySale, String currencyBuy) {
        BigDecimal currencyBasicAmount = convertToCurrencyBasic(totalSaleSum, currencySale);
        LOGGER.debug("conversion currency sum: {} convert to currency {}",totalSaleSum, currencyBasicAmount);
        BigDecimal currencyTargetAmount = convertCurrencyBasicToCurrency(currencyBasicAmount.toString(), currencyBuy);
        LOGGER.debug("total currency basic: {} convert to currency {}",currencyBasicAmount, currencyTargetAmount);
        return currencyTargetAmount;
    }
}
