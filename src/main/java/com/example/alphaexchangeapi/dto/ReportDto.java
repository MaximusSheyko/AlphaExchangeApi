package com.example.alphaexchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReportDto {

    private String date;

    private Integer numberSaleDeals;

    private List<ReportDataDto> data;

}
