package com.kath.cook.domain;

import java.util.List;

public class TepCook {
    private Integer id;

    private Integer cookId;

    private String tepLink;

    private String cookTepDetail;

    private String test1;

    private String test2;

    private String test3;

    private String test4;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }

    public String getTepLink() {
        return tepLink;
    }

    public void setTepLink(String tepLink) {
        this.tepLink = tepLink == null ? null : tepLink.trim();
    }

    public String getCookTepDetail() {
        return cookTepDetail;
    }

    public void setCookTepDetail(String cookTepDetail) {
        this.cookTepDetail = cookTepDetail == null ? null : cookTepDetail.trim();
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1 == null ? null : test1.trim();
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2 == null ? null : test2.trim();
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3 == null ? null : test3.trim();
    }

    public String getTest4() {
        return test4;
    }

    public void setTest4(String test4) {
        this.test4 = test4 == null ? null : test4.trim();
    }
}