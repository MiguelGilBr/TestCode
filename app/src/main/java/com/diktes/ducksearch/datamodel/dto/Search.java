package com.diktes.ducksearch.datamodel.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("DefinitionSource")
    @Expose
    private String definitionSource;
    @SerializedName("Heading")
    @Expose
    private String heading;
    @SerializedName("ImageWidth")
    @Expose
    private Integer imageWidth;
    @SerializedName("RelatedTopics")
    @Expose
    private List<Result> relatedTopics = null;
    @SerializedName("Entity")
    @Expose
    private String entity;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Redirect")
    @Expose
    private String redirect;
    @SerializedName("DefinitionURL")
    @Expose
    private String definitionURL;
    @SerializedName("AbstractURL")
    @Expose
    private String abstractURL;
    @SerializedName("Definition")
    @Expose
    private String definition;
    @SerializedName("AbstractSource")
    @Expose
    private String abstractSource;
    @SerializedName("Infobox")
    @Expose
    private String infobox;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("ImageIsLogo")
    @Expose
    private Integer imageIsLogo;
    @SerializedName("Abstract")
    @Expose
    private String _abstract;
    @SerializedName("AbstractText")
    @Expose
    private String abstractText;
    @SerializedName("AnswerType")
    @Expose
    private String answerType;
    @SerializedName("ImageHeight")
    @Expose
    private Integer imageHeight;
    @SerializedName("Answer")
    @Expose
    private String answer;
    @SerializedName("Results")
    @Expose
    private List<Result> results = null;

    //GETTERS & SETTERS
    public List<Result> getRelatedTopics() {
        return relatedTopics;
    }
}
