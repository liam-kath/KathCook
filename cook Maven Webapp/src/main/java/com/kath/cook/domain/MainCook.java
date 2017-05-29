package com.kath.cook.domain;

import java.util.List;

public class MainCook {
    private Integer id;

    private Integer userId;

    private String cookName;

    private String cookImage;

    private String cookShicai;

    private String cookYongliang;

    private String cookBuzhouImage;

    private String cookBuzouMiaoshu;

    private String createTime;

    private String updateTime;

    private Integer display;

    private String test1;

    private String test2;

    private String test3;

    private String test4;
    
    private List<FoodsCook> listfFoodsCooks;
    
    private List<TepCook> listTepCooks;

    public List<FoodsCook> getListfFoodsCooks() {
		return listfFoodsCooks;
	}

	public void setListfFoodsCooks(List<FoodsCook> listfFoodsCooks) {
		this.listfFoodsCooks = listfFoodsCooks;
	}

	public List<TepCook> getListTepCooks() {
		return listTepCooks;
	}

	public void setListTepCooks(List<TepCook> listTepCooks) {
		this.listTepCooks = listTepCooks;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName == null ? null : cookName.trim();
    }

    public String getCookImage() {
        return cookImage;
    }

    public void setCookImage(String cookImage) {
        this.cookImage = cookImage == null ? null : cookImage.trim();
    }

    public String getCookShicai() {
        return cookShicai;
    }

    public void setCookShicai(String cookShicai) {
        this.cookShicai = cookShicai == null ? null : cookShicai.trim();
    }

    public String getCookYongliang() {
        return cookYongliang;
    }

    public void setCookYongliang(String cookYongliang) {
        this.cookYongliang = cookYongliang == null ? null : cookYongliang.trim();
    }

    public String getCookBuzhouImage() {
        return cookBuzhouImage;
    }

    public void setCookBuzhouImage(String cookBuzhouImage) {
        this.cookBuzhouImage = cookBuzhouImage == null ? null : cookBuzhouImage.trim();
    }

    public String getCookBuzouMiaoshu() {
        return cookBuzouMiaoshu;
    }

    public void setCookBuzouMiaoshu(String cookBuzouMiaoshu) {
        this.cookBuzouMiaoshu = cookBuzouMiaoshu == null ? null : cookBuzouMiaoshu.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
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