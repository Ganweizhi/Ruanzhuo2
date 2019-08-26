package com.dgut.jsonBean;

/**
 * @author WuJiewei
 * 角色列表
 */
public class RoleListBean {

    private Integer id;
    private String name;
    private String pagePower;
    private String depPower;

    public Integer getRid() {
        return id;
    }

    public void setRid(Integer id) {
        this.id = id;
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
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pagePower='" + pagePower + '\'' +
                ", depPower='" + depPower + '\'' +
                '}';
    }
}
