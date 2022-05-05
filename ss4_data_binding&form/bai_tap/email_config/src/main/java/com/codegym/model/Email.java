package com.codegym.model;

public class Email {
    private String languages;
    private String pageSize;
    private Boolean spamsFillter;
    private String signature;

    public Email() {
    }

    public Email(String languages, String pageSize, Boolean spamsFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(Boolean spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
