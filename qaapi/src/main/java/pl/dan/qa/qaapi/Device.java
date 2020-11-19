package pl.dan.qa.qaapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {

    @JsonProperty(required = true)
    public String type;

    @JsonProperty(value = "device.model", required = true)
    public List<Model> deviceModel;

    @Override
    public String toString() {
        return "Device{" +
                "type='" + type + '\'' +
                ", deviceModel=" + deviceModel +
                '}';
    }
}
