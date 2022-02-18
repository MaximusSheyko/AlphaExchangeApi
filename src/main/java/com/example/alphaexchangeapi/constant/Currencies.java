package com.example.alphaexchangeapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currencies {
    BASIC("UAH");

    private final String currency;
}
