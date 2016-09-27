package com.demo.tranning.tranningdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.demo.tranning.tranningdemo.models.Movie;
import com.demo.tranning.tranningdemo.services.MovieService;
import com.demo.tranning.tranningdemo.uitilties.DialogUitls;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    ListView mListView;
    List<Movie> mMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mListView=(ListView) findViewById(R.id.listViewMovie);
        DialogUitls.showProgressDialog(MovieActivity.this, "Loading...",
                R.drawable.icon, true);
        new Thread(runnable).start();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Movie movie= (Movie) adapterView.getAdapter().getItem(i);

                Intent intent=new Intent(MovieActivity.this,MovieDetailActivity.class);
                intent.putExtra("movie",new Gson().toJson(movie));

                startActivity(intent);
            }
        });
    }

    private void BindData(){
        mListView.setAdapter(new MovieAdapter(MovieActivity.this,mMovies));
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what ==1) {
                BindData();
                DialogUitls.closeProgressDialog();
            } else  {
                DialogUitls.closeProgressDialog();
                Toast.makeText(MovieActivity.this, "get data from API failuar",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    Runnable runnable = new Runnable() {
        @SuppressWarnings("unused")
        @Override
        public void run() {

            final MovieService movieService = new MovieService();

            mMovies = movieService.GetMovies();

            Message msg = new Message();

            if (mMovies != null) {
                msg.what = 1;
            } else {
                msg.what =2;
            }
            handler.sendMessage(msg);
        }
    };
}
