package com.demo.tranning.tranningdemo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by michael on 9/7/2016.
 */
public class Movie {
    @SerializedName("DetailUrl")
    private String detailUrl;
    @SerializedName("Name")
    public String name;
    @SerializedName("Description")
    public String description;
    @SerializedName("Image")
    public String image ;
    @SerializedName("Grade")
    public String grade;
    @SerializedName("Director")
    public String director;
    @SerializedName("Story")
    public String story ;
    @SerializedName("Actor")
    public String actor ;

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
