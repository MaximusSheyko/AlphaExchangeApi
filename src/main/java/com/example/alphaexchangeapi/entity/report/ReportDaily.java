package com.example.alphaexchangeapi.entity.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDaily {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  private Integer totalDealsAmount;

  // private List<ReportDailyData> data;

}
