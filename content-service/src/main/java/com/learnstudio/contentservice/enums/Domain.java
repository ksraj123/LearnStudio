package com.learnstudio.contentservice.enums;

public enum Domain {
    FRONTROW("https://www.learnstudio.co.in"),
    CONNECT("https://www.learnstudio.in"),
    ALL("https://www.learnstudio.co.in");

    private final String domainUrl;

    Domain(String domainUrl){
        this.domainUrl = domainUrl;
    }

    public String getDomainUrl() {
        return domainUrl;
    }
}
