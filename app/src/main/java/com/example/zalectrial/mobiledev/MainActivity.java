package com.example.zalectrial.mobiledev;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    public Image[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new Image[4];

        // Get all ImageViews from the layout
        ImageView burger = (ImageView) findViewById(R.id.burger);
        Image burgerImage = new Image("Burger", SystemClock.currentThreadTimeMillis());
        TextView burgerName = (TextView) findViewById(R.id.burger_name);
        burgerName.setText(burgerImage.name);
        TextView burgerDate = (TextView) findViewById(R.id.burger_date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        burgerDate.setText(format.format(burgerImage.date));
        images[0] = burgerImage;
        burger.setTag(0);

        ImageView cake = (ImageView) findViewById(R.id.cake);
        Image cakeImage = new Image("Cake", SystemClock.currentThreadTimeMillis());
        TextView cakeName = (TextView) findViewById(R.id.cake_name);
        cakeName.setText(cakeImage.name);
        TextView cakeDate = (TextView) findViewById(R.id.cake_date);
        cakeDate.setText(format.format(cakeImage.date));
        images[1] = cakeImage;
        cake.setTag(1);

        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        Image pizzaImage = new Image("Pizza", SystemClock.currentThreadTimeMillis());
        TextView pizzaName = (TextView) findViewById(R.id.pizza_name);
        pizzaName.setText(pizzaImage.name);
        TextView pizzaDate = (TextView) findViewById(R.id.pizza_date);
        pizzaDate.setText(format.format(pizzaImage.date));
        images[2] = pizzaImage;
        pizza.setTag(2);

        ImageView smashed_avocado = (ImageView) findViewById(R.id.smashed_avocado);
        Image smashedAvoImage = new Image("Smashed Avocado", SystemClock.currentThreadTimeMillis());
        TextView smashedAvoName = (TextView) findViewById(R.id.smashed_avo_name);
        smashedAvoName.setText(smashedAvoImage.name);
        TextView smashedAvoDate = (TextView) findViewById(R.id.smashed_avo_date);
        smashedAvoDate.setText(format.format(smashedAvoImage.date));
        images[3] = smashedAvoImage;
        smashed_avocado.setTag(3);

        // Create an onClickListener for the ImageViews
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create an intent the starts the FormActivity
                // Pass the necessary information to display the correct form data
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                int image = (int) v.getTag();
                intent.putExtra(String.valueOf(R.string.image), images[image]);
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