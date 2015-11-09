package com.example.raven.testbabiescharts;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Raven on 2015-11-09.
 */
public class BabiesResult implements  JSONParsing {
    Babies babies;

    @Override
    public void parsing(JSONObject jobject) throws JSONException {
        babies = new Babies();
        JSONObject jbabies = jobject.getJSONObject("jbabies");
        babies.parsing(jbabies);
    }
}
