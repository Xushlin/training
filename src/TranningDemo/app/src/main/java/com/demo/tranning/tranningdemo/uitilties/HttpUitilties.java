package com.demo.tranning.tranningdemo.uitilties;

import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static com.demo.tranning.tranningdemo.uitilties.Params.APPLICATION;
import static com.demo.tranning.tranningdemo.uitilties.Params.JSON;

/**
 * Created by michael on 9/7/2016.
 */
public class HttpUitilties {

    public static <T> String httpPost(T request, String url,String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<T> requestEntity = new HttpEntity<T>(request, buildHeaders(token));

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            String json = responseEntity.getBody();
            Log.i("json", json);

            return json;
        } catch (Exception e) {
            Log.i("URL", url);
            Log.d("err msg", e.getMessage());

            return null;
        }
    }

    public static <T> String httpGet(T request, String url) {

        Log.i("url", url);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<T> requestEntity = new HttpEntity<T>(request, buildHeaders(""));

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            String json = responseEntity.getBody();
            Log.i("json", json);

            return json;
        } catch (Exception e) {
            Log.i("err msg", e.getMessage());

            return null;
        }
    }

    public static HttpHeaders buildHeaders(String token) {
        HttpHeaders result = new HttpHeaders();
       // result.add("X-Auth-Token",token);
        result.setContentType(new MediaType(APPLICATION, JSON));

        return result;
    }

}
