package com.koala.apitesting.yaml;

import java.util.List;

public class Suite {

    private String description;
    private List<Step> steps;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getStepsLength () {
        return steps.size();
    }
}
