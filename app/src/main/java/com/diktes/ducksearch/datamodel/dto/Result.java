package com.diktes.ducksearch.datamodel.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
}
