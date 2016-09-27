package com.demo.tranning.tranningdemo.services;

import com.demo.tranning.tranningdemo.models.Movie;
import com.demo.tranning.tranningdemo.uitilties.HttpUitilties;
import com.demo.tranning.tranningdemo.uitilties.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by michael on 9/7/2016.
 */
public class MovieService {
    public List<Movie> GetMovies() {
        List<Movie> movieResult = new Gson().fromJson(HttpUitilties.httpGet(null, Urls.MOVIESURL), new TypeToken<List<Movie>>(){}.getType());

        return movieResult;
    }
}
