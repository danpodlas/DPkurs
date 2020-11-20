package pl.dan.qa.qaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model {

    @JsonProperty(required = true)
    public String produce;

    @JsonProperty("screen.size")
    public double screenSize;

    @Override
    public String toString() {
        return "Model{" +
                "produce='" + produce + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
