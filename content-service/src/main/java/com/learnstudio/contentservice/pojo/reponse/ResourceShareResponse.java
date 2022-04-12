package com.learnstudio.contentservice.pojo.reponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceShareResponse {
    private String deeplink;
    private Boolean success;
}
