package com.example.alphaexchangeapi.util;

import com.example.alphaexchangeapi.constant.MoneyScale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

public class MoneyUtils {

    public static BigDecimal roundTotalSum(BigDecimal totalSum){
        return totalSum.setScale(MoneyScale.SCALE_DEFAULT.getScale(), RoundingMode.HALF_DOWN);
    }

    public static BigDecimal divide(String currencySum, String currencyRateSum){
        return new BigDecimal(currencySum).multiply(new BigDecimal(currencyRateSum));
    }

    public static BigDecimal multiply(String currencySum, String currencyRateSum){
        return new BigDecimal(currencySum).multiply(new BigDecimal(currencyRateSum));
    }

    public static void main(String[] args) {
        String currVar1 = "1000.5";
        String currVar2 = "28.15";
        var result = multiply(currVar1, currVar2);
        Stream.of(result, roundTotalSum(result)).forEach(System.out::println);
    }
}
