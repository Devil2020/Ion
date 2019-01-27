package com.example.mohammedmorsemorsefcis.ion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mohammedmorsemorsefcis.ion.Ion.IonBuilder;

public class PractiseActivity extends AppCompatActivity {
ImageView Gif;
RecyclerView Movies;
IonBuilder ion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);
        Gif=findViewById(R.id.GifImage);
        Movies =findViewById(R.id.RecyclerView);
        ion=new IonBuilder("Default",this);
        RecieveIntent(getIntent());
    }
    public void RecieveIntent(Intent intent){
        switch (intent.getAction()){
            case "Gif":
                if(Gif.getVisibility()== View.INVISIBLE){
                    Gif.setVisibility(View.VISIBLE);
                    Movies.setVisibility(View.INVISIBLE);

                }
                ion.SetUri("http://cdn.osxdaily.com/wp-content/uploads/2013/07/dancing-banana.gif");
                ion.LoadGif(Gif);
                break;
            case "Movies":
                ion.SetUri("https://api.github.com/search/repositories?q=android&sort=stars");
                ion.LoadJsonData();
                break;
            default:
                break;
        }
    }
}
