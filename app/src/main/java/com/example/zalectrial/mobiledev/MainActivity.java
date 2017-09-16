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

        ImageView burger = (ImageView) findViewById(R.id.burger);
        burger.setTag(R.drawable.burger);
        ImageView cake = (ImageView) findViewById(R.id.cake);
        cake.setTag(R.drawable.cake);
        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        pizza.setTag(R.drawable.pizza);
        ImageView smashed_avocado = (ImageView) findViewById(R.id.smashed_avocado);
        smashed_avocado.setTag(R.drawable.smashed_avocado);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageDisplayActivity.class);
                intent.putExtra("imageName", (Integer) v.getTag());
                startActivity(intent);
            }
        };

        ImageView[] images = {burger, cake, pizza, smashed_avocado};
        for (ImageView image: images) {
            image.setOnClickListener(clickListener);
        }
    }
}
