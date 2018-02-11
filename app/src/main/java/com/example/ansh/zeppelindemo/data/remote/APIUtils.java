package com.example.ansh.zeppelindemo.data.remote;

/**
 * Created by Ansh on 2/11/2018.
 */

public class APIUtils {
    private APIUtils() {}

    /**
     * Base url specified for the server connection.
     */
    public static final String BASE_URL = "http://192.168.1.101:3000/";

    /**
     * Creation of the service for the background data http requests.
     * @return
     */
    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
