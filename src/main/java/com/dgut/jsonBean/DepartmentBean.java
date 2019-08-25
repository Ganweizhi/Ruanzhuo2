package com.dgut.jsonBean;

public class DepartmentBean {

    private String label;
    private String value;

    public DepartmentBean(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public DepartmentBean() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DepartmentBean{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
