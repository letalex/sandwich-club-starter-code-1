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

            JSONObject sandwichitems = new JSONObject(json);

            // click on name, mainName, alsoKnownAS array
            JSONObject name = sandwichItems.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAS = new ArrayList<>();


            // pull up loop thru alsoKnownAsArray and add items to array
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i) );
                 }
                 
                 //pull up placeOfOrgin, description, image

                 String placeOfOrgin = sandwich_menu.getString( "placeofOrgin" ) ;
                 String description = sandwich_menu.getString("description");
                 // pull up ingredients = sandwich_menu.getJSONArray( "ingredients" );
                 List<String> ingredientsList = new ArrayList<>();

                 for (int i = 0; i<ingredients.length() ; i++ ) );
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