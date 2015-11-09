package com.example.raven.testbabiescharts;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raven on 2015-11-09.
 */
public class Babies implements JSONParsing {
    @SerializedName("baby")
    List<Baby> babyList;

    @Override
    public void parsing(JSONObject jobject) throws JSONException {
        babyList = new ArrayList<Baby>();
        JSONArray array = jobject.getJSONArray("babyList");
        for(int i = 0; i < array.length(); i++)   {
            JSONObject jbaby = array.getJSONObject(i);
            Baby b = new Baby();
            b.parsing(jbaby);
            babyList.add(b);
        }
    }
}
