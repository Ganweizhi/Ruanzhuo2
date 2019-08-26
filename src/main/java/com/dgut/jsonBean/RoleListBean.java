package com.dgut.jsonBean;

/**
 * @author WuJiewei
 * 角色列表
 */
public class RoleListBean {

    private Integer rid;
    private String name;
    private String pagePower;
    private String depPower;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

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
        return "RoleListBean{" +
                "rid=" + rid +
                ", name='" + name + '\'' +
                ", pagePower='" + pagePower + '\'' +
                ", depPower='" + depPower + '\'' +
                '}';
    }
}
