package com.diktes.ducksearch.network;

import okhttp3.OkHttpClient;
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
    public static void getPopularMovies(Callback<SearchResultMovie> callback) {
        getMovies(callback,ENDPOINT_POPULAR);
    }
    public static void getTopMovies(Callback<SearchResultMovie> callback) {
        getMovies(callback,ENDPOINT_TOP);
    }
    private static void getMovies(Callback<SearchResultMovie> callback, String endPoint) {
        IMovies movies = Client.createService(IMovies.class);
        Call<SearchResultMovie> callSearchResult = movies.getMovies(endPoint,API_KEY);
        callSearchResult.enqueue(callback);
    }
    //GET REVIEWS
    public static void getMovieReviews(Callback<SearchResultReview> callback, String movieId) {
        IMovies movies = Client.createService(IMovies.class);
        Call<SearchResultReview> callSearchResult = movies.getMovieReviews(movieId + "/" + ENDPOINT_REVIEW,API_KEY);
        callSearchResult.enqueue(callback);
    }
    //GET VIDEOS
    public static void getMovieVideos(Callback<SearchResultVideo> callback, String movieId) {
        IMovies movies = Client.createService(IMovies.class);
        Call<SearchResultVideo> callSearchResult = movies.getMovieVideos(movieId + "/" + ENDPOINT_VIDEO,API_KEY);
        callSearchResult.enqueue(callback);
    }
}




