
package com.example.ansh.zeppelindemo.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestResponseInfo {

    @SerializedName("success")
    @Expose
    private List<PostProcessInfo> success = null;

    public List<PostProcessInfo> getSuccess() {
        return success;
    }

    public void setSuccess(List<PostProcessInfo> success) {
        this.success = success;
    }

}
