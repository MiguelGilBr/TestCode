package com.diktes.ducksearch.datamodel;

import com.diktes.ducksearch.datamodel.dto.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DataModel {

    private static DataModel instance;
    private String lastSearch = "Real Madrid";
    private List<Result> results = new ArrayList<>();
    private HashSet<String> recentSearches = new HashSet<>();

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    private DataModel() {
    }

    //API
    public List<Result> getAllResults (){
        List<Result> allResults = new ArrayList<>();
        for (Result result: results) {
            if (result.getName() == null) {
                allResults.add(result);
            } else if (result.getTopics() != null){
                allResults.addAll(result.getTopics());
            }
        }
        return allResults;
    }
    public void addSearch(String search) {
        recentSearches.add(search);
    }
    public String[] getRecentSearchArray() {
        return recentSearches.toArray(new String[0]);
    }

    //GETTERS & SETTERs
    public String getLastSearch() {
        return lastSearch;
    }
    public void setLastSearch(String lastSearch) {
        this.lastSearch = lastSearch;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
}
