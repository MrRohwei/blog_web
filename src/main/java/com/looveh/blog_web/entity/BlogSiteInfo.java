package com.looveh.blog_web.entity;

public class BlogSiteInfo {
    private Integer id;

    private String siteTitle;

    private String siteSubTitle;

    private String siteIcon;

    private String siteLogo;

    private Boolean openRegist;

    private String siteKeyword;

    private String siteUrl;

    private String siteOwner;

    private String siteDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle == null ? null : siteTitle.trim();
    }

    public String getSiteSubTitle() {
        return siteSubTitle;
    }

    public void setSiteSubTitle(String siteSubTitle) {
        this.siteSubTitle = siteSubTitle == null ? null : siteSubTitle.trim();
    }

    public String getSiteIcon() {
        return siteIcon;
    }

    public void setSiteIcon(String siteIcon) {
        this.siteIcon = siteIcon == null ? null : siteIcon.trim();
    }

    public String getSiteLogo() {
        return siteLogo;
    }

    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo == null ? null : siteLogo.trim();
    }

    public Boolean getOpenRegist() {
        return openRegist;
    }

    public void setOpenRegist(Boolean openRegist) {
        this.openRegist = openRegist;
    }

    public String getSiteKeyword() {
        return siteKeyword;
    }

    public void setSiteKeyword(String siteKeyword) {
        this.siteKeyword = siteKeyword == null ? null : siteKeyword.trim();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public String getSiteOwner() {
        return siteOwner;
    }

    public void setSiteOwner(String siteOwner) {
        this.siteOwner = siteOwner == null ? null : siteOwner.trim();
    }

    public String getSiteDesc() {
        return siteDesc;
    }

    public void setSiteDesc(String siteDesc) {
        this.siteDesc = siteDesc == null ? null : siteDesc.trim();
    }
}