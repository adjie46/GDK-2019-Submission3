package com.adjiekurniawan.sumbission3_dicoding.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootModel<T> {

    @SerializedName("results")
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

}
