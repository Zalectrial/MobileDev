package com.example.zalectrial.mobiledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all ImageViews from the layout
        // Set the ImageView tag so we can present the image in the detail activity
        ImageView burger = (ImageView) findViewById(R.id.burger);
        burger.setTag(R.drawable.burger);
        ImageView cake = (ImageView) findViewById(R.id.cake);
        cake.setTag(R.drawable.cake);
        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        pizza.setTag(R.drawable.pizza);
        ImageView smashed_avocado = (ImageView) findViewById(R.id.smashed_avocado);
        smashed_avocado.setTag(R.drawable.smashed_avocado);

        // Create an onClickListener for the ImageViews
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create an intent the starts the ImageDisplayActivity
                // Pass the necessary information to display the correct image
                Intent intent = new Intent(getApplicationContext(), ImageDisplayActivity.class);
                intent.putExtra(getString(R.string.imageName), (Integer) v.getTag());
                intent.putExtra(getString(R.string.imageDesc), v.getContentDescription());
                startActivity(intent);
            }
        };

        // Add the onClickListener for all ImageViews in the layout
        ImageView[] images = {burger, cake, pizza, smashed_avocado};
        for (ImageView image: images) {
            image.setOnClickListener(clickListener);
        }
    }
}
