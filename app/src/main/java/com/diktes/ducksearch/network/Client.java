package com.diktes.ducksearch.network;

import com.diktes.ducksearch.datamodel.dto.Search;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String TAG = Client.class.getSimpleName();

    public static final String API_BASE_URL = "http://api.duckduckgo.com"; //?q=<val>&format=json
    public static final String BASE_ENDPOINT = "/";

    public static final String SEARCH_PARAM = "q";
    public static final String FORMAT_PARAM = "format";
    public static final String FORMAT_PARAM_TYPE = "json";

    //STATIC
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                .baseUrl(API_BASE_URL)
                                                .addConverterFactory(GsonConverterFactory.create());

    private static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    //CONSTRUCTOR
    private Client() {}

    //SEARCH DATA
    public static void searchData(Callback<Search> callback, String searchValue) {
        ISearch search = Client.createService(ISearch.class);
        Call<Search> callSearchResult = search.searchData(BASE_ENDPOINT,searchValue,FORMAT_PARAM_TYPE);
        callSearchResult.enqueue(callback);
    }
}




