package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

 import org.w3c.dom.Text;

 import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);
        //get Textviews by ID
        TextView also_known_tv = findViewById(R.id.also_known_tv);
        TextView originTv = findViewById(R.id.origin_tv);
        TextView descriptionTv = findViewById(R.id.description_tv);
        TextView ingredientsTv = findViewById(R.id.ingredients_tv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);


        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }
         //pass Sandwich object to populateUI
        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }


    private void populateUI(Sandwich sandwich) {
 
        // set to text alsoKnownAs
              
              TextView also_known_tv = findViewById( R.id.also_known_tv );
              if (sandwich.getAlsoKnownAs() !=null && !sandwich.getAlsoKnownAs().isEmpty()){
                for ( int i =0; i<sandwich.getAlsoKnownAs().size(); i++) {
                 also_known_tv.append(sandwich.getAlsoKnownAs().get(i) + "," );
                    also_known_tv.append(",");
                           
}


}

 /// set to text place of origin

 TextView originTv = findViewById( R.id.origin_tv );
    if  (sandwich.getPlaceOfOrigin() !=null && !sandwich.getPlaceOfOrigin().isEmpty()){
        for ( int i =0; i<sandwich.getPlaceOfOrigin().size(); i++) {
            originTv.append(sandwich.getPlaceOfOrigin().get(i) + "," );
            originTv.append(",");


 TextView descriptionTv = findViewById( R.id.description_tv );
                            if  (sandwich.getDescription() !=null && !sandwich.getDescription().isEmpty()){
                                for ( int i =0; i<sandwich.getDescription().size(); i++) {
                                    descriptionTv.append(sandwich.getDescription().get(i) + "\n" );
                                    originTv.append("\n");
   TextView ingredientsTv = findViewById( R.id.ingredients_tv );
                                    if  (sandwich.getIngredients() !=null && !sandwich.getIngredients().isEmpty()){
                                        for ( int i=0; i<sandwich.getIngredients().size(); i++) {
                                            ingredientsTv.append(sandwich.getIngredients().get(i) + "\n" );
                                            ingredientsTv.append("\n");
