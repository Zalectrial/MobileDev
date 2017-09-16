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
        ImageView cake = (ImageView) findViewById(R.id.cake);
        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        ImageView smashed_avocado = (ImageView) findViewById(R.id.smashed_avocado);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String image = String.valueOf(v.getId());
                Intent intent = new Intent(getApplicationContext(), ImageDisplayActivity.class);
                intent.putExtra("imageName", image);
                startActivity(intent);
            }
        };

        ImageView[] images = {burger, cake, pizza, smashed_avocado};
        for (ImageView image: images) {
            image.setOnClickListener(clickListener);
        }
    }
}
