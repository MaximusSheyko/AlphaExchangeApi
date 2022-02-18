package com.example.alphaexchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseFormDto {

    private String currency;

    private String totalBuyAmount;

    private String passwordOtp;
}
