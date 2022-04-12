package com.learnstudio.contentservice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMeta {
    private Boolean isWatched;
    private Integer watchedTimestampSeconds;
    private Integer maxWatchedTimestampSeconds;
    private Boolean isPurchased;
    private Date expiresAt;
    private Boolean isFreeLesson;
    private Boolean isWatchable;
    private Boolean isNotifyLaterSubscribed = false;
    private String completionCertificateUrl;
    private Long batchId;
    private String batchChatGroupId;
    private CourseBatchView courseBatch;
    private Long complimentaryDurationMins;
}

