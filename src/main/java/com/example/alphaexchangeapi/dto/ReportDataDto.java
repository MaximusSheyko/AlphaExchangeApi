package com.example.alphaexchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportDataDto {

    private String currency;

    private Integer numberDeals;

    private Integer totalSaleAmount;

    private Integer totalBuyAmount;
}
