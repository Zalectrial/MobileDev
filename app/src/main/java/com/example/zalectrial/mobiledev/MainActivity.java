package com.example.zalectrial.mobiledev;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static Image[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new Image[4];
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        // Get all ImageViews from the layout
        ImageView burger = (ImageView) findViewById(R.id.burger);
        Image burgerImage = new Image("Burger", Calendar.getInstance().getTimeInMillis());
        images[0] = burgerImage;
        TextView burgerName = (TextView) findViewById(R.id.burger_name);
        burgerName.setText(images[0].name);
        TextView burgerDate = (TextView) findViewById(R.id.burger_date);
        burgerDate.setText(format.format(images[0].date));
        burger.setTag(0);

        ImageView cake = (ImageView) findViewById(R.id.cake);
        Image cakeImage = new Image("Cake", Calendar.getInstance().getTimeInMillis());
        images[1] = cakeImage;
        TextView cakeName = (TextView) findViewById(R.id.cake_name);
        cakeName.setText(images[1].name);
        TextView cakeDate = (TextView) findViewById(R.id.cake_date);
        cakeDate.setText(format.format(images[1].date));
        cake.setTag(1);

        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        Image pizzaImage = new Image("Pizza", Calendar.getInstance().getTimeInMillis());
        images[2] = pizzaImage;
        TextView pizzaName = (TextView) findViewById(R.id.pizza_name);
        pizzaName.setText(images[2].name);
        TextView pizzaDate = (TextView) findViewById(R.id.pizza_date);
        pizzaDate.setText(format.format(images[2].date));
        pizza.setTag(2);

        ImageView smashed_avocado = (ImageView) findViewById(R.id.smashed_avocado);
        Image smashedAvoImage = new Image("Smashed Avocado", Calendar.getInstance().getTimeInMillis());
        images[3] = smashedAvoImage;
        TextView smashedAvoName = (TextView) findViewById(R.id.smashed_avo_name);
        smashedAvoName.setText(images[3].name);
        TextView smashedAvoDate = (TextView) findViewById(R.id.smashed_avo_date);
        smashedAvoDate.setText(format.format(images[3].date));
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

    @Override
    protected void onResume() {
        super.onResume();

    }
}