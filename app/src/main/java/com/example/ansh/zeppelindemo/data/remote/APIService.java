package com.example.ansh.zeppelindemo.data.remote;

/**
 * Created by Ansh on 2/11/2018.
 */

import com.example.ansh.zeppelindemo.data.model.RestResponseInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    /**
     * This method is responsible for doing post request to the server.
     *
     * @param line_no - Line number for which the process is going on.
     * @param temperature - Temperature required for the process line.
     * @param pressure - Pressure required for the process line.
     * @param humidity - Humidity required for the process line.
     * @param time - Time required for the process line.
     * @param material - List of input materials to the input line process.
     */
    @POST("/process_info")
    @FormUrlEncoded
    Call<RestResponseInfo> getProcessInfo(@Field("line_no") String line_no,
                                          @Field("temperature") String temperature,
                                          @Field("pressure") String pressure,
                                          @Field("humidity") String humidity,
                                          @Field("time") String time,
                                          @Field("material") String[] material
                                         );
}
