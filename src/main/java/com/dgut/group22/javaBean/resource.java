package com.dgut.group22.javaBean;

public class resource {
    int resource_id;
    int success_id;
    String resource_textbook;
    String resource_video;
    String resource_base;
    String resource_experiment;
    String resource_document;

    @Override
    public String toString() {
        return "resource{" +
                "resource_id=" + resource_id +
                ", success_id=" + success_id +
                ", resource_textbook='" + resource_textbook + '\'' +
                ", resource_video='" + resource_video + '\'' +
                ", resource_base='" + resource_base + '\'' +
                ", resource_experiment='" + resource_experiment + '\'' +
                ", resource_document='" + resource_document + '\'' +
                '}';
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getSuccess_id() {
        return success_id;
    }

    public void setSuccess_id(int success_id) {
        this.success_id = success_id;
    }

    public String getResource_textbook() {
        return resource_textbook;
    }

    public void setResource_textbook(String resource_textbook) {
        this.resource_textbook = resource_textbook;
    }

    public String getResource_video() {
        return resource_video;
    }

    public void setResource_video(String resource_video) {
        this.resource_video = resource_video;
    }

    public String getResource_base() {
        return resource_base;
    }

    public void setResource_base(String resource_base) {
        this.resource_base = resource_base;
    }

    public String getResource_experiment() {
        return resource_experiment;
    }

    public void setResource_experiment(String resource_experiment) {
        this.resource_experiment = resource_experiment;
    }

    public String getResource_document() {
        return resource_document;
    }

    public void setResource_document(String resource_document) {
        this.resource_document = resource_document;
    }
}
