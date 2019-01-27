package com.example.mohammedmorsemorsefcis.ion.Ion;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class IonBuilder {
    private String Uri ;
    private Context context;
    JsonObject Data;
    public IonBuilder(String Uri , Context context)
    {
        this.Uri=Uri;
        this.context=context;
        Data=new JsonObject();
    }
    public void SetUri(String Uri){
        this.Uri=Uri;
    }
    public void LoadGif(ImageView imageGif){
        Ion.with(imageGif).load(Uri);
    }
    public JsonObject LoadJsonData(){

        Ion.with(context).load(Uri).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {

                Log.i("Morse", "onCompleted: "+Data.toString());
            }
        });
        return Data;
    }
}
