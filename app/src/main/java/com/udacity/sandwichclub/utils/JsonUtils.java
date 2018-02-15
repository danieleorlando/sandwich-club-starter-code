package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            Sandwich sandwich = new Sandwich();
            JSONObject jsonObject = new JSONObject(json);

            sandwich.setMainName(jsonObject.getJSONObject("name").getString("mainName"));
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setImage(jsonObject.getString("image"));

            List<String> listAKA = new ArrayList<>();
            JSONArray jsonArrayAKA = jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            for (int i=0; i<jsonArrayAKA.length(); i++) {
                listAKA.add(jsonArrayAKA.get(i).toString());
            }
            sandwich.setAlsoKnownAs(listAKA);

            List<String> listIngredients = new ArrayList<>();
            JSONArray jsonArrayIngredients = jsonObject.getJSONArray("ingredients");
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
