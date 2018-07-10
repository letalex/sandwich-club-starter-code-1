package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;


import org.json.JSONArray;
import org.json.JOSNException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        
        try {

            JSONObject sandwich_menu = new JSONObject(json);

            // pull up name, mainName

            JSONObject name = sandwich_menu.getJSONObject("name");
            String mainName = name.getString("mainName");

           //pull up alsoKnownAs array and we can use 'for loop' to reach object in the array
            
           JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
           List<String> alsoKnownAS = new ArrayList<>();


             for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i) );
                 }
                 // pull up placeOfOrgin, description, image

                 String placeOfOrgin = sandwich_menu.getString( "placeofOrgin" ) ;
                 String description = sandwich_menu.getString("description");
                 String image = sandwich_menu.getString( "image" );
                 
                 // pull up ingredients array and we should use 'for loop' to reach objects in the array
                 
                 JSONArray ingredients = sandwich_menu.getJSONArray("ingredients");
                 List<String> ingredientsList = new ArrayList<>();

                 for (int i = 0; i<ingredients.length(); i++ ) { 
                    ingredientsList.add( ingredients.getString( i ) ); 
                } 
                  // return a new sandwich
                  return new Sandwich(mainName, alsoKnownAsList, placeOfOrgin, description, image, ingredientsList );
 
                }
                   catch (JOSNException e)  {
                       e.printStackTrace();
        return null;
 
    }

}

}