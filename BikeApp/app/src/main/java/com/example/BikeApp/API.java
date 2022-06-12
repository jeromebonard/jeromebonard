package com.example.BikeApp;


import retrofit2.Call;

import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://public.opendatasoft.com/api/records/1.0/search/";
    @GET("?dataset=jcdecaux-bike-stations-data-rt&q=&facet=status&facet=contract_name")
    Call<Records> getRecords();
}
