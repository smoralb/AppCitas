package com.example.sergiomoral.appcitas.data.manager.network.models;

import com.example.sergiomoral.appcitas.data.manager.network.models.remote.ApiService;
import com.example.sergiomoral.appcitas.data.manager.network.models.remote.RetrofitClient;

/**
 * Created by sergiomoral on 14/2/18.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://appointments-tfg.firebaseio.com/";

    public static ApiService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
