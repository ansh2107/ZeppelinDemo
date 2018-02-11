
package com.example.ansh.zeppelindemo.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostProcessInfo {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("line_no")
    @Expose
    private String lineNo;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("material")
    @Expose
    private List<String> material = null;
    @SerializedName("grade_output")
    @Expose
    private String gradeOutput;
    @SerializedName("weight")
    @Expose
    private String weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getMaterial() {
        return material;
    }

    public void setMaterial(List<String> material) {
        this.material = material;
    }

    public String getGradeOutput() {
        return gradeOutput;
    }

    public void setGradeOutput(String gradeOutput) {
        this.gradeOutput = gradeOutput;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
