package com.diktes.ducksearch.datamodel;

import com.diktes.ducksearch.datamodel.dto.Result;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private static DataModel instance;
    private List<Result> results = new ArrayList<>();
    private List<String> recentSearches = new ArrayList<>();

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    private DataModel() {
    }

    //API
    public void addSearch(String search) {
        recentSearches.add(search);
    }
    public String[] getRecentSearchArray() {
        return recentSearches.toArray(new String[0]);
    }
    public String getLastSearch() {
        if (recentSearches.size() > 0) {
            return recentSearches.get(recentSearches.size()-1);
        } else {
            return "";
        }
    }

    //GETTERS & SETTERs
    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
    public List<String> getRecentSearches() {
        return recentSearches;
    }
    public void setRecentSearches(List<String> recentSearches) {
        this.recentSearches = recentSearches;
    }
}
