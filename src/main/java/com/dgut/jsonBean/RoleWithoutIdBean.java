package com.dgut.jsonBean;

import java.io.Serializable;

/**
 * @author WuJiewei
 * 用于接收/roleadd页面传送过来的json
 */
public class RoleWithoutIdBean implements Serializable {

    private String name;
    private String pagePower;
    private String depPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPagePower() {
        return pagePower;
    }

    public void setPagePower(String pagePower) {
        this.pagePower = pagePower;
    }

    public String getDepPower() {
        return depPower;
    }

    public void setDepPower(String depPower) {
        this.depPower = depPower;
    }

    @Override
    public String toString() {
        return "RoleWithoutIdBean{" +
                "name='" + name + '\'' +
                ", pagePower='" + pagePower + '\'' +
                ", depPower='" + depPower + '\'' +
                '}';
    }
}
