package com.learnstudio.contentservice.pojo.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.learnstudio.contentservice.enums.Domain;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstructorView extends BaseView {

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    private String description;

    private String descriptionSummary;

    @NotNull
    private Domain domain;

    private List<String> tags;

    @NotNull
    private Boolean isActive;

    @NotBlank
    private String slug;

    private Links links;

    @NotNull
    private ImageBanners imageBanners;

    private List<Achievement> achievements;

    private List<Qualification> qualifications;

    private Double rating;

    private Long userId;

    private Long communityId;

    private InstructorType instructorType;

    private ExpertiseLevel expertiseLevel;

    private String zoomLink;

    private InstructorMetadata metadata;

    @JsonDeserialize(using = InstructorCategoryMappingViewSortedSetDeserializer.class)
    private SortedSet<InstructorCategoryMappingView> instructorCategoryMappingViews;

    @JsonDeserialize(using = InstructorTimeSlotSortedMapDeserializer.class)
    private SortedMap<DayOfWeek, SortedSet<InstructorTimeSlot>> dayWiseTimeSlots;

}
