package com.example.ansh.zeppelindemo.data.remote;

/**
 * Created by Ansh on 2/11/2018.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    /**
     *  This method creates a retrofit client.
     *
     * @param baseUrl - url for connection to the server.
     * @return
     */
    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
