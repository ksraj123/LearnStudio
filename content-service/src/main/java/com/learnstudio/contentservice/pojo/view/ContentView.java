package com.learnstudio.contentservice.pojo.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentView extends BaseView {

    @NotBlank
    private String name;

    private String description;

    private List<String> tags;

    private Long moduleId;

    private Long courseId;

    private CourseView course;

    private List<SubtitleView> subtitleViewList;

    @NotNull
    private MediaType mediaType;

    @NotNull
    private ContentType contentType;

    @NotNull
    private Integer sortOrder;

    @NotNull
    private PricingType pricingType;

    @NotNull
    private CurrencyCode currencyCode = CurrencyCode.INR;

    @NotNull
    private Integer fractionalUnits;

    @NotNull
    private Double price = 0d;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date endDate;

    @NotNull
    private String displayPrice;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private transient Double exchangeRate;

    @NotNull
    private String currencySymbol;

    private Integer appleTier;

    @NotBlank
    private String resourceUrl;

    @NotNull
    private ResourceMeta resourceMeta;

    @NotNull
    private ImageBanners imageBanners;

    private String roomId;

    private String roomLinkUrl;

    private RoomLinkSource roomLinkSource;

    private String deeplink;

    private Map<String, String> redirect;

    private UserMeta userMeta;
}
