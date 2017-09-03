package com.diktes.ducksearch.network;

import com.diktes.ducksearch.datamodel.dto.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ISearch {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET
    Call<Search> searchData(@Url String url, @Query(Client.SEARCH_PARAM) String searchValue, @Query(Client.FORMAT_PARAM) String format);
}
