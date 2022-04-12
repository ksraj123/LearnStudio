package com.learnstudio.contentservice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learnstudio.contentservice.enums.CurrencyCode;
import com.learnstudio.contentservice.enums.PricingType;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceTree {
    private Long id;

    private CurrencyCode currencyCode;

    private Double price;

    private Double originalPrice;

    private Boolean isPurchased;

    private PricingType pricingType;

    private List<PriceTree> childCourses;

    private List<PriceTree> contents;
}

