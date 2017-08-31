package com.diktes.ducksearch.datamodel;

import com.diktes.ducksearch.datamodel.dto.Result;
import com.diktes.ducksearch.datamodel.dto.Search;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private static DataModel instance;
    private List<Result> results = new ArrayList<>();
    private List<Search> recentSearchs = new ArrayList<>();

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    private DataModel() {
    }

    //GETTERS & SETTERs
}
