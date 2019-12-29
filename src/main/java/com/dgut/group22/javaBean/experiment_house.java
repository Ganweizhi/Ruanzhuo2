package com.dgut.group22.javaBean;

public class experiment_house {
    int experiment_id;
    String experiment_huanj;
    String experiment_operation;
    String experiment_xit;
    int resource_id;

    public int getExperiment_id() {
        return experiment_id;
    }

    public void setExperiment_id(int experiment_id) {
        this.experiment_id = experiment_id;
    }

    public String getExperiment_huanj() {
        return experiment_huanj;
    }

    public void setExperiment_huanj(String experiment_id_huanj) {
        this.experiment_huanj = experiment_id_huanj;
    }

    public String getExperiment_operation() {
        return experiment_operation;
    }

    public void setExperiment_operation(String experiment_operation) {
        this.experiment_operation = experiment_operation;
    }

    public String getExperiment_xit() {
        return experiment_xit;
    }

    public void setExperiment_xit(String experiment_xit) {
        this.experiment_xit = experiment_xit;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    @Override
    public String toString() {
        return "experiment_house{" +
                "experiment_id=" + experiment_id +
                ", experiment_id_huanj='" + experiment_huanj + '\'' +
                ", experiment_operation='" + experiment_operation + '\'' +
                ", experiment_xit='" + experiment_xit + '\'' +
                ", resource_id=" + resource_id +
                '}';
    }
}
