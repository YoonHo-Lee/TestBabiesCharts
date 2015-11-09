package com.example.raven.testbabiescharts;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Raven on 2015-11-09.
 */
public class Baby implements JSONParsing {
    String id;
    int gender;
    String birth;
    String name;

    @Override
    public void parsing(JSONObject jobject) throws JSONException {
        id = jobject.getString("id");
        gender = jobject.getInt("gender");
        birth = jobject.getString("birth");
        name = jobject.getString("name");
    }

    @Override
    public String toString() {
        return id + " / " + gender + " / " + birth + " / " + name;
    }
}
