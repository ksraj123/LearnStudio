package com.learnstudio.contentservice.pojo.reponse;

import com.learnstudio.contentservice.enums.CurrencyCode;
import com.learnstudio.contentservice.enums.Domain;
import com.learnstudio.contentservice.enums.ResourceAccess;
import com.learnstudio.contentservice.enums.ResourceType;
import com.learnstudio.contentservice.pojo.PriceTree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourcePriceResponse {

    private Double minAmount;

    private Double amount;

    private Double partialAmountPaid;

    private CurrencyCode currencyCode;

    private Integer fractionalUnits;

    private Domain domain;

    private PriceTree priceTree;

    private ResourceType resourceType;

    private Double exchangeRate;

    private List<Long> resourceCategoryIds;

    private ResourceAccess resourceAccess;
}
