package com.example.alphaexchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationFormDto {

    private String currencySale;

    private String currencyBuy;

    private String totalSaleAmount;
}
