package com.example.alphaexchangeapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MoneyScale {
    SCALE_DEFAULT(2);

    private final int scale;
}
