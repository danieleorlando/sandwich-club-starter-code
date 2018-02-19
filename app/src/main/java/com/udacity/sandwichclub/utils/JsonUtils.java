package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String JSON_SANDWICH_NAME = "name";
    public static final String JSON_SANDWICH_MAINNAME = "mainName";
    public static final String JSON_SANDWICH_PLACE = "placeOfOrigin";
    public static final String JSON_SANDWICH_DESCRIPTION = "description";
    public static final String JSON_SANDWICH_IMAGE = "image";
    public static final String JSON_SANDWICH_AKA = "alsoKnownAs";
    public static final String JSON_SANDWICH_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        try {
            Sandwich sandwich = new Sandwich();
            JSONObject jsonObject = new JSONObject(json);

            sandwich.setMainName(jsonObject.getJSONObject(JSON_SANDWICH_NAME).getString(JSON_SANDWICH_MAINNAME));
            sandwich.setPlaceOfOrigin(jsonObject.getString(JSON_SANDWICH_PLACE));
            sandwich.setDescription(jsonObject.getString(JSON_SANDWICH_DESCRIPTION));
            sandwich.setImage(jsonObject.getString(JSON_SANDWICH_IMAGE));

            List<String> listAKA = new ArrayList<>();
            JSONArray jsonArrayAKA = jsonObject.getJSONObject(JSON_SANDWICH_NAME).getJSONArray(JSON_SANDWICH_AKA);
            for (int i=0; i<jsonArrayAKA.length(); i++) {
                listAKA.add(jsonArrayAKA.get(i).toString());
            }
            sandwich.setAlsoKnownAs(listAKA);

            List<String> listIngredients = new ArrayList<>();
            JSONArray jsonArrayIngredients = jsonObject.getJSONArray(JSON_SANDWICH_INGREDIENTS);
            for (int i=0; i<jsonArrayIngredients.length(); i++) {
                listIngredients.add(jsonArrayIngredients.get(i).toString());
            }
            sandwich.setIngredients(listIngredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
