package com.diktes.ducksearch.datamodel.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Icon")
    @Expose
    private Icon icon;
    @SerializedName("FirstURL")
    @Expose
    private String firstURL;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Topics")
    @Expose
    private List<Result> topics;

    //GETTERS
    public Icon getIcon() {
        return icon;
    }
    public String getFirstURL() {
        return firstURL;
    }
    public String getText() {
        return text;
    }
    public String getName() {
        return name;
    }
    public List<Result> getTopics() {
        return topics;
    }
}
