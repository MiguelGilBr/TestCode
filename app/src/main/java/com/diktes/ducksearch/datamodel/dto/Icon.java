package com.diktes.ducksearch.datamodel.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {
    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("Height")
    @Expose
    private String height;
    @SerializedName("Width")
    @Expose
    private String width;

    //GETTERS
    public String getuRL() {
        return uRL;
    }
}
